package by.crims.mystore.utils;

import by.crims.mystore.dto.cardDTO.ProductCardDTO;
import by.crims.mystore.dto.productDTO.AllArgsProductDTO;
import by.crims.mystore.dto.telephoneDTO.NumberTelDTO;
import by.crims.mystore.dto.userDTO.AllArgsUserDTO;
import by.crims.mystore.dto.userDTO.UserInfoDTO;
import by.crims.mystore.dto.userDTO.UsernamePasswordUserDTO;
import by.crims.mystore.entity.Product;
import by.crims.mystore.entity.Role;
import by.crims.mystore.entity.Telephone;
import by.crims.mystore.entity.User;

import java.util.*;

public class ConverterDTO {

    public static User getAllArgsUsersDTO(AllArgsUserDTO allArgsUserDTO) {
        Set<Role> roleSet = new HashSet<>();
        Role role = allArgsUserDTO.getRole();
        roleSet.add(role);
        return User.builder()
                .roles(roleSet)
                .username(allArgsUserDTO.getUsername())
                .firstName(allArgsUserDTO.getFirstName())
                .lastName(allArgsUserDTO.getLastName())
                .email(allArgsUserDTO.getEmail())
                .password(allArgsUserDTO.getPassword())
                .telephone(Telephone.builder()
                        .number(allArgsUserDTO.getTelephone())
                        .build())
                .picture(allArgsUserDTO.getPicture())
                .build();
    }


    public static User getUsernamePasswordUserDTO(UsernamePasswordUserDTO usernamePasswordUserDTO) {
        return User.builder()
                .username(usernamePasswordUserDTO.getUsername())
                .password(usernamePasswordUserDTO.getPassword())
                .build();
    }


    public static Telephone getTelDTO(NumberTelDTO numberTelDTO) {
        return Telephone.builder()
                .number(numberTelDTO.getTelephone())
                .build();
    }


    public static Telephone getTelDTO(String number) {
        return Telephone.builder()
                .number(number)
                .build();
    }

    public static UserInfoDTO getUserInfoCard (User user){
        return  UserInfoDTO.builder().user(User.builder().username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .telephone(user.getTelephone())
                .picture(user.getPicture())
                .build())
                .build();
    }

    public static ProductCardDTO getProductCardDto(Product product){
        return ProductCardDTO.builder()
                .product(product)
                .build();
    }

    public static Product getAllArgsProductsDTO(AllArgsProductDTO allArgsProductDTO){
        return Product.builder()
                .name(allArgsProductDTO.getName())
                .description(allArgsProductDTO.getDescription())
                .category(allArgsProductDTO.getCategory())
                .picture(allArgsProductDTO.getPicture())
                .price(allArgsProductDTO.getPrice())
                .reservedStatus(false)
                .saleStatus(true)
                .build();
    }
}
