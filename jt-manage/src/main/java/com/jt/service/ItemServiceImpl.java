package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.mapper.ItemDescMapper;
import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.vo.EasyUIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.mapper.ItemMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ItemDescMapper itemDescMapper;
	@Override
	public EasyUIData findItemByPage(Integer page, Integer rows) {
		int total = itemMapper.selectCount(null);
		int start = (page-1)*rows;
		List<Item> itemList = itemMapper.findItemByPage(start,rows);
		return new EasyUIData(total,itemList);
	}
	@Transactional
	@Override
	public void saveItem(Item item, ItemDesc itemDesc) {
		item.setStatus(1).setCreated(new Date()).setUpdated(item.getCreated());
		itemDesc.setItemId(item.getId()).setCreated(new Date()).setUpdated(itemDesc.getCreated());
		itemDescMapper.insert(itemDesc);
		itemMapper.insert(item);
	}
    @Transactional
	@Override
	public void updateItem(Item item, ItemDesc itemDesc) {
		item.setUpdated(new Date());
		itemMapper.updateById(item);
		itemDesc.setItemId(item.getId())
				.setUpdated(item.getUpdated());
		itemDescMapper.updateById(itemDesc);
	}

	@Override
	public void deleteItem(Long[] ids) {
		List<Long> itemList = Arrays.asList(ids);
		itemMapper.deleteBatchIds(itemList);
		itemDescMapper.deleteBatchIds(itemList);
	}

	@Override
	public void updateStatus(Long[] ids, int status) {
		Item item = new Item();
		item.setStatus(status).setUpdated(new Date());
		List<Long> longList = Arrays.asList(ids);
		UpdateWrapper<Item> updateWrapper = new UpdateWrapper<>();
		updateWrapper.in("id",longList);
		itemMapper.update(item,updateWrapper);
	}

	@Override
	public ItemDesc findItemDescById(Long itemId) {

		//ItemDesc itemDesc =  itemDescMapper.selecta(itemId);
		ItemDesc itemDesc = itemDescMapper.selectById(itemId);
		System.out.println(itemDesc.toString());
		return itemDesc;
	}
}
