package com.llx.presenter;

import com.llx.Contract.LoginContract;
import com.llx.fragment.LoginFragment;
import com.llx.model.UserInfo;

/**
 * Created by Administrator on 2018/11/27 0027.
 */

public class LoginPersenter implements LoginContract.Presenter {

    private LoginFragment loginFragment;

    public LoginPersenter(LoginFragment loginFragment) {
        this.loginFragment = loginFragment;
    }

    @Override
    public void start() {

    }

    @Override
    public void userLogin(String name,String passwd) {
        UserInfo userInfo=null;
        if (name.equals("admin")&&passwd.equals("123")){
            userInfo=new UserInfo();
            userInfo.setUsername(name);
            userInfo.setPasswd(passwd);
        }
        loginFragment.loginResult(userInfo);
    }
}
