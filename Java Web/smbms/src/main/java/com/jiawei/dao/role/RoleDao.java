package com.jiawei.dao.role;

import com.jiawei.pojo.Role;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RoleDao {
    List<Role> getRoleList(Connection connection) throws SQLException;

}
