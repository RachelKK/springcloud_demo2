package com.aistar.controller;

import com.aistar.pojo.ProductOrder;
import com.aistar.serrvice.ProductOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductOrderController {
    @Autowired
    private ProductOrderService productOrderService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/myorder")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(int userId,String productId, HttpServletRequest request){
       /* System.out.println("userid :"+userId +",productId:"+productId);
        ProductOrder order =  productOrderService.save(userId,productId);
        return order;*/
        Map<String,Object> data = new HashMap<>();
        data.put("code",0);
        data.put("data", productOrderService.save(userId,productId));
        return data;

    }


    //注意：方法名一定与api方法一致
    private Object saveOrderFail(int userId, String productId, HttpServletRequest request){
        //监控警报
        String saveOrderkey = "save-order";
        String sendValue = redisTemplate.opsForValue().get(saveOrderkey);
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(StringUtils.isBlank(sendValue)){
                    System.out.println("紧急短信，用户下订单失败，请离开查找原因,IP地址是：" + request.getRemoteAddr());
                    redisTemplate.opsForValue().set(saveOrderkey,"save-order-fail");
                }else{
                    System.out.println("已经发送过短信，20s内不重复发送");
                }
            }
        }).start();




        Map<String,Object> msg = new HashMap<>();
        msg.put("code",-1);
        msg.put("msg","抢购人数太多，您被挤出来了，请稍后重试");
        return msg;
    }


}
