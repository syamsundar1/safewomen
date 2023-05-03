package com.safewomen.SafeWomen.Service;

import com.safewomen.SafeWomen.Dto.LoginDTO;
import com.safewomen.SafeWomen.Dto.UserDto;
import com.safewomen.SafeWomen.Response.LoginMessage;

public interface UserService {
       String addUser(UserDto userDto);


       LoginMessage loginUser(LoginDTO loginDTO);
}
