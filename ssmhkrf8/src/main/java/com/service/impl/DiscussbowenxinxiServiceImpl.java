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


import com.dao.DiscussbowenxinxiDao;
import com.entity.DiscussbowenxinxiEntity;
import com.service.DiscussbowenxinxiService;
import com.entity.vo.DiscussbowenxinxiVO;
import com.entity.view.DiscussbowenxinxiView;

@Service("discussbowenxinxiService")
public class DiscussbowenxinxiServiceImpl extends ServiceImpl<DiscussbowenxinxiDao, DiscussbowenxinxiEntity> implements DiscussbowenxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussbowenxinxiEntity> page = this.selectPage(
                new Query<DiscussbowenxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussbowenxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussbowenxinxiEntity> wrapper) {
		  Page<DiscussbowenxinxiView> page =new Query<DiscussbowenxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussbowenxinxiVO> selectListVO(Wrapper<DiscussbowenxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussbowenxinxiVO selectVO(Wrapper<DiscussbowenxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussbowenxinxiView> selectListView(Wrapper<DiscussbowenxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussbowenxinxiView selectView(Wrapper<DiscussbowenxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
