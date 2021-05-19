package com.jt.service;

import com.jt.pojo.Item;
import com.jt.vo.EasyUIData;

public interface ItemService {
    EasyUIData findItemByPage(Integer page, Integer rows);

    void saveItem(Item item);
}
