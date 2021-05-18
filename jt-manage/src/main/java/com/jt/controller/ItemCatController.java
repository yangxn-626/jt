package com.jt.controller;

import com.jt.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item/cat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;
    @RequestMapping("/queryItemName")
    public String findItemCatNameById(@RequestParam("itemCatId") Long itemCatIds){
        return itemCatService.findItemCatNameById(itemCatIds);
    }
}
