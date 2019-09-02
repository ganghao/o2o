package com.hhhh.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主要用来解析路由并转发到相应的html中
 * 
 * @author hr
 *
 */
@Controller
@RequestMapping(value = "/shopadmin")
public class ShopAdminController {
    @RequestMapping(value = "/test")
    public String test() {
        System.out.println("=========test===============");
        return "test";
    }

    @RequestMapping(value = "/shopoperation")
    public String shopOperation() {
        System.out.println("=========shop/shopoperation===============");
        return "shop/shopoperation";
    }

    @RequestMapping(value = "/shoplist")
    public String shopList() {
        System.out.println("=========shop/shoplist===============");
        return "shop/shoplist";
    }

    @RequestMapping(value = "/shopmanagement")
    public String shopManagement() {
        System.out.println("=========shop/shopmanagement===============");
        return "shop/shopmanagement";
    }

    @RequestMapping(value = "/productcategorymanagement")
    public String productCategoryManage() {
        System.out.println("=========shop/productcategorymanagement===============");
        return "shop/productcategorymanagement";
    }
    
    @RequestMapping(value = "/productoperation")
    public String productOperation() {
        System.out.println("=========shop/productoperation===============");
        // 转发商品添加/编辑页面
        return "shop/productoperation";
    }
    
    @RequestMapping(value = "/productmanagement")
    public String productManagement() {
        System.out.println("=========shop/productmanagement===============");
        // 转发商品添加/编辑页面
        return "shop/productmanagement";
    }

}
