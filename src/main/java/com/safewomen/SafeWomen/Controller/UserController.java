package com.safewomen.SafeWomen.Controller;

import com.safewomen.SafeWomen.Dto.LoginDTO;
import com.safewomen.SafeWomen.Dto.UserDto;
import com.safewomen.SafeWomen.Response.LoginMessage;
import com.safewomen.SafeWomen.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping()
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "save")
    public String saveUser(@RequestBody UserDto userDto){
        String id = userService.addUser(userDto);
        return id;
    }

    @PostMapping(path = "login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
        LoginMessage loginMessage = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }

}
