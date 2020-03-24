package com.aistar.fallback;

import com.aistar.serrvice.ProductClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 商品服务的降级处理
 */
@Component
public class ProductCLientFallback implements ProductClient {
    public  String getById(String id){
        System.out.println("feign 调用product-service getById 异常");
        return null;
    }
}
