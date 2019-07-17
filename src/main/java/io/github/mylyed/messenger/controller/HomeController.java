package io.github.mylyed.messenger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lilei
 * created at 2019/7/16
 */
@Controller
public class HomeController {

    @GetMapping("")
    public String index(@RequestParam String userid, Model model) {
        model.addAttribute("userid", userid);
        return "im";
    }

    @GetMapping("demo")
    public String demo() {
        return "demo";
    }
}
