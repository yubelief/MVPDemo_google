package com.adouble.mvpdemotodoapp.presenter;

import com.adouble.mvpdemotodoapp.bean.UserInfo;
import com.adouble.mvpdemotodoapp.contract.UserInfoContract;
import com.adouble.mvpdemotodoapp.model.IUserInfoModel;
import com.adouble.mvpdemotodoapp.model.OnSucFaiListener;
import com.adouble.mvpdemotodoapp.model.UserInfoModel;

/**
 * Created by double on 16-6-5.
 * Project: MVPDemotodoapp
 */
public class UserInfoPresenter implements UserInfoContract.Presenter, OnSucFaiListener<UserInfo> {

    private final IUserInfoModel mUserInfoModel;
    private UserInfoContract.View mView;

    public UserInfoPresenter(UserInfoContract.View view) {
        mView = view;
        mView.setPresenter(this);
        mUserInfoModel = new UserInfoModel();
    }

    @Override
    public void loadUserInfo() {
        long userId = mView.loadUserId();
        mView.showLoading(false);//接口请求前显示loading
        mUserInfoModel.getUserInfo(userId,this);
    }

    @Override
    public void start() {
        loadUserInfo();
    }

    @Override
    public void onSuccess(UserInfo userInfo) {
        mView.showUserInfo(userInfo);
        mView.dismissLoading();
    }

    @Override
    public void onError(String errorConstant) {
        mView.showError(errorConstant);
        mView.dismissLoading();
    }
}
