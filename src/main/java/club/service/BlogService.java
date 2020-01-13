package club.service;

import club.pojo.Blog;
import com.github.pagehelper.PageInfo;

public interface BlogService {
    PageInfo<Blog> blogs(Integer pageNum, Integer pageSize);
    Blog findById(Integer id);
}
