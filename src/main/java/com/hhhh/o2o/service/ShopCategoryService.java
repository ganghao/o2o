package com.hhhh.o2o.service;

import java.util.List;

import com.hhhh.o2o.entity.ShopCategory;

public interface ShopCategoryService {
    
    /**
     * 根据查询条件返回shopCategory列表
     * 
     * @param shopCategoryCondition
     * @return
     */
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
