package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GerenmingpianfenxiangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GerenmingpianfenxiangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GerenmingpianfenxiangView;


/**
 * 个人名片分享
 *
 * @author 
 * @email 
 * @date 2021-04-04 18:01:47
 */
public interface GerenmingpianfenxiangService extends IService<GerenmingpianfenxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GerenmingpianfenxiangVO> selectListVO(Wrapper<GerenmingpianfenxiangEntity> wrapper);
   	
   	GerenmingpianfenxiangVO selectVO(@Param("ew") Wrapper<GerenmingpianfenxiangEntity> wrapper);
   	
   	List<GerenmingpianfenxiangView> selectListView(Wrapper<GerenmingpianfenxiangEntity> wrapper);
   	
   	GerenmingpianfenxiangView selectView(@Param("ew") Wrapper<GerenmingpianfenxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GerenmingpianfenxiangEntity> wrapper);
   	
}

