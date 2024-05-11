package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusswodebowenEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusswodebowenVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusswodebowenView;


/**
 * 我的博文评论表
 *
 * @author 
 * @email 
 * @date 2021-04-04 18:01:47
 */
public interface DiscusswodebowenService extends IService<DiscusswodebowenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusswodebowenVO> selectListVO(Wrapper<DiscusswodebowenEntity> wrapper);
   	
   	DiscusswodebowenVO selectVO(@Param("ew") Wrapper<DiscusswodebowenEntity> wrapper);
   	
   	List<DiscusswodebowenView> selectListView(Wrapper<DiscusswodebowenEntity> wrapper);
   	
   	DiscusswodebowenView selectView(@Param("ew") Wrapper<DiscusswodebowenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusswodebowenEntity> wrapper);
   	
}

