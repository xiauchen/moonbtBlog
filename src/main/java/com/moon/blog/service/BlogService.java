package com.moon.blog.service;

import com.moon.blog.po.Blog;
import com.moon.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Blog getBlog(Long id);

    Blog getAndConvert(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(String query,Pageable pageable);


    List<Blog> listRecommnedBlogTop(Integer size);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);
}
