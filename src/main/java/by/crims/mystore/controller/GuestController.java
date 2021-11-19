package by.crims.mystore.controller;

import by.crims.mystore.dto.userDTO.AllArgsUserDTO;
import by.crims.mystore.entity.Role;
import by.crims.mystore.entity.User;
import by.crims.mystore.service.UserService;
import by.crims.mystore.utils.ControllerMessageManager;
import by.crims.mystore.utils.ConverterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public ModelAndView registration(ModelAndView modelAndView){
        modelAndView.setViewName("registration");
        modelAndView.addObject("roles", Arrays.asList(Role.values()));
        modelAndView.addObject("newUser", new AllArgsUserDTO());
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registration(@Valid @ModelAttribute("newUser") AllArgsUserDTO userDTO,
                                     BindingResult bindingResult, ModelAndView modelAndView){
        modelAndView.setViewName("registration");
        if (!bindingResult.hasErrors()) {
            User user = ConverterDTO.getAllArgsUsersDTO(userDTO);
            if (userService.save(user)) {
                modelAndView.addObject("messageReg1", ControllerMessageManager.REG_SUCCESSFULLY);
            } else {
                modelAndView.addObject("messageReg2", ControllerMessageManager.REG_FAIL);
            }
        }
        return modelAndView;
    }

    @GetMapping("/authorization")
    public ModelAndView authorization(ModelAndView modelAndView){
        modelAndView.setViewName("authorization");
        return modelAndView;
    }
}
