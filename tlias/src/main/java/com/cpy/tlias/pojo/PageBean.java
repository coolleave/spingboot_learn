package com.cpy.tlias.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * 分页查询返回类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private long total;  // 总数据数
    private List<Emp> rows;  // 数据列表
}
