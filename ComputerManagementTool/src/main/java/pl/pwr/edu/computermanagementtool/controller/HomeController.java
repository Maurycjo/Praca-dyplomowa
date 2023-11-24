package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

}
