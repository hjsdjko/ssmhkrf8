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


import com.dao.BowenxinxiDao;
import com.entity.BowenxinxiEntity;
import com.service.BowenxinxiService;
import com.entity.vo.BowenxinxiVO;
import com.entity.view.BowenxinxiView;

@Service("bowenxinxiService")
public class BowenxinxiServiceImpl extends ServiceImpl<BowenxinxiDao, BowenxinxiEntity> implements BowenxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BowenxinxiEntity> page = this.selectPage(
                new Query<BowenxinxiEntity>(params).getPage(),
                new EntityWrapper<BowenxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BowenxinxiEntity> wrapper) {
		  Page<BowenxinxiView> page =new Query<BowenxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BowenxinxiVO> selectListVO(Wrapper<BowenxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BowenxinxiVO selectVO(Wrapper<BowenxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BowenxinxiView> selectListView(Wrapper<BowenxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BowenxinxiView selectView(Wrapper<BowenxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
