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
    public PageInfo<Blog> queryByPage() {
        PageHelper.startPage(1,3);
        List<Blog> blogs = blogMapper.selectList(null);
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogs,2);
        return blogPageInfo;
    }
}
