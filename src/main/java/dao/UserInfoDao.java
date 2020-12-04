package dao;

import entity.UserInfo;

public interface UserInfoDao {
    UserInfo getUserInfoByUserName(String var1);

    boolean addUserInfo(UserInfo var1);
}

