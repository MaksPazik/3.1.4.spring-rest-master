package ru.maxpaz.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.maxpaz.security.model.User;
import ru.maxpaz.security.service.RoleService;
import ru.maxpaz.security.service.UserService;

import java.security.Principal;

@Controller
public class AdminController {
    private static final String ADMIN_PAGE = "admin/admin-page";
    private static final String ADMIN_USER_PAGE = "admin/admin-user-page";
    private static  final String REDIRECT_TO_ADMIN_PAGE = "redirect:/admin";
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/admin")
    public String getAdminPage(Model model, Principal principal, @ModelAttribute ("user") User user) {
        Long id = userService.getUserByUsername(principal.getName()).getId();
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("usersList", userService.getAllUsers());
        model.addAttribute("rolesList", roleService.getRoles());
        model.addAttribute("newUser", new User());
        return ADMIN_PAGE;
    }

    @GetMapping(value = "/admin-user")
    public String getUserPage(Model model, Principal principal) {
        Long id = userService.getUserByUsername(principal.getName()).getId();
        model.addAttribute("user", userService.getUserById(id));
        return ADMIN_USER_PAGE;
    }

    @PostMapping("/touch-user")
    public String createUser(@ModelAttribute ("user") User user) {
        userService.saveUser(user);
        return REDIRECT_TO_ADMIN_PAGE;
    }

    @PutMapping("/user-update/{id}")
    public String updateUser(@PathVariable Long id, User user) {
        userService.updateUser(id, user);
        return REDIRECT_TO_ADMIN_PAGE;
    }

    @DeleteMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return REDIRECT_TO_ADMIN_PAGE;
    }

}
