package com.company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class MainController {

    @GetMapping("")

    public String showHomePage()
    {
        System.out.println("Main controller");
        return "index";
    }

}
