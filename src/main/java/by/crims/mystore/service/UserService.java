package by.crims.mystore.service;

import by.crims.mystore.entity.Role;
import by.crims.mystore.entity.User;
import by.crims.mystore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean save(User user) {
        Role role = user.getRoles().stream().findFirst().get();
        Optional<User> userOpt =  userRepository.findByEmailAndRoles(user.getEmail(), role.name() );
        if(userOpt.isPresent()){
            return false;
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> byUsername = userRepository.findByUsername(s);
        if (byUsername.isPresent()){
            return byUsername.get();
        } else {
            throw new UsernameNotFoundException("Unknown user by email: " + s);
        }
    }

    public boolean updateUserFirstName(User user, String firstName){
        if(user.getFirstName().equals(firstName)){
            return false;
        }else {
            Optional<User> userOpt = userRepository.findById(user.getId());
            if (userOpt.isPresent()) {
                User userBase = userOpt.get();
                userBase.setFirstName(firstName);
                userRepository.save(userBase);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean updateUserLastName(User user, String lastName){
        if(user.getLastName().equals(lastName)){
            return false;
        } else {
            Optional<User> userOpt = userRepository.findById(user.getId());
            if (userOpt.isPresent()) {
                User userBase = userOpt.get();
                userBase.setLastName(lastName);
                userRepository.save(userBase);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean updateUserPicture(User user, String picture){
        if(user.getPicture().equals(picture)){
            return false;
        }else {
            Optional<User> userOpt = userRepository.findById(user.getId());
            if (userOpt.isPresent()) {
                User userBase = userOpt.get();
                userBase.setPicture(picture);
                userRepository.save(userBase);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean updateUserPassword(String oldPassword, String newPassword, String confirmPassword, User user){
        if (checkPassword(user.getPassword(), oldPassword) && !oldPassword.equals(newPassword)) {
            if (checkPassword(newPassword, confirmPassword)) {
                Optional<User> userOpt = userRepository.findById(user.getId());
                if (userOpt.isPresent()) {
                    User userBase = userOpt.get();
                    userBase.setPassword(passwordEncoder.encode(user.getPassword()));
                    userRepository.save(userBase);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean updateUserTelephone(User user, String number){
        if(user.getTelephone().getNumber().equals(number)){
            return false;
        }else {
            Optional<User> userOpt = userRepository.findById(user.getId());
            if (userOpt.isPresent()) {
                User userBase = userOpt.get();
                userBase.getTelephone().setNumber(number);
                userRepository.save(userBase);
                return true;
            } else {
                return false;
            }
        }
    }

    public User getCurrentUser(){
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    public Optional<User> getUserById(long idUser){
        return userRepository.findById(idUser);
    }

    private boolean checkPassword(String newPassword, String confirmPassword) {
        return newPassword.equals(confirmPassword);
    }
}
