package bg.softuni.mobilele.web.controllers;

import bg.softuni.mobilele.services.UserService;
import bg.softuni.mobilele.entities.view.UserRegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("auth-register");
    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(UserRegisterModel userRegisterModel){
//        if(!userRegisterModel.getPassword().equals(userRegisterModel.getConfirmPassword())) {
//            return super.redirect("/users/register");
//        }
        this.userService.registerUser(userRegisterModel);
        return super.redirect("/users/login");
    }

    @GetMapping("/login")
    public String login(@AuthenticationPrincipal UserDetails user, Model model) {
        model.addAttribute("user", user);
        return "auth-login";
    }
}
