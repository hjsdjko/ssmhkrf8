package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BowenxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BowenxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BowenxinxiView;


/**
 * 博文信息
 *
 * @author 
 * @email 
 * @date 2021-04-04 18:01:47
 */
public interface BowenxinxiService extends IService<BowenxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BowenxinxiVO> selectListVO(Wrapper<BowenxinxiEntity> wrapper);
   	
   	BowenxinxiVO selectVO(@Param("ew") Wrapper<BowenxinxiEntity> wrapper);
   	
   	List<BowenxinxiView> selectListView(Wrapper<BowenxinxiEntity> wrapper);
   	
   	BowenxinxiView selectView(@Param("ew") Wrapper<BowenxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BowenxinxiEntity> wrapper);
   	
}

