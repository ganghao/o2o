package com.hhhh.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hhhh.o2o.BaseTest;
import com.hhhh.o2o.dto.ImageHolder;
import com.hhhh.o2o.dto.ShopExecution;
import com.hhhh.o2o.entity.Area;
import com.hhhh.o2o.entity.PersonInfo;
import com.hhhh.o2o.entity.Shop;
import com.hhhh.o2o.entity.ShopCategory;
import com.hhhh.o2o.enums.ShopStateEnum;
import com.hhhh.o2o.exceptions.ShopOperationException;

public class ShopServiceTest extends BaseTest{
	@Autowired
	private ShopService shopService;
	
	@Test
	@Ignore
	public void testModifyShop() throws ShopOperationException, FileNotFoundException{
	    Shop shop = new Shop();
	    shop.setShopId(1L);
	    shop.setShopName("修改后的店铺名称");
	    File shopImg = new File("/home/hr/图片/dabai.jpeg");
	    InputStream is = new FileInputStream(shopImg);
	    ImageHolder thumbnail = new ImageHolder("dabai.jpeg", is);
	    ShopExecution shopExecution = shopService.modifyShop(shop, thumbnail);
	    System.out.println("新的图片地址" + shopExecution.getShop().getShopImg());
	}
	
	@Test
	public void testAddShop() throws FileNotFoundException {
		Shop shop = new Shop();
		PersonInfo owener = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owener.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);
//		shop.setOwener(owener);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试的店铺3");
		shop.setShopDesc("test3");
		shop.setShopAddr("test3");
		shop.setPhone("test3");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");
		File shopImg = new File("/home/hr/图片/xiaohuangren.jpg");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder thumbnail = new ImageHolder(shopImg.getName(), is);
		ShopExecution se = shopService.addShop(shop, thumbnail);
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
	}
	
	@Test
	@Ignore
	public void testGetShopList() {
        Shop shopCondition = new Shop();
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(1L);
        shopCondition.setShopCategory(sc);
        ShopExecution shopExecution = shopService.getShopList(shopCondition, 3, 2);
        System.out.println("店铺列表数：" + shopExecution.getShopList().size());
        System.out.println("店铺总数：" + shopExecution.getCount());
	}
}
