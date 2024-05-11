package com.dao;

import com.entity.BowenxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BowenxinxiVO;
import com.entity.view.BowenxinxiView;


/**
 * 博文信息
 * 
 * @author 
 * @email 
 * @date 2021-04-04 18:01:47
 */
public interface BowenxinxiDao extends BaseMapper<BowenxinxiEntity> {
	
	List<BowenxinxiVO> selectListVO(@Param("ew") Wrapper<BowenxinxiEntity> wrapper);
	
	BowenxinxiVO selectVO(@Param("ew") Wrapper<BowenxinxiEntity> wrapper);
	
	List<BowenxinxiView> selectListView(@Param("ew") Wrapper<BowenxinxiEntity> wrapper);

	List<BowenxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<BowenxinxiEntity> wrapper);
	
	BowenxinxiView selectView(@Param("ew") Wrapper<BowenxinxiEntity> wrapper);
	
}
