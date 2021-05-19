package com.jt.service;

import com.jt.pojo.Item;
import com.jt.vo.EasyUIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.mapper.ItemMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMapper;

	@Override
	public EasyUIData findItemByPage(Integer page, Integer rows) {
		int total = itemMapper.selectCount(null);
		int start = (page-1)*rows;
		List<Item> itemList = itemMapper.findItemByPage(start,rows);
		return new EasyUIData(total,itemList);
	}
	@Transactional
	@Override
	public void saveItem(Item item) {
		item.setStatus(1).setCreated(new Date()).setUpdated(item.getCreated());
		itemMapper.insert(item);
	}
    @Transactional
	@Override
	public void updateItem(Item item) {
		item.setUpdated(new Date());
		itemMapper.updateById(item);
	}
}
