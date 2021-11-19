package by.crims.mystore.controller;

import by.crims.mystore.dto.cardDTO.ProductCardDTO;
import by.crims.mystore.dto.productDTO.AllArgsProductDTO;
import by.crims.mystore.dto.productDTO.NameProductDTO;
import by.crims.mystore.dto.userDTO.UserInfoDTO;
import by.crims.mystore.entity.CategoryOfProduct;
import by.crims.mystore.entity.Product;
import by.crims.mystore.entity.User;
import by.crims.mystore.service.ProductService;
import by.crims.mystore.utils.ControllerMessageManager;
import by.crims.mystore.utils.ConverterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/add")
    public ModelAndView addProduct(ModelAndView modelAndView) {
        modelAndView.setViewName("addProduct");
        modelAndView.addObject("categories", Arrays.asList(CategoryOfProduct.values()));
        modelAndView.addObject("newProduct", new AllArgsProductDTO());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addProduct(@Valid @ModelAttribute("newProduct") AllArgsProductDTO productDTO,
                                     BindingResult bindingResult, ModelAndView modelAndView){
        modelAndView.setViewName("addProduct");
        if (!bindingResult.hasErrors()) {
            Product product = ConverterDTO.getAllArgsProductsDTO(productDTO);
            if (productService.save(product)) {
                modelAndView.addObject("messageReg1", ControllerMessageManager.REG_SUCCESSFULLY);
            } else {
                modelAndView.addObject("messageReg2", ControllerMessageManager.REG_FAIL);
            }
        }
        return modelAndView;
    }
    @GetMapping("/udpName/{id}")
    public ModelAndView updateName(ModelAndView modelAndView) {
        modelAndView.setViewName("updName");
        modelAndView.addObject("productNameDTO", new NameProductDTO());
        return modelAndView;
    }

    @PostMapping("/updName")
    public ModelAndView updateName(@Valid @ModelAttribute("nameDTO") NameProductDTO nameProductDTO,
                             BindingResult bindingResult, ModelAndView modelAndView) {
        modelAndView.setViewName("updName");
        if (!bindingResult.hasErrors()) {
            return modelAndView;
        } else {
        }
        return modelAndView;
    }

    @GetMapping("/getProductById/{id}")
    public ModelAndView getProductById(@PathVariable long id, ModelAndView modelAndView) {
        modelAndView.setViewName("product");
        Optional<Product> product = productService.getById(id);
        if(product.isPresent()){
            ProductCardDTO productCardDTO = ConverterDTO.getProductCardDto(product.get());
            modelAndView.addObject("card", productCardDTO);
        }
        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView getAll(ModelAndView modelAndView) {
        modelAndView.setViewName("catalog");
        Optional<List<Product>> products = Optional.ofNullable(productService.getAll());
        products.ifPresent(productList -> modelAndView.addObject("listProd", productList));
        return modelAndView;
    }
}
