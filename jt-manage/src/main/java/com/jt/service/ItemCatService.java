package com.jt.service;

import com.jt.vo.EasyUITree;

import java.util.List;

public interface ItemCatService {
     String findItemCatNameById(Long itemCatId);

     List<EasyUITree> findItemCatByParentId(Long parentId);
}
