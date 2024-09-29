package com.cpy.tlias.polo;


import lombok.Data;
import java.time.LocalDateTime;

/**
 * 部门被删除日志类
 */
@Data
public class DeptLog {
    private int id;
    private LocalDateTime createTime;
    private String description;
}
