package club.service.impl;

import club.dao.ApplyMapper;
import club.pojo.Apply;
import club.service.ApplyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class ApplyServiceImpl implements ApplyService {

    @Resource
    private ApplyMapper applyMapper;

    @Override
    public Integer create(Apply apply) {
        return applyMapper.insert(apply);
    }
}
