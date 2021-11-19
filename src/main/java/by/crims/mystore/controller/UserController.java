package by.crims.mystore.controller;

import by.crims.mystore.dto.telephoneDTO.NumberTelDTO;
import by.crims.mystore.dto.userDTO.*;
import by.crims.mystore.entity.User;
import by.crims.mystore.service.UserService;
import by.crims.mystore.utils.ControllerMessageManager;
import by.crims.mystore.utils.ConverterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/userInfo")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserById/{id}")
    public ModelAndView updateFirstName(@PathVariable long id, ModelAndView modelAndView) {
        modelAndView.setViewName("userInfo");
        Optional<User> userInfoOpt = userService.getUserById(id);
        if(userInfoOpt.isPresent()){
            UserInfoDTO userInfoDTO = ConverterDTO.getUserInfoCard(userInfoOpt.get());
            modelAndView.addObject("userInfoDTO", userInfoDTO);
        }
        return modelAndView;
    }

    @GetMapping("/updFirstName")
    public ModelAndView updateFirstName(ModelAndView modelAndView) {
        modelAndView.setViewName("updateFirstName");
        modelAndView.addObject("userNameDTO", new FirstNameUserDTO());
        return modelAndView;
    }

    @PostMapping("/updFirstName")
    public ModelAndView updateFirstName(@Valid @ModelAttribute("userNameDTO") FirstNameUserDTO firstNameDTO,
                                        BindingResult bindingResult, ModelAndView modelAndView) {
        modelAndView.setViewName("updateFirstName");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }else{
            User user = userService.getCurrentUser();
            if (userService.updateUserFirstName(user, firstNameDTO.getFirstName())) {
                user.setFirstName(firstNameDTO.getFirstName());
                modelAndView.addObject("messageFirstName", ControllerMessageManager.UPDATE_NAME_SUCCESSFULLY);
            } else {
                modelAndView.addObject("messageFirstName", ControllerMessageManager.UPDATE_NAME_FAIL);
            }
        }
        return modelAndView;
    }

    @GetMapping("/updLastName")
    public ModelAndView updateLastName(ModelAndView modelAndView) {
        modelAndView.setViewName("updLastName");
        modelAndView.addObject("userLastNameDTO", new LastNameUserDTO());
        return modelAndView;
    }

    @PostMapping("/updLastName")
    public ModelAndView updateLastName(@Valid @ModelAttribute("userLastNameDTO") LastNameUserDTO lastNameDTO,
                                       BindingResult bindingResult, ModelAndView modelAndView) {
        modelAndView.setViewName("updLastName");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }else{
            User user = userService.getCurrentUser();
            if (userService.updateUserLastName(user, lastNameDTO.getLastName())) {
                user.setLastName(lastNameDTO.getLastName());
                modelAndView.addObject("messageLastName", ControllerMessageManager.UPDATE_LAST_NAME_SUCCESSFULLY);
            } else {
                modelAndView.addObject("messageLastName", ControllerMessageManager.UPDATE_LAST_NAME_FAIL);
            }
        }
        return modelAndView;
    }

    @GetMapping("/updPicture")
    public ModelAndView updatePicture(ModelAndView modelAndView) {
        modelAndView.setViewName("updPicture");
        modelAndView.addObject("userPictureDTO", new EmailUserDTO());
        return modelAndView;
    }

    @PostMapping("/updPicture")
    public ModelAndView updatePicture(@Valid @ModelAttribute("userPictureDTO") PictureUserDTO pictureDTO,
                                      BindingResult bindingResult, ModelAndView modelAndView) {
        modelAndView.setViewName("updPicture");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }else{
            User user = userService.getCurrentUser();
            if (userService.updateUserPicture(user, pictureDTO.getPicture())) {
                user.setPicture(pictureDTO.getPicture());
                modelAndView.addObject("messagePicture", ControllerMessageManager.UPDATE_PICTURE_SUCCESSFULLY);
            } else {
                modelAndView.addObject("messagePicture", ControllerMessageManager.UPDATE_PICTURE_FAIL);
            }
        }
        return modelAndView;
    }

    @GetMapping("/updTelephone")
    public ModelAndView updateTelephone(ModelAndView modelAndView) {
        modelAndView.setViewName("updTelephone");
        modelAndView.addObject("userTelephoneDTO", new NumberTelDTO());
        return modelAndView;
    }

    @PostMapping("/updTelephone")
    public ModelAndView updatePicture(@Valid @ModelAttribute("userPictureDTO") NumberTelDTO numberTelDTO,
                                      BindingResult bindingResult, ModelAndView modelAndView) {
        modelAndView.setViewName("updTelephone");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }else{
            User user = userService.getCurrentUser();
            if (userService.updateUserTelephone(user, numberTelDTO.getTelephone())) {
                user.getTelephone().setNumber(numberTelDTO.getTelephone());
                modelAndView.addObject("messageTelephone", ControllerMessageManager.UPDATE_TEL_SUCCESSFULLY);
            } else {
                modelAndView.addObject("messageTelephone", ControllerMessageManager.UPDATE_TEL_FAIL);
            }
        }
        return modelAndView;
    }
}