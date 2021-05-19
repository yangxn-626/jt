package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.ItemCatMapper;
import com.jt.pojo.ItemCat;
import com.jt.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public String findItemCatNameById(Long itemCatId) {
        ItemCat itemCat = itemCatMapper.selectById(itemCatId);
        return itemCat.getName();
    }

    @Override
    public List<EasyUITree> findItemCatByParentId(Long parentId) {
        List<ItemCat> cartList = findItemCatList(parentId);
        List<EasyUITree> treeList = new ArrayList<>();
        for (ItemCat itemCat : cartList) {
            EasyUITree easyUITree = new EasyUITree();
            easyUITree.setId(itemCat.getId());
            easyUITree.setText(itemCat.getName());
            easyUITree.setState(itemCat.getIsParent()?"closed":"open");
            treeList.add(easyUITree);
        }
        return treeList;
    }

    private List<ItemCat> findItemCatList(Long parentId) {
        QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",parentId);
        return itemCatMapper.selectList(queryWrapper);
    }
}
