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

import com.entity.BowenxinxiEntity;
import com.entity.view.BowenxinxiView;

import com.service.BowenxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 博文信息
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-04 18:01:47
 */
@RestController
@RequestMapping("/bowenxinxi")
public class BowenxinxiController {
    @Autowired
    private BowenxinxiService bowenxinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BowenxinxiEntity bowenxinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			bowenxinxi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BowenxinxiEntity> ew = new EntityWrapper<BowenxinxiEntity>();
		PageUtils page = bowenxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bowenxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BowenxinxiEntity bowenxinxi, HttpServletRequest request){
        EntityWrapper<BowenxinxiEntity> ew = new EntityWrapper<BowenxinxiEntity>();
		PageUtils page = bowenxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bowenxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BowenxinxiEntity bowenxinxi){
       	EntityWrapper<BowenxinxiEntity> ew = new EntityWrapper<BowenxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( bowenxinxi, "bowenxinxi")); 
        return R.ok().put("data", bowenxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BowenxinxiEntity bowenxinxi){
        EntityWrapper< BowenxinxiEntity> ew = new EntityWrapper< BowenxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( bowenxinxi, "bowenxinxi")); 
		BowenxinxiView bowenxinxiView =  bowenxinxiService.selectView(ew);
		return R.ok("查询博文信息成功").put("data", bowenxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BowenxinxiEntity bowenxinxi = bowenxinxiService.selectById(id);
		bowenxinxi.setClicknum(bowenxinxi.getClicknum()+1);
		bowenxinxi.setClicktime(new Date());
		bowenxinxiService.updateById(bowenxinxi);
        return R.ok().put("data", bowenxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BowenxinxiEntity bowenxinxi = bowenxinxiService.selectById(id);
		bowenxinxi.setClicknum(bowenxinxi.getClicknum()+1);
		bowenxinxi.setClicktime(new Date());
		bowenxinxiService.updateById(bowenxinxi);
        return R.ok().put("data", bowenxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        BowenxinxiEntity bowenxinxi = bowenxinxiService.selectById(id);
        if(type.equals("1")) {
        	bowenxinxi.setThumbsupnum(bowenxinxi.getThumbsupnum()+1);
        } else {
        	bowenxinxi.setCrazilynum(bowenxinxi.getCrazilynum()+1);
        }
        bowenxinxiService.updateById(bowenxinxi);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BowenxinxiEntity bowenxinxi, HttpServletRequest request){
    	bowenxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bowenxinxi);

        bowenxinxiService.insert(bowenxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BowenxinxiEntity bowenxinxi, HttpServletRequest request){
    	bowenxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bowenxinxi);

        bowenxinxiService.insert(bowenxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BowenxinxiEntity bowenxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bowenxinxi);
        bowenxinxiService.updateById(bowenxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        bowenxinxiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<BowenxinxiEntity> wrapper = new EntityWrapper<BowenxinxiEntity>();
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

		int count = bowenxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,BowenxinxiEntity bowenxinxi, HttpServletRequest request,String pre){
        EntityWrapper<BowenxinxiEntity> ew = new EntityWrapper<BowenxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = bowenxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bowenxinxi), params), params));
        return R.ok().put("data", page);
    }


}
