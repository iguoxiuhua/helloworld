package com.nettyrpc.test.app;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.nettyrpc.client.RpcClient;
import com.nettyrpc.registry.ServiceDiscovery;
import com.nettyrpc.test.client.HelloService;
import com.nettyrpc.test.client.Person;

public class AppClient {

    @Autowired
   // private static RpcClient rpcClient;
	
	public static void main(String[] args) {
    	

        ServiceDiscovery serviceDiscovery = new ServiceDiscovery("127.0.0.1:2181");
        final RpcClient rpcClient = new RpcClient(serviceDiscovery);
        
    	
        HelloService helloService = rpcClient.create(HelloService.class);
        Person person = new Person("Yong", "Huang");
        String result = helloService.hello(person);
//        Assert.assertEquals("Hello! Yong Huang", result);
		System.out.println("result ="+ result);
		rpcClient.stop();
        
        
	}
		
}
