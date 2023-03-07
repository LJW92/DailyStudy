package com.jiawei.dao;

import com.jiawei.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
    @Select("SELECT * FROM teacher WHERE `id` = #{tid}")
    Teacher getTeacher(@Param("tid") int id);
}
