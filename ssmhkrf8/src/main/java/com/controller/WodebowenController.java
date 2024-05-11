package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.WodebowenEntity;
import com.entity.view.WodebowenView;

import com.service.WodebowenService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 我的博文
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-04 18:01:47
 */
@RestController
@RequestMapping("/wodebowen")
public class WodebowenController {
    @Autowired
    private WodebowenService wodebowenService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WodebowenEntity wodebowen, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wodebowen.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WodebowenEntity> ew = new EntityWrapper<WodebowenEntity>();
		PageUtils page = wodebowenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wodebowen), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WodebowenEntity wodebowen, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wodebowen.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WodebowenEntity> ew = new EntityWrapper<WodebowenEntity>();
		PageUtils page = wodebowenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wodebowen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WodebowenEntity wodebowen){
       	EntityWrapper<WodebowenEntity> ew = new EntityWrapper<WodebowenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wodebowen, "wodebowen")); 
        return R.ok().put("data", wodebowenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WodebowenEntity wodebowen){
        EntityWrapper< WodebowenEntity> ew = new EntityWrapper< WodebowenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wodebowen, "wodebowen")); 
		WodebowenView wodebowenView =  wodebowenService.selectView(ew);
		return R.ok("查询我的博文成功").put("data", wodebowenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WodebowenEntity wodebowen = wodebowenService.selectById(id);
		wodebowen.setClicknum(wodebowen.getClicknum()+1);
		wodebowenService.updateById(wodebowen);
        return R.ok().put("data", wodebowen);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WodebowenEntity wodebowen = wodebowenService.selectById(id);
		wodebowen.setClicknum(wodebowen.getClicknum()+1);
		wodebowenService.updateById(wodebowen);
        return R.ok().put("data", wodebowen);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WodebowenEntity wodebowen, HttpServletRequest request){
    	wodebowen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wodebowen);

        wodebowenService.insert(wodebowen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WodebowenEntity wodebowen, HttpServletRequest request){
    	wodebowen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wodebowen);
    	wodebowen.setUserid((Long)request.getSession().getAttribute("userId"));

        wodebowenService.insert(wodebowen);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WodebowenEntity wodebowen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wodebowen);
        wodebowenService.updateById(wodebowen);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wodebowenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<WodebowenEntity> wrapper = new EntityWrapper<WodebowenEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = wodebowenService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
