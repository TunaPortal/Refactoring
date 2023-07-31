package co.refactoring.tuna.web.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = "/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/")
    public String homepage() {
        return "home";
    }

    @RequestMapping("/logout")
    public void logout() {
    }

    @RequestMapping("/custom/login")
    public String login() {

        return "custom/login";
    }

    @RequestMapping("/duplicatelogin")
    public String duplicateLogin(Model model) {
        model.addAttribute("LoginFailMessage", "다른 IP에서 접속하셨기 때문에 기존의 접속이 끊어집니다.");
        return "custom/login";
    }

    @RequestMapping("/custom/pwdfind")
    public String pwdFind() {
        return "custom/pwdfind";
    }
}
