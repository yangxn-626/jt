package com.jt.controller;

import com.jt.pojo.Item;
import com.jt.vo.EasyUIData;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.service.ItemService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	@RequestMapping("/query")
	public EasyUIData findItemByPage(Integer page,Integer rows){
		return itemService.findItemByPage(page,rows);
	}
	@RequestMapping("/save")
	public SysResult saveItem(Item item){
		try {
			itemService.saveItem(item);
			return SysResult.ok("Ikan");
		}catch (Exception e){
			e.printStackTrace();
			return SysResult.fail();
		}
	}
	@RequestMapping("/update")
	public SysResult updateItem(Item item){
		try {
			itemService.updateItem(item);
			return SysResult.ok();
		}catch (Exception e){
			e.printStackTrace();
			return SysResult.fail("商品修改失败");
		}
	}
	
	
}
