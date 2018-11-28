package com.llx;

/**
 * Created by Administrator on 2018/11/27 0027.
 */

public interface BaseView<P extends BasePresenter> {
    void setPresenter(P presenter);
}
