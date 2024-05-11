package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WodebowenEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WodebowenVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WodebowenView;


/**
 * 我的博文
 *
 * @author 
 * @email 
 * @date 2021-04-04 18:01:47
 */
public interface WodebowenService extends IService<WodebowenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WodebowenVO> selectListVO(Wrapper<WodebowenEntity> wrapper);
   	
   	WodebowenVO selectVO(@Param("ew") Wrapper<WodebowenEntity> wrapper);
   	
   	List<WodebowenView> selectListView(Wrapper<WodebowenEntity> wrapper);
   	
   	WodebowenView selectView(@Param("ew") Wrapper<WodebowenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WodebowenEntity> wrapper);
   	
}

