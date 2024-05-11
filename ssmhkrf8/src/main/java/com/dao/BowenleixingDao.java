package com.dao;

import com.entity.BowenleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BowenleixingVO;
import com.entity.view.BowenleixingView;


/**
 * 博文类型
 * 
 * @author 
 * @email 
 * @date 2021-04-04 18:01:47
 */
public interface BowenleixingDao extends BaseMapper<BowenleixingEntity> {
	
	List<BowenleixingVO> selectListVO(@Param("ew") Wrapper<BowenleixingEntity> wrapper);
	
	BowenleixingVO selectVO(@Param("ew") Wrapper<BowenleixingEntity> wrapper);
	
	List<BowenleixingView> selectListView(@Param("ew") Wrapper<BowenleixingEntity> wrapper);

	List<BowenleixingView> selectListView(Pagination page,@Param("ew") Wrapper<BowenleixingEntity> wrapper);
	
	BowenleixingView selectView(@Param("ew") Wrapper<BowenleixingEntity> wrapper);
	
}
