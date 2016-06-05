package com.adouble.mvpdemotodoapp.model;

/**
 * Created by double on 16-6-5.
 * Project: MVPDemotodoapp
 */
public interface OnSucFaiListener<T> {

    void onSuccess(T t);

    void onError(String errorConstant);
}
