package com.llx.Contract;

import com.llx.BasePresenter;
import com.llx.BaseView;
import com.llx.model.UserInfo;

/**
 * Created by Administrator on 2018/11/27 0027.
 */

public interface LoginContract {

    interface Presenter extends BasePresenter{

        void userLogin(String name,String passwd);

    }

    interface View extends BaseView<Presenter>{

        void loginResult(UserInfo userInfo);

    }
}
