package ru.sber.prof.sberdata.testproject.user.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sber.prof.sberdata.testproject.user.user.model.User;
import ru.sber.prof.sberdata.testproject.user.user.service.UserService;

import javax.validation.Valid;

@Controller
@Slf4j
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users")
  public String users(Model model) {
    model.addAttribute("users", userService.findAll());
    return "index";
  }

  @GetMapping("/create")
  public String create(User user) {
    return "add-user";
  }

  @PostMapping("/create")
  public String create(@Valid User user, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "add-user";
    }

    userService.save(user);
    return "redirect:/users";
  }

  @GetMapping("/edit/{id}")
  public String update(@PathVariable("id") long id, Model model) {
    model.addAttribute("user", userService.findById(id));
    return "update-user";
  }

  @PostMapping("/update/{id}")
  public String update(@PathVariable("id") long id, @Valid User user, BindingResult result) {
    if (result.hasErrors()) {
      user.setId(id);
      return "update-user";
    }

    userService.save(user);
    return "redirect:/users";
  }

  @PostMapping("/filterByName")
  public String filterByName(@RequestParam String name, Model model) {
    model.addAttribute("users", userService.findByName(name));
    return "index";
  }

  @PostMapping("/filterByEmail")
  public String filterByEmail(@RequestParam String email, Model model) {
    model.addAttribute("users", userService.findByEmail(email));
    return "index";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable("id") long id) {
    userService.deleteById(id);
    return "redirect:/users";
  }
}
