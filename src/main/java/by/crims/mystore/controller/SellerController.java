package by.crims.mystore.controller;

import by.crims.mystore.entity.User;
import by.crims.mystore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

//@Controller
//@RequestMapping("/user")
//public class SellerController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/reg")
//    public ModelAndView reg(ModelAndView modelAndView){
//        modelAndView.setViewName("reg");
//        modelAndView.addObject("newUser", new User());
//        return modelAndView;
//    }
//
//    @PostMapping("/reg")
//    public ModelAndView reg(@Valid @ModelAttribute("newUser") User user, ModelAndView modelAndView){
//        modelAndView.setViewName("reg");
//        userService.save(user);
//        return modelAndView;
//    }
//
//    @GetMapping("/auth")
//    public ModelAndView auth(ModelAndView modelAndView){
//        modelAndView.setViewName("auth");
//        return modelAndView;
//    }
//}
