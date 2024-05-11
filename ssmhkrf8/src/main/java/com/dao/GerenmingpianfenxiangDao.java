package com.dao;

import com.entity.GerenmingpianfenxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GerenmingpianfenxiangVO;
import com.entity.view.GerenmingpianfenxiangView;


/**
 * 个人名片分享
 * 
 * @author 
 * @email 
 * @date 2021-04-04 18:01:47
 */
public interface GerenmingpianfenxiangDao extends BaseMapper<GerenmingpianfenxiangEntity> {
	
	List<GerenmingpianfenxiangVO> selectListVO(@Param("ew") Wrapper<GerenmingpianfenxiangEntity> wrapper);
	
	GerenmingpianfenxiangVO selectVO(@Param("ew") Wrapper<GerenmingpianfenxiangEntity> wrapper);
	
	List<GerenmingpianfenxiangView> selectListView(@Param("ew") Wrapper<GerenmingpianfenxiangEntity> wrapper);

	List<GerenmingpianfenxiangView> selectListView(Pagination page,@Param("ew") Wrapper<GerenmingpianfenxiangEntity> wrapper);
	
	GerenmingpianfenxiangView selectView(@Param("ew") Wrapper<GerenmingpianfenxiangEntity> wrapper);
	
}
