package com.blog.Controller.home;

import com.blog.Service.home.UserService2;
import com.blog.vo.home.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class LoginController2 {

    @Autowired
    private UserService2 userService2;

    @RequestMapping()
    public String loginPage(){
        return "/home/Login";
    }

    @PostMapping("/login2")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes
    ){
        User2 user = userService2.checkUser2(username,password);
        System.out.println("user的值为" + user);
        if (user != null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "redirect:/home/index";
        }else {
            System.out.println("登录失败");
            attributes.addFlashAttribute("message","用户名或者密码错误");
            return "redirect:/home";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/home";
    }
    @GetMapping("/login")
    public String login(){
        return "/home/Login";
    }
}
