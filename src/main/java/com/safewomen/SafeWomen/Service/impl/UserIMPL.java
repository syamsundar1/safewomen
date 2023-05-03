package com.safewomen.SafeWomen.Service.impl;

import com.safewomen.SafeWomen.Dto.LoginDTO;
import com.safewomen.SafeWomen.Dto.UserDto;
import com.safewomen.SafeWomen.Entity.User;
import com.safewomen.SafeWomen.Repo.UserRepo;
import com.safewomen.SafeWomen.Response.LoginMessage;
import com.safewomen.SafeWomen.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDto userDto) {
        User user = new User(userDto.getId(),userDto.getName(),userDto.getEmail(),this.passwordEncoder.encode(userDto.getPassword()),userDto.getPhoneno());
        userRepo.save(user);
        return user.getName();
    }

    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {

                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("Email not exits", false);
        }


    }

}
