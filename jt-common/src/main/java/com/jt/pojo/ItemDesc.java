package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@TableName("tb_item_desc")
@Accessors(chain = true)
public class ItemDesc extends BasePojo{
    private Long itemId;
    private String itemDesc;
}
