package com.adouble.mvpdemotodoapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.adouble.mvpdemotodoapp.R;
import com.adouble.mvpdemotodoapp.contract.UserInfoContract;
import com.adouble.mvpdemotodoapp.model.UserInfoModel;
import com.adouble.mvpdemotodoapp.presenter.UserInfoPresenter;

public class UserInfoActivity extends AppCompatActivity implements UserInfoContract.View {

    private TextView mTV;
    private UserInfoContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTV = (TextView) findViewById(R.id.main_tv);

        new UserInfoPresenter(this);
        mPresenter.start();
    }

    @Override
    public void showLoading() {
        Toast.makeText(UserInfoActivity.this, "showloaging", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dismissLoading() {
        Toast.makeText(UserInfoActivity.this, "dismissLoading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserInfo(UserInfoModel userInfoModel) {
        if (userInfoModel != null) {
            mTV.setText(userInfoModel.getName() + userInfoModel.getAge() + userInfoModel.getAddress());
        }
    }

    @Override
    public long loadUserId() {
        return 1000;//假设需要查询的用户信息的userId是1000
    }

    /**
     * 通过这个方法将presenter对象返回到view对象中
     * @param presenter
     */
    @Override
    public void setPresenter(UserInfoContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
