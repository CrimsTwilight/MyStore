package by.crims.mystore.controller;

import by.crims.mystore.entity.Role;
import by.crims.mystore.entity.User;
import by.crims.mystore.service.UserService;
import by.crims.mystore.utils.ControllerMessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public ModelAndView reg(ModelAndView modelAndView){
        modelAndView.setViewName("reg");
        modelAndView.addObject("newUser", new User());
        return modelAndView;
    }

    @PostMapping("/reg")
    public ModelAndView reg(@ModelAttribute("newUser") User user, ModelAndView modelAndView){
        modelAndView.setViewName("reg");
        userService.save(user);
        return modelAndView;
    }

    @GetMapping("/auth")
    public ModelAndView auth(ModelAndView modelAndView){
        modelAndView.setViewName("auth");
        return modelAndView;
    }
}