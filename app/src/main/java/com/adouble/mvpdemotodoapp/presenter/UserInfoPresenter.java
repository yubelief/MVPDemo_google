package com.adouble.mvpdemotodoapp.presenter;

import android.os.Handler;

import com.adouble.mvpdemotodoapp.contract.UserInfoContract;
import com.adouble.mvpdemotodoapp.model.UserInfoModel;

/**
 * Created by double on 16-6-5.
 * Project: MVPDemotodoapp
 */
public class UserInfoPresenter implements UserInfoContract.Presenter {

    private UserInfoContract.View mView;

    public UserInfoPresenter(UserInfoContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void loadUserInfo() {
        long userId = mView.loadUserId();
        mView.showLoading();//接口请求前显示loading
        //这里模拟接口请求回调-
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //模拟接口返回的json，并转换为javaBean
                UserInfoModel userInfoModel = new UserInfoModel("小宝", 1, "杭州");
                mView.showUserInfo(userInfoModel);
                mView.dismissLoading();
            }
        }, 3000);
    }

    @Override
    public void start() {
        loadUserInfo();
    }
}
