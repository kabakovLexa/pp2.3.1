package web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.Model.User;
import web.Service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String getStart(ModelMap model) {
        User user = new User("Name","LastName", "email");
        userService.addUser(user);
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }
}
