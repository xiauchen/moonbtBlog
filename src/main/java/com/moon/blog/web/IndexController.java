package com.moon.blog.web;
import com.moon.blog.NotFoundException;
import com.moon.blog.service.BlogService;
import com.moon.blog.service.TagService;
import com.moon.blog.service.TypeService;
import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    //@GetMapping("/{id}/{name}")
    @GetMapping("/")
    //String index(@PathVariable Integer id,@PathVariable String name)
    public String index(@PageableDefault(size = 2,sort ={"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                        Model model){
        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("tags",tagService.listTagTop(10));
        model.addAttribute("recommendBlogs",blogService.listRecommnedBlogTop(8));
        return "index";
    }
    @GetMapping("blog")
    public String blog(){
        return "blog";
    }
    @GetMapping("error")
    public String error(){
        return "error/500";
    }
}
