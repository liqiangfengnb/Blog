package com.blog.Controller.home;

import com.blog.Service.admin.BlogService;
import com.blog.Service.admin.TagService;
import com.blog.Service.admin.TypeService;
import com.blog.Service.home.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class IndexController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @Autowired
    private iUserService iuserService;

    @GetMapping("/index")
    public String index(@PageableDefault(size = 4, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        Model model) {
        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types", typeService.listTypeTop(6));
        model.addAttribute("tags", tagService.listTagTop(10));

        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));
//        System.out.println("recommendBlogs的值为: " + blogService.listRecommendBlogTop(8));
        model.addAttribute("user1", iuserService.iuser());
        return "/home/index";
    }
    @PostMapping("/search")
    public String search(@PageableDefault(size = 4, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        Model model,@RequestParam String query) {
        model.addAttribute("page",blogService.listBlog(query,pageable));
        model.addAttribute("query",query);
        return "/home/search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model){
//        System.out.println("前端值为: " + blogService.getAndConvert(id));
        model.addAttribute("blog",blogService.getAndConvert(id));
        return "home/blog";
    }

}
