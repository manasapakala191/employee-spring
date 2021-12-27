package com.increff.employee.controller;

import com.increff.employee.model.InfoData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UIController {

    @RequestMapping(value = "")
    public ModelAndView index(){
        return mav("index.html");
    }

    @RequestMapping(value = "ui/home")
    public ModelAndView home(){
        return mav("home.html");
    }

    @RequestMapping(value = "ui/features")
    public ModelAndView features(){
        return mav("features.html");
    }

    @RequestMapping(value = "ui/pricing")
    public ModelAndView pricing(){
        return mav("pricing.html");
    }

    private static ModelAndView mav(String page){
        ModelAndView mav = new ModelAndView(page);
        mav.addObject("info",new InfoData());
        return mav;
    }

}
