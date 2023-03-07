package com.jiawei.dao.role;

import com.jiawei.dao.BaseDao;
import com.jiawei.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.jiawei.dao.BaseDao.execute;

public class RoleDaoImpl implements RoleDao{

    public List<Role> getRoleList(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Role> roleArrayList = new ArrayList<Role>();
        if (connection != null) {
            String sql = "SELECT * FROM smbms_role";
            Object[] params = {};
            rs = execute(connection, pstm, sql, params, rs);
        }
        while (rs.next()){
            Role role = new Role();
            role.setId(rs.getInt("id"));
            role.setRoleCode(rs.getString("roleCode"));
            role.setRoleName(rs.getString("roleName"));
            roleArrayList.add(role);
        }
        BaseDao.closeResource(null, pstm, rs);
        return roleArrayList;
    }

}
