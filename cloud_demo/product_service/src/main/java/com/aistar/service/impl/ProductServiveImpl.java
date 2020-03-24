package com.aistar.service.impl;

import com.aistar.pojo.Product;
import com.aistar.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiveImpl implements ProductService {

    private static List<Product> productList = new ArrayList<>();

    //模拟数据库中Product数据，存储在内存中
    static {
        productList.add(new Product("1001", "杯子", 88888L, 100f));
        productList.add(new Product("1002", "书包", 99998L, 200F));
        productList.add(new Product("1003", "钢笔", 777778L, 300F));
        productList.add(new Product("1004", "橡皮", 66668L, 400F));
        productList.add(new Product("1005", "铅笔", 55558L, 500F));
        productList.add(new Product("1006", "直尺", 44448L, 600F));
        productList.add(new Product("1007", "圆规", 333338L, 700F));
        productList.add(new Product("1008", "胶带", 222228L, 800F));
    }

    @Override
    public List<Product> getall() {
        return productList;
    }

    @Override
    public Product getById(String id) {
        for (Product product : productList) {
            if (product.getProId().equals(id))
                return product;
        }
        return null;
    }
}
