package web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.Model.User;
import web.Service.UserService;

@Controller
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void UserController() {
    }

    @GetMapping("/")
    public String getStart(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }

    @GetMapping("/adduser")
    public String getAddUser(@ModelAttribute("user") User user) {
        return "add_user";
    }

    @PostMapping("/")
    public String addUser(@ModelAttribute("user") User user,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add_user";
        }
        userService.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String dropUser(@PathVariable("id") int id) {

        userService.dropUserById(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit_user")
    public String getEdit(ModelMap model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit_user";
    }

    @PutMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user,
                           BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "/edit_user";

        userService.updateUser(id, user);
        return "redirect:/";
    }

}
