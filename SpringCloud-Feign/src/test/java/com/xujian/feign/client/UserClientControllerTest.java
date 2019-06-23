package com.xujian.feign.client;

import com.xujian.feign.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserClientControllerTest {
    @Mock
    UserClientService userApi;
    @InjectMocks
    UserClientController userClientController;

    @Test
    public void testGetUserInfo() throws Exception {
//        User result = userApi.getByName("xujian");
        User result = userClientController.getUserInfo("xujian");
        System.out.println(result.toString());
        Assert.assertEquals(new User(null, "获取用户：xujian", null), result);
    }
}
