package com.increff.employee.controller;

import com.increff.employee.model.AboutAppData;
import com.increff.employee.service.AboutAppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class AboutAppController {

    @Autowired
    AboutAppService aboutAppService;

    @ApiOperation(value ="Gets about")
    @RequestMapping(path = "/api/about",method = RequestMethod.GET)
    public AboutAppData getAboutApp(){
        AboutAppData d = new AboutAppData();
        d.setName(aboutAppService.getName());
        d.setVersion(aboutAppService.getVersion());
        return d;
    }
}
