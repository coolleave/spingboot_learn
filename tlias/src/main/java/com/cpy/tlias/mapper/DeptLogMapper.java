package com.cpy.tlias.mapper;

import com.cpy.tlias.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 插入部门删除日志到数据库
 * 最重要的就是propagation整个配置
 * 默认为Propagation.REQUIRED，也就是跟着父事务一起，当父事务出现异常，子事务也跟着回滚。
 * 如果我们主动将propagation的属性设置为Propagation.REQUIRES_NEW
 * 当父事务抛出异常时，子事务没问题，子事务就可以正常提交了，只需要父事务回滚。
 */

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Mapper
public interface DeptLogMapper {
    @Insert("insert into deptlog(create_time,description) " +
            "values (#{createTime},#{description} )")
     void insertLog(DeptLog deptLog);


}
