package com.zondy.jwt.jwtmobile.callback;

import com.zondy.jwt.jwtmobile.entity.EntityJingq;

/**
 * Created by ywj on 2017/1/12 0012.
 */

public interface IReloadJingqCallback {
    public void loadJingqSuccess(EntityJingq jingq);
    public void loadJingqFailed(Exception exception);
}
