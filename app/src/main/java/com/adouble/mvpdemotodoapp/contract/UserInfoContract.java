package com.adouble.mvpdemotodoapp.contract;

import com.adouble.mvpdemotodoapp.BasePresenter;
import com.adouble.mvpdemotodoapp.BaseView;
import com.adouble.mvpdemotodoapp.bean.UserInfo;

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

        void showLoading(boolean isLoadMore);

        void dismissLoading();

        void showUserInfo(UserInfo userInfoModel); // 将网络请求的信息回调

        void showError(String errorConstant);

        long loadUserId();

    }

    interface Presenter extends BasePresenter{
        void loadUserInfo();
    }
}
