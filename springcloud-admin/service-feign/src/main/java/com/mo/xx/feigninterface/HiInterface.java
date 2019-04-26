package com.mo.xx.feigninterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 2019/4/26.
 */
@FeignClient(value = "service-hi")
public interface HiInterface {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
   String sayHiFrom();

}
