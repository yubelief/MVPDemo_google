package com.adouble.mvpdemotodoapp.model;

import com.adouble.mvpdemotodoapp.model.bean.UserInfo;

/**
 * Created by double on 16-6-5.
 * Project: MVPDemotodoapp
 */
public interface IUserInfoModel {

    void getUserInfo(long id, OnSucFaiListener<UserInfo> onSucFaiListener);
}
