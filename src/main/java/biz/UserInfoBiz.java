package biz;

import entity.UserInfo;

public interface UserInfoBiz {
    boolean isExistsUserName(String var1);

    boolean register(UserInfo var1);

    int login(UserInfo var1);
}
