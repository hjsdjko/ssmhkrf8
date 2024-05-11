package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussbowenxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussbowenxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussbowenxinxiView;


/**
 * 博文信息评论表
 *
 * @author 
 * @email 
 * @date 2021-04-04 18:01:47
 */
public interface DiscussbowenxinxiService extends IService<DiscussbowenxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussbowenxinxiVO> selectListVO(Wrapper<DiscussbowenxinxiEntity> wrapper);
   	
   	DiscussbowenxinxiVO selectVO(@Param("ew") Wrapper<DiscussbowenxinxiEntity> wrapper);
   	
   	List<DiscussbowenxinxiView> selectListView(Wrapper<DiscussbowenxinxiEntity> wrapper);
   	
   	DiscussbowenxinxiView selectView(@Param("ew") Wrapper<DiscussbowenxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussbowenxinxiEntity> wrapper);
   	
}

