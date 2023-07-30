package web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        userService.addUser("Алексей","Кабаков",234);

        List<User> list = new ArrayList<>();
        list = userService.allUsers();
        model.addAttribute("allUsers",list);


        return "index";
    }

    @PostMapping("addUsers")
    public String addUsers() {





        return "addUser";
    }

}
