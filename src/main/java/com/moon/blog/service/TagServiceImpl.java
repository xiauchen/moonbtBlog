package com.moon.blog.service;

import antlr.StringUtils;
import com.moon.blog.NotFoundException;
import com.moon.blog.dao.TagRepository;
import com.moon.blog.po.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class TagServiceImpl implements TagService{
    @Autowired
    private TagRepository tagRepository;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }


    @Override
    public List<Tag> listTag(String ids) { //1.2.3
        return tagRepository.findAllById(converToList(ids));
    }

    @Override
    public List<Tag> listTagTop(Integer size) {
        //Sort sort = new Sort(Sort.Direction.DESC,"blogs.size");
        //Pageable pageable = new PageRequest(0,size,sort)
        Pageable pageable = PageRequest.of(0,size, Sort.by(Sort.Direction.DESC,"blogs.size"));;
        return tagRepository.findTop(pageable);
    }

    private List<Long> converToList(String ids){
        List<Long> list = new ArrayList<>();
        if(!"".equals(ids) && ids!=null){
            String[] idarray = ids.split(",");
            for(int i=0;i< idarray.length;i++){
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }
//    @Override
//    public List<Tag> listTagTop(Integer size) {
//        Sort sort = new Sort(Sort.Direction.DESC, "blogs.size");
//        Pageable pageable = new PageRequest(0, size, sort);
//        return tagRepository.findTop(pageable);
//    }
//    private List<Long> convertToList(String ids) {
//        List<Long> list = new ArrayList<>();
//        if (!"".equals(ids) && ids != null) {
//            String[] idarray = ids.split(",");
//            for (int i=0; i < idarray.length;i++) {
//                list.add(new Long(idarray[i]));
//            }
//        }
//        return list;
//    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagRepository.findById(id).orElse(null);
        if(t == null){
            throw new NotFoundException("不存在該標簽");
        }

        return tagRepository.save(t);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
