package com.jiawei.dao;

import com.jiawei.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //查询学生和对应的老师
    public List<Student> getStudent();
    public List<Student> getStudent2();
}
