package com.dao;

import com.entity.DiscusswodebowenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusswodebowenVO;
import com.entity.view.DiscusswodebowenView;


/**
 * 我的博文评论表
 * 
 * @author 
 * @email 
 * @date 2021-04-04 18:01:47
 */
public interface DiscusswodebowenDao extends BaseMapper<DiscusswodebowenEntity> {
	
	List<DiscusswodebowenVO> selectListVO(@Param("ew") Wrapper<DiscusswodebowenEntity> wrapper);
	
	DiscusswodebowenVO selectVO(@Param("ew") Wrapper<DiscusswodebowenEntity> wrapper);
	
	List<DiscusswodebowenView> selectListView(@Param("ew") Wrapper<DiscusswodebowenEntity> wrapper);

	List<DiscusswodebowenView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusswodebowenEntity> wrapper);
	
	DiscusswodebowenView selectView(@Param("ew") Wrapper<DiscusswodebowenEntity> wrapper);
	
}
