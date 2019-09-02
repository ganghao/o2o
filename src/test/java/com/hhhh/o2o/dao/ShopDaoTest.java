package com.hhhh.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hhhh.o2o.BaseTest;
import com.hhhh.o2o.entity.Area;
import com.hhhh.o2o.entity.PersonInfo;
import com.hhhh.o2o.entity.Shop;
import com.hhhh.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    @Ignore
    public void testInsertShop() {
        Shop shop = new Shop();
        PersonInfo owener = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owener.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwener(owener);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum = shopDao.insertShop(shop);
        assertEquals(1, effectedNum);
    }

    @Test
    @Ignore
    public void testUpdateShop() {
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopDesc("测试描述");
        shop.setShopAddr("测试地址");
        shop.setLastEditTime(new Date());
        int effectedNum = shopDao.updateShop(shop);
        assertEquals(1, effectedNum);
    }

    @Test
    @Ignore
    public void testQueryByShopId() {
        long shopId = 1;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println("areaId: " + shop.getArea().getAreaId());
        System.out.println("areaName: " + shop.getArea().getAreaName());
    }

    @Test
    @Ignore
    public void testQueryShopCount() {
        Shop shopCondition = new Shop();
        PersonInfo owener = new PersonInfo();
        owener.setUserId(1L);
        shopCondition.setOwener(owener);
        int count = shopDao.queryShopCount(shopCondition);
        System.out.println("店铺总数：" + count);
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(1L);
        shopCondition.setShopCategory(sc);
        count = shopDao.queryShopCount(shopCondition);
        System.out.println("店铺总数：" + count);
    }

    @Test
    @Ignore
    public void testQueryShopList() {
        Shop shopCondition = new Shop();
        PersonInfo owener = new PersonInfo();
        owener.setUserId(1L);
        shopCondition.setOwener(owener);
        List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 5);
        System.out.println("店铺列表的大小： " + shopList.size());
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(1L);
        shopCondition.setShopCategory(sc);
        shopList = shopDao.queryShopList(shopCondition, 0, 2);
        System.out.println("店铺列表的大小： " + shopList.size());
    }
    
    @Test
    public void testQueryShopListAndCount() {
        Shop shopCondition = new Shop();
        ShopCategory childCategory = new ShopCategory();
        ShopCategory parentCategory = new ShopCategory();
        parentCategory.setShopCategoryId(5L);
        childCategory.setParent(parentCategory);
        shopCondition.setShopCategory(childCategory);

        List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 7);
        int count = shopDao.queryShopCount(shopCondition);
        System.out.println("店铺列表的大小：" + shopList.size());
        System.out.println("店铺总数：" + count);
    }
}
