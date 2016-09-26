package ua.sosna.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.sosna.service.UserService;
import ua.sosna.service.modelView.UserView;


@Controller
public class LogInUser {

    private static final Logger LOGGER = Logger.getLogger(LogInUser.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Authentication authentication) {

        String name = authentication.getName();

        LOGGER.info("authentication user name -- " + name);

        return "welcome";
    }

    @RequestMapping(value = "userDataView", method = RequestMethod.GET)
    public
    @ResponseBody
    UserView userDataView(Authentication authentication) {
        String name = authentication.getName();
        UserView userView = userService.findUserNameOnView(name);
        return userView;
    }

}
