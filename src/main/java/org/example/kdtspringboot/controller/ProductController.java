package org.example.kdtspringboot.controller;

import org.example.kdtspringboot.vo.ProductVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("product")
    public String product() {
        System.out.println("product GET 요청 발생");
        return "product/product";
    }

    @GetMapping("product2")
    public String product2(ProductVO productVO, Model model) {
        model.addAttribute("id", productVO.getId());
        model.addAttribute("price", productVO.getPrice());

        return "product/product2";
    }
}
