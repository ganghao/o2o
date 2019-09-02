package com.hhhh.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhhh.o2o.entity.Product;

public interface ProductDao {

    /**
     * 查询商品列表并分页，可输入的条件有：商品名（模糊查询），商品状态，店铺Id，商品类别
     * @param productCondition
     * @param rowIndex
     * @param pageSize
     * @return
     */
    List<Product> queryProductList(@Param("productCondition") Product productCondition, @Param("rowIndex") int rowIndex,
            @Param("pageSize") int pageSize);
    
    /**
     * 查询对应商店的商品总数
     * @param productCondition
     * @return
     */
    int queryProductCount(@Param("productCondition") Product productCondition);

    /**
     * 通过商品Id查询商品
     * @param productId
     * @return
     */
    Product queryProductById(long productId);

    /**
     * 插入商品
     * 
     * @param product
     * @return
     */
    int insertProduct(Product product);
    
    /**
     * 更新商品信息
     * @param product
     * @return
     */
    int updateProduct(Product product);
    
    /**
     * 删除商品类别之前，将商品类别Id置为空
     * @param productCategoryId
     * @return
     */
    int updateProductCategoryToNull(long productCategoryId);
}
