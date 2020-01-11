package club.service;

import club.pojo.Blog;
import com.github.pagehelper.PageInfo;

public interface BlogService {

    PageInfo<Blog> queryByPage();
}
