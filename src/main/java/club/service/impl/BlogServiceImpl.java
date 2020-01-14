package club.service.impl;

import club.dao.BlogMapper;
import club.pojo.Blog;
import club.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    @Override
    public PageInfo<Blog> blogs(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogs = blogMapper.selectList(null);
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogs, 3);
        return pageInfo;
    }

    @Override
    public Blog findById(Integer id) {
        return blogMapper.selectById(id);
    }
}
