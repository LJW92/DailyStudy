package com.jiawei.dao;

import com.jiawei.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    //插入数据
    int addBlog(Blog bolg);

    //查询博客
    List<Blog> queryBlogIF(Map map);

    List<Blog> queryBlogChoose(Map map);

    int updateBlog(Map map);

    //查询123号记录博客
    List<Blog> queryBlogForEach(Map map);
}
