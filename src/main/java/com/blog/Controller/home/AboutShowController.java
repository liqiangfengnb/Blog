package com.blog.Controller.home;

import com.blog.Service.admin.BlogService;
import com.blog.Service.admin.TagService;
import com.blog.Service.admin.TypeService;
import com.blog.vo.admin.Tag;
import com.blog.vo.admin.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class AboutShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/about")
    public String about(Model model){
/*        List<Tag> tags = tagService.listTagTop(1000);
        List<Type> types = typeService.listTypeTop(1000);
        System.out.println("tags的值为:" + tags);
        System.out.println("types的值为:" + types);
        model.addAttribute("types",types);
        model.addAttribute("tags",tags);*/
        return "/home/about";
    }

}
