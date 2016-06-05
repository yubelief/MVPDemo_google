package com.adouble.mvpdemotodoapp.model;

import android.os.Handler;
import android.os.Looper;

import com.adouble.mvpdemotodoapp.model.bean.UserInfo;
import com.adouble.mvpdemotodoapp.constant.ErrorConstant;

/**
 * Created by double on 16-6-5.
 * Project: MVPDemotodoapp
 */
public class UserInfoModel implements IUserInfoModel {


    private OnSucFaiListener<UserInfo> mOnSucFaiListener;

    private static Handler sHandler = new Handler(Looper.getMainLooper());

    @Override
    public void getUserInfo(long id, OnSucFaiListener<UserInfo> onSucFaiListener) {
        mOnSucFaiListener = onSucFaiListener;
        sHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // get result by id
                double random = Math.random();
                if (random < 0.5) {
                    UserInfo userInfo = new UserInfo("double", 100, "beijing");
                    if (mOnSucFaiListener != null) {
                        mOnSucFaiListener.onSuccess(userInfo);
                    }
                } else {
                    if (mOnSucFaiListener != null) {
                        mOnSucFaiListener.onError(ErrorConstant.ERROR_NETWORK);
                    }
                }
            }
        }, 3000);

    }
}
