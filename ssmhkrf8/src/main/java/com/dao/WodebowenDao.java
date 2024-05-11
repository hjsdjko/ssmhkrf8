package com.dao;

import com.entity.WodebowenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WodebowenVO;
import com.entity.view.WodebowenView;


/**
 * 我的博文
 * 
 * @author 
 * @email 
 * @date 2021-04-04 18:01:47
 */
public interface WodebowenDao extends BaseMapper<WodebowenEntity> {
	
	List<WodebowenVO> selectListVO(@Param("ew") Wrapper<WodebowenEntity> wrapper);
	
	WodebowenVO selectVO(@Param("ew") Wrapper<WodebowenEntity> wrapper);
	
	List<WodebowenView> selectListView(@Param("ew") Wrapper<WodebowenEntity> wrapper);

	List<WodebowenView> selectListView(Pagination page,@Param("ew") Wrapper<WodebowenEntity> wrapper);
	
	WodebowenView selectView(@Param("ew") Wrapper<WodebowenEntity> wrapper);
	
}
