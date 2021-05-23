package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ImageVO implements Serializable {
    private Integer error;
    private String url;
    private Integer width;
    private Integer height;
}
