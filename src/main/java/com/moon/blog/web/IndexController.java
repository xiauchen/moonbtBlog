package com.moon.blog.web;
import com.moon.blog.NotFoundException;
import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    //@GetMapping("/{id}/{name}")
    @GetMapping("/")
    //String index(@PathVariable Integer id,@PathVariable String name)
    public String index(){
        /*//int i = 9/0;
        String blog = null;
        if (blog==null){
            throw  new NotFoundException("博客不存在");
        }*/
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
