package com.dao;

import com.entity.DiscussbowenxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussbowenxinxiVO;
import com.entity.view.DiscussbowenxinxiView;


/**
 * 博文信息评论表
 * 
 * @author 
 * @email 
 * @date 2021-04-04 18:01:47
 */
public interface DiscussbowenxinxiDao extends BaseMapper<DiscussbowenxinxiEntity> {
	
	List<DiscussbowenxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussbowenxinxiEntity> wrapper);
	
	DiscussbowenxinxiVO selectVO(@Param("ew") Wrapper<DiscussbowenxinxiEntity> wrapper);
	
	List<DiscussbowenxinxiView> selectListView(@Param("ew") Wrapper<DiscussbowenxinxiEntity> wrapper);

	List<DiscussbowenxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussbowenxinxiEntity> wrapper);
	
	DiscussbowenxinxiView selectView(@Param("ew") Wrapper<DiscussbowenxinxiEntity> wrapper);
	
}
