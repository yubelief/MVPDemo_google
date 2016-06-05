package com.adouble.mvpdemotodoapp.module.userinfo;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.adouble.mvpdemotodoapp.R;
import com.adouble.mvpdemotodoapp.model.bean.UserInfo;

public class UserInfoActivity extends AppCompatActivity implements UserInfoContract.View, SwipeRefreshLayout.OnRefreshListener {

    private TextView mTV;
    private UserInfoContract.Presenter mPresenter;
    private SwipeRefreshLayout mSwipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipe = (SwipeRefreshLayout) findViewById(R.id.main_swipeRefresh);
        assert mSwipe != null;
        mSwipe.setOnRefreshListener(this);
        mSwipe.setColorSchemeColors(
                ContextCompat.getColor(this, R.color.colorPrimary),
                ContextCompat.getColor(this, R.color.colorAccent),
                ContextCompat.getColor(this, R.color.colorPrimaryDark)
        );
        mTV = (TextView) findViewById(R.id.main_tv);

        mPresenter = new UserInfoPresenter(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void showLoading(boolean isLoadMore) {
        if (isLoadMore) {
            Toast.makeText(UserInfoActivity.this, "loagingMore", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void dismissLoading() {
//        Toast.makeText(UserInfoActivity.this, "dismissLoading", Toast.LENGTH_SHORT).show();
        mSwipe.setRefreshing(false);
    }

    @Override
    public void showUserInfo(UserInfo userInfoModel) {
        if (userInfoModel != null) {
            String text = userInfoModel.getName() + userInfoModel.getAge() + userInfoModel.getAddress();
            mTV.setText(text);
        }
    }

    @Override
    public void showError(String errorConstant) {
        Toast.makeText(UserInfoActivity.this, errorConstant, Toast.LENGTH_SHORT).show();
    }

    @Override
    public long loadUserId() {
        return 1000;//假设需要查询的用户信息的userId是1000
    }

    /**
     * 通过这个方法将presenter对象返回到view对象中
     *
     * @param presenter
     */
    @Override
    public void setPresenter(UserInfoContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onRefresh() {
        mPresenter.loadUserInfo();
    }
}
