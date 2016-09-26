package ua.sosna.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.sosna.model.User;
import ua.sosna.service.SecurityService;
import ua.sosna.service.UserService;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@RestController
public class UserRegistrationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String registerUser(@RequestBody User userForm){
        LOGGER.info("userForm - " +  userForm.getUsername());
        String massage = userService.validationUser(userForm);
        return massage;
    }

}
