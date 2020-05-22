package com.blog.Controller.home;

import com.blog.Service.admin.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class ArchiveShowController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archive(Model model){
        model.addAttribute("archivesMap",blogService.archiveBlog());
        model.addAttribute("blogCount",blogService.countBlog());
        return "/home/archives";
    }
}
