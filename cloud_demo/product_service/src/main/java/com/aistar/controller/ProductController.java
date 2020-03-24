package com.aistar.controller;

import com.aistar.pojo.Product;
import com.aistar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class ProductController {
    @Value("${server.port}")
    private int port;

    @Autowired
    private ProductService productService;

    /**
     * 获得所有商品列表
     *
     * @return
     */
    @GetMapping("/product")
    public List<Product> list() {
        return productService.getall();
    }


    /**
     * 根据id查找商品
     *
     * @param id 指定商品id
     * @return 返回查找的对应商品对象
     */
    @GetMapping("/product/{id}")
    public Product getById(@PathVariable("id") String id) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Product product = productService.getById(id);
        System.out.println("product" + product + "数据来源的端口："+port);

        return product;
    }

}