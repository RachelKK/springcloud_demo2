package com.aistar.serrvice;

import com.aistar.fallback.ProductCLientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 商品服务客户端
 */
@FeignClient(name="productService",fallback = ProductCLientFallback.class)
public interface ProductClient {
    @GetMapping("/product/{id}")
    String getById(@PathVariable("id")String id);
}
