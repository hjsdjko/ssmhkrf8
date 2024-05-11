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


import com.dao.GerenmingpianfenxiangDao;
import com.entity.GerenmingpianfenxiangEntity;
import com.service.GerenmingpianfenxiangService;
import com.entity.vo.GerenmingpianfenxiangVO;
import com.entity.view.GerenmingpianfenxiangView;

@Service("gerenmingpianfenxiangService")
public class GerenmingpianfenxiangServiceImpl extends ServiceImpl<GerenmingpianfenxiangDao, GerenmingpianfenxiangEntity> implements GerenmingpianfenxiangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GerenmingpianfenxiangEntity> page = this.selectPage(
                new Query<GerenmingpianfenxiangEntity>(params).getPage(),
                new EntityWrapper<GerenmingpianfenxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GerenmingpianfenxiangEntity> wrapper) {
		  Page<GerenmingpianfenxiangView> page =new Query<GerenmingpianfenxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GerenmingpianfenxiangVO> selectListVO(Wrapper<GerenmingpianfenxiangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GerenmingpianfenxiangVO selectVO(Wrapper<GerenmingpianfenxiangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GerenmingpianfenxiangView> selectListView(Wrapper<GerenmingpianfenxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GerenmingpianfenxiangView selectView(Wrapper<GerenmingpianfenxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
