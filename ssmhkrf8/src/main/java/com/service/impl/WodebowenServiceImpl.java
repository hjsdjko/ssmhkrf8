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


import com.dao.WodebowenDao;
import com.entity.WodebowenEntity;
import com.service.WodebowenService;
import com.entity.vo.WodebowenVO;
import com.entity.view.WodebowenView;

@Service("wodebowenService")
public class WodebowenServiceImpl extends ServiceImpl<WodebowenDao, WodebowenEntity> implements WodebowenService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WodebowenEntity> page = this.selectPage(
                new Query<WodebowenEntity>(params).getPage(),
                new EntityWrapper<WodebowenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WodebowenEntity> wrapper) {
		  Page<WodebowenView> page =new Query<WodebowenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WodebowenVO> selectListVO(Wrapper<WodebowenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WodebowenVO selectVO(Wrapper<WodebowenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WodebowenView> selectListView(Wrapper<WodebowenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WodebowenView selectView(Wrapper<WodebowenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
