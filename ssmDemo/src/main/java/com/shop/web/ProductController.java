package com.shop.web;

import com.shop.domain.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired  //自动装配注入业务逻辑层
    private ProductService productService;

    @RequestMapping(value = "/product")
    public ModelAndView getProduct() {
        List<Product> list = productService.getProductList();
        System.out.println("size:" + list.size());
        //要把list数据封装到ModeAndView对象中保存
        ModelAndView modelAndView = new ModelAndView();
        //封装数据
        modelAndView.addObject("productList", list);
        //封装逻辑视图名
        modelAndView.setViewName("productList");
        return modelAndView;
    }
}
