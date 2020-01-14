package club.service;

import club.pojo.Blog;
import com.github.pagehelper.PageInfo;

import java.util.Date;

public interface BlogService {
    PageInfo<Blog> findAllBlog(String actionTime,Integer pageNum,Integer pageSize);
    int add(Blog blog);
    Blog findById(Integer id);
    int updateBlog(Blog blog);
    int del(Integer id);
}
