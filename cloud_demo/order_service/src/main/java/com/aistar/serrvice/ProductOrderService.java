package com.aistar.serrvice;

import com.aistar.pojo.ProductOrder;

public interface ProductOrderService {
    public ProductOrder save(int userId, String productId);
}
