package info.lxlong.demo.controller;

import info.lxlong.demo.domain.User;
import info.lxlong.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/index")
    public String index(ModelMap map) {
        List<User> userList = userService.getAll();
        map.addAttribute("users", userList);
        return "user/user_list";
    }

    @GetMapping("/goAdd")
    public String goAdd() {
        List<User> userList = userService.getAll();
        return "user/user_add";
    }

    @PostMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect: user/index";
    }
}
