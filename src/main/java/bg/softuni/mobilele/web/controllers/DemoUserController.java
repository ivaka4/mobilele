package bg.softuni.mobilele.web.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoUserController {

  //TODO - delete me
  @GetMapping("/demo")
  public String demoHowToTakeTheUser(@AuthenticationPrincipal UserDetails user,
      Model model) {
    model.addAttribute("user", user);
    return "demo";
  }

}
