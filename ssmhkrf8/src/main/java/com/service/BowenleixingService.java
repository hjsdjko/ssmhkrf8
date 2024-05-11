package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BowenleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BowenleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BowenleixingView;


/**
 * 博文类型
 *
 * @author 
 * @email 
 * @date 2021-04-04 18:01:47
 */
public interface BowenleixingService extends IService<BowenleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BowenleixingVO> selectListVO(Wrapper<BowenleixingEntity> wrapper);
   	
   	BowenleixingVO selectVO(@Param("ew") Wrapper<BowenleixingEntity> wrapper);
   	
   	List<BowenleixingView> selectListView(Wrapper<BowenleixingEntity> wrapper);
   	
   	BowenleixingView selectView(@Param("ew") Wrapper<BowenleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BowenleixingEntity> wrapper);
   	
}

