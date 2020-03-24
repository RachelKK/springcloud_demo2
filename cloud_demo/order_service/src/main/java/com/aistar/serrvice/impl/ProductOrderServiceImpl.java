package com.aistar.serrvice.impl;

import com.aistar.pojo.ProductOrder;
import com.aistar.serrvice.ProductClient;
import com.aistar.serrvice.ProductOrderService;
import com.aistar.util.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    /*@Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancer;*/

    @Autowired
    private ProductClient productClient;


    @Override
    public ProductOrder save(int userId, String productId) {
       /* String url = "http://productService/product/"+productId;
       Map productMap =  this.restTemplate.getForObject(url, Map.class);
        System.out.println(productMap);

        Object obj  =  this.restTemplate.getForObject(url, Object.class);
        System.out.println("obj :" + obj );

        ServiceInstance instance = loadBalancer.choose("productService");
        URI storesUri = URI.create(String.format("https://%s:%s", instance.getHost(), instance.getPort()));*/

        String response =  productClient.getById(productId);
        JsonNode jsonNode =  JsonUtils.string2JsonNode(response);
        System.out.println("jsonNode: " + jsonNode);

        //订单中调用用户服务，用户名或用户头像，用户积分等

        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setProductName(jsonNode.get("proName").toString());
        productOrder.setPrice(Double.valueOf(jsonNode.get("proPrice").toString()));
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        return productOrder;
    }
}
