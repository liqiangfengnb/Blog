package com.blog.Controller.home;

import com.blog.Service.admin.BlogService;
import com.blog.Service.admin.TypeService;
import com.blog.vo.admin.BlogQuery;
import com.blog.vo.admin.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @RequestMapping("/types/{id}")
    public String type(@PageableDefault(size = 4, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                       @PathVariable Long id, Model model){
        List<Type> types = typeService.listTypeTop(1000);
        if (id == -1){
            id = types.get(0).getId();
        }
        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setTypeId(id);
        model.addAttribute("types",types);
        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("recommendBlogs", blogService.listBlog(pageable,blogQuery));
        model.addAttribute("activeTypeId",id);
        return "/home/types";
    }
}
