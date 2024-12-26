package org.example.kdtspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LeafController {

    @GetMapping("leaf")
    public String leaf(Model model) {
        // list
        List<String> list = new ArrayList<>();
        list.add("hong");
        list.add("kim");

        // int
        int age = 15;

        // String
        String userId = "root";

        model.addAttribute("title", "타임리프 테스트");
        model.addAttribute("list", list);       // list. 주소를 전달
        model.addAttribute("age", age);         // int. 값을 전달
        model.addAttribute("userId", userId);   // String. 주소를 전달

        return "example/leaf";
    }

    @GetMapping("leaf2")
    public String leaf2(Model model) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        int total = list.size();
        String userId = "admin";

        model.addAttribute("title", "타임리프 예제");
        model.addAttribute("list", list);
        model.addAttribute("total", total);
        model.addAttribute("userId", userId);

        return "example/leaf2";
    }
}
