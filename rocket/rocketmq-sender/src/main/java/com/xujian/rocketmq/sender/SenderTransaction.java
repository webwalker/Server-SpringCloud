package com.xujian.rocketmq.sender;

import com.xujian.rocketmq.config.RocketMQConfig;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xujian on 2019-07-01
 */
@Component
public class SenderTransaction implements CommandLineRunner {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void run(String... args) {
        System.out.println("SenderTransaction......");

        String[] tags = new String[]{"TagA", "TagB", "TagC", "TagD", "TagE"};
        for (int i = 0; i < 10; i++) {
            try {

                Message msg = MessageBuilder
                        .withPayload("Hello RocketMQ " + i + ", I'm from transaction message.").
                        setHeader(RocketMQHeaders.TRANSACTION_ID, "KEY_" + i)
                        .build();
                SendResult sendResult = rocketMQTemplate.sendMessageInTransaction(RocketMQConfig.TOPIC_GROUP3,
                        RocketMQConfig.TOPIC3 + ":" + tags[i % tags.length], msg, null);
                System.out.printf("------ send Transactional msg body = %s , sendResult=%s %n", msg.getPayload(), sendResult.getSendStatus());

                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //可以不指定事务组，默认用系统配置的
    @RocketMQTransactionListener(txProducerGroup = RocketMQConfig.TOPIC_GROUP3,
            accessKey = "", // if not setting, it will read by `rocketmq.producer.access-key` key
            secretKey = "")
    class TransactionListenerImpl implements RocketMQLocalTransactionListener {
        private AtomicInteger transactionIndex = new AtomicInteger(0);

        private ConcurrentHashMap<String, Integer> localTrans = new ConcurrentHashMap<String, Integer>();

        @Override
        public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
            String transId = (String) msg.getHeaders().get(RocketMQHeaders.TRANSACTION_ID);
            System.out.printf("#### executeLocalTransaction is executed, msgTransactionId=%s %n",
                    transId);
            int value = transactionIndex.getAndIncrement();
            int status = value % 3;
            localTrans.put(transId, status);
            if (status == 0) {
                // Return local transaction with success(commit), in this case,
                // this message will not be checked in checkLocalTransaction()
                System.out.printf("    # COMMIT # Simulating msg %s related local transaction exec succeeded! ### %n", msg.getPayload());
                return RocketMQLocalTransactionState.COMMIT;
            }

            if (status == 1) {
                // Return local transaction with failure(rollback) , in this case,
                // this message will not be checked in checkLocalTransaction()
                System.out.printf("    # ROLLBACK # Simulating %s related local transaction exec failed! %n", msg.getPayload());
                return RocketMQLocalTransactionState.ROLLBACK;
            }

            System.out.printf("    # UNKNOW # Simulating %s related local transaction exec UNKNOWN! \n");
            return RocketMQLocalTransactionState.UNKNOWN;
        }

        @Override
        public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
            String transId = (String) msg.getHeaders().get(RocketMQHeaders.TRANSACTION_ID);
            RocketMQLocalTransactionState retState = RocketMQLocalTransactionState.COMMIT;
            Integer status = localTrans.get(transId);
            if (null != status) {
                switch (status) {
                    case 0:
                        retState = RocketMQLocalTransactionState.UNKNOWN;
                        break;
                    case 1:
                        retState = RocketMQLocalTransactionState.COMMIT;
                        break;
                    case 2:
                        retState = RocketMQLocalTransactionState.ROLLBACK;
                        break;
                }
            }
            System.out.printf("------ !!! checkLocalTransaction is executed once," +
                            " msgTransactionId=%s, TransactionState=%s status=%s %n",
                    transId, retState, status);
            return retState;
        }
    }
}
