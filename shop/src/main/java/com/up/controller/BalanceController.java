package com.up.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("balance")
public class BalanceController {

    @RequestMapping("tiaozhuan")
    public String tiaozhuan(){

        return "forward:index.jsp";

    }
}
