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


import com.dao.DiscusswodebowenDao;
import com.entity.DiscusswodebowenEntity;
import com.service.DiscusswodebowenService;
import com.entity.vo.DiscusswodebowenVO;
import com.entity.view.DiscusswodebowenView;

@Service("discusswodebowenService")
public class DiscusswodebowenServiceImpl extends ServiceImpl<DiscusswodebowenDao, DiscusswodebowenEntity> implements DiscusswodebowenService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusswodebowenEntity> page = this.selectPage(
                new Query<DiscusswodebowenEntity>(params).getPage(),
                new EntityWrapper<DiscusswodebowenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusswodebowenEntity> wrapper) {
		  Page<DiscusswodebowenView> page =new Query<DiscusswodebowenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusswodebowenVO> selectListVO(Wrapper<DiscusswodebowenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusswodebowenVO selectVO(Wrapper<DiscusswodebowenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusswodebowenView> selectListView(Wrapper<DiscusswodebowenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusswodebowenView selectView(Wrapper<DiscusswodebowenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
