package com.xujian.eureka.service;

import java.util.List;

import com.xujian.eureka.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

	@Autowired
	private LoadBalancerClient loadBalancerClient; //ribbon负载均衡器
	
	public List<User> getUsers(){
			//选择调用的服务的名称
		//ServiceInstance 封装了服务的基本信息，如 IP，端口
		ServiceInstance si = this.loadBalancerClient.choose("eureka-provider");
		//拼接访问服务的URL
		StringBuffer sb = new StringBuffer();
		//http://localhost:9090/user
		sb.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/user");
		
		
		//springMVC RestTemplate
		RestTemplate rt = new RestTemplate();
		
		ParameterizedTypeReference<List<User>> type = new ParameterizedTypeReference<List<User>>() {};
		
		//ResponseEntity:封装了返回值信息
		ResponseEntity<List<User>> response = rt.exchange(sb.toString(),HttpMethod.GET, null, type);
		List<User> list =response.getBody();
		return list;
	}
}
