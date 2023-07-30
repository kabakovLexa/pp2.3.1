package web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Dao.UserDAO;
import web.Model.User;
import web.Service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllShowUsers(Model model){


        List<User> list = new ArrayList<>();
        list = userService.allUsers();
        model.addAttribute("allUsers",list);


        return "allUsers";
    }
    @PostMapping("/search")
    public String searchUserId(@RequestParam int id, Model model) {
        User user = userService.getUserId(id);
        model.addAttribute("user", user);
        return "showUserId";
    }

    @GetMapping("/addUser")
    public String newPerson(@ModelAttribute("user") User user) {
        return "/addUser";
    }

    @PostMapping("/")
    public String addUser(@ModelAttribute("user") User user) {

        userService.addUser(user);
        return "redirect:/";
    }

}
