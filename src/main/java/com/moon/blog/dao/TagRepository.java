package com.moon.blog.dao;

import com.moon.blog.po.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);
}
