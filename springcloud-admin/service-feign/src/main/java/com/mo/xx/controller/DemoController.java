package com.mo.xx.controller;

import com.mo.xx.feigninterface.HiInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2019/4/26.
 */
@RestController
public class DemoController {
    @Autowired
    HiInterface hiInterface;
    @RequestMapping("/hi")
    public String hi(){

        return hiInterface.sayHiFrom();
    }
}
