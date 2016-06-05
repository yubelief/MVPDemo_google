package com.adouble.mvpdemotodoapp.contract;

import com.adouble.mvpdemotodoapp.BasePresenter;
import com.adouble.mvpdemotodoapp.BaseView;
import com.adouble.mvpdemotodoapp.model.UserInfoModel;

/**
 * Created by double on 16-6-5.
 * Project: MVPDemotodoapp
 */
public interface UserInfoContract {

    /**
     * IView 和 IPresenter 中分别实现UI，业务逻辑
     * 把他们一起放在Contract类中更加清晰，也让工程更加简洁
     */

    interface View extends BaseView<Presenter>{

        void showLoading();

        void dismissLoading();

        void showUserInfo(UserInfoModel userInfoModel); // 将网络请求的信息回调

        long loadUserId();

    }

    interface Presenter extends BasePresenter{
        void loadUserInfo();
    }
}
