package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.BowenleixingDao;
import com.entity.BowenleixingEntity;
import com.service.BowenleixingService;
import com.entity.vo.BowenleixingVO;
import com.entity.view.BowenleixingView;

@Service("bowenleixingService")
public class BowenleixingServiceImpl extends ServiceImpl<BowenleixingDao, BowenleixingEntity> implements BowenleixingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BowenleixingEntity> page = this.selectPage(
                new Query<BowenleixingEntity>(params).getPage(),
                new EntityWrapper<BowenleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BowenleixingEntity> wrapper) {
		  Page<BowenleixingView> page =new Query<BowenleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BowenleixingVO> selectListVO(Wrapper<BowenleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BowenleixingVO selectVO(Wrapper<BowenleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BowenleixingView> selectListView(Wrapper<BowenleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BowenleixingView selectView(Wrapper<BowenleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
