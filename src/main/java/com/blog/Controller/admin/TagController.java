package com.blog.Controller.admin;

import com.blog.Service.admin.TagService;
import com.blog.vo.admin.Tag;
import com.blog.vo.admin.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String tags(@PageableDefault(size = 10,sort = {"id"},direction = Sort.Direction.DESC)
                               Pageable pageable, Model model) {
//        System.out.println("请求到了tags");
        model.addAttribute("page",tagService.listTag(pageable));
        return "admin/tags";
    }


    @GetMapping("/tags/addPage")
    public String addPage(Model model){
        model.addAttribute("type",new Type());
        return "/admin/tags-input";
    }

    //编辑页面并且传值

    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type",tagService.getTag(id));
        return "admin/tags-input";
    }

    @PostMapping("/tags")
    public String save(Tag tag, BindingResult result, RedirectAttributes attributes){
        Tag type1 = tagService.getTagByName(tag.getName());
        if (type1 != null) {
            result.rejectValue("name","nameError","不能添加重复的分类");
        }
        if (result.hasErrors()){
            return "admin/tags-input";
        }
        Tag t1 = tagService.SaveTag(tag);
        if (t1 == null){
            attributes.addFlashAttribute("message","添加失败");
        }else {
            attributes.addFlashAttribute("message","添加成功");
        }
        //这里不能直接返回页面,要使用上面的请求再查询一遍好在页面上显示出来
        return "redirect:/admin/tags";
    }

    @PostMapping("/tags/{id}")
    public String update(@Valid Tag tag, BindingResult result,@PathVariable Long id, RedirectAttributes attributes){
        Tag type1 = tagService.getTagByName(tag.getName());
        if (type1 != null) {
            result.rejectValue("name","nameError","不能添加重复的分类");
        }
        if (result.hasErrors()){
            return "admin/tags-input";
        }
        Tag t1 = tagService.updateTag(id,tag);
        if (t1 == null){
            attributes.addFlashAttribute("message","修改失败");
        }else {
            attributes.addFlashAttribute("message","修改成功");
        }
        //这里不能直接返回页面,要使用上面的请求再查询一遍好在页面上显示出来
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/tags";
    }


}
