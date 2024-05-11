package com.entity.view;

import com.entity.DiscussbowenxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 博文信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-04 18:01:47
 */
@TableName("discussbowenxinxi")
public class DiscussbowenxinxiView  extends DiscussbowenxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussbowenxinxiView(){
	}
 
 	public DiscussbowenxinxiView(DiscussbowenxinxiEntity discussbowenxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussbowenxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
