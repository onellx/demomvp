package com.llx.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.llx.Contract.LoginContract;
import com.llx.R;
import com.llx.model.UserInfo;
import com.llx.presenter.LoginPersenter;

/**
 * Created by Administrator on 2018/11/27 0027.
 */

public class LoginFragment extends Fragment implements LoginContract.View,View.OnClickListener{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;
    private EditText username,passwd;
    private Button login;
    private LoginPersenter loginContract;

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.login_fragment,container,false);
        init();
        return view;
    }


    private void init(){
        username=view.findViewById(R.id.username);
        passwd=view.findViewById(R.id.passwd);
        login=view.findViewById(R.id.login);
        login.setText("登录");
        login.setOnClickListener(this);
        //这个可以
        passwd.setInputType(EditorInfo.TYPE_CLASS_NUMBER);

        loginContract=new LoginPersenter(this);
    }
    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.login:
                String name=username.getText().toString().trim();
                String password=passwd.getText().toString().trim();
                loginContract.userLogin(name,password);
                break;
        }
    }

    @Override
    public void loginResult(UserInfo userInfo) {
        if (userInfo!=null){
            Toast.makeText(view.getContext(),"登录成功！！！",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(view.getContext(),"登录失败！！！",Toast.LENGTH_SHORT).show();
        }

    }
}
