package dao.impl;

import dao.OracleConnection;
import dao.UserInfoDao;
import entity.UserInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfoDaoImpl implements UserInfoDao {
    OracleConnection oc = new OracleConnection();

    public UserInfoDaoImpl() {
    }

    public UserInfo getUserInfoByUserName(String userName) {
        String sql = "SELECT * FROM User_car WHERE UserName=?";
        Object[] parameters = new Object[]{userName};
        ResultSet rs = this.oc.getResultSet(sql, parameters);
        UserInfo user = null;

        try {
            if (rs.next()) {
                user = new UserInfo();
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));
            }
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

        return user;
    }

    public boolean addUserInfo(UserInfo user) {
        String sql = "INSERT INTO User_car VALUES(?,?)";
        Object[] parameters = new Object[]{user.getUserName(), user.getPassword()};
        return this.oc.execute(sql, parameters);
    }
}