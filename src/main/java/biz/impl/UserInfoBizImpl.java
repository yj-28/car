package biz.impl;

import biz.UserInfoBiz;
import dao.UserInfoDao;
import dao.impl.UserInfoDaoImpl;
import entity.UserInfo;

public class UserInfoBizImpl implements UserInfoBiz {
    UserInfoDao uidao = new UserInfoDaoImpl();

    public UserInfoBizImpl() {
    }

    public boolean isExistsUserName(String userName) {
        boolean isExists = false;
        UserInfo user = this.uidao.getUserInfoByUserName(userName);
        if (user != null) {
            isExists = true;
        }

        return isExists;
    }

    public boolean register(UserInfo user) {
        return this.uidao.addUserInfo(user);
    }

    public int login(UserInfo user) {
        int flag = -1;
        UserInfo userReturn = this.uidao.getUserInfoByUserName(user.getUserName());
        if (userReturn != null) {
            if (userReturn.getPassword().equals(user.getPassword())) {
                flag = 1;
            } else {
                flag = 0;
            }
        }

        return flag;
    }
}
