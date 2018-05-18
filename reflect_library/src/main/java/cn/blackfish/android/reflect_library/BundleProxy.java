package cn.blackfish.android.reflect_library;

import android.app.Application;
import android.content.Context;

import java.lang.invoke.MethodType;
import java.util.HashMap;

import cn.blackfish.android.reflect_library.AppLifeCycleListenr;
import cn.blackfish.android.reflect_library.BundleManager;

/**
 * Created by shawn on 2018/5/14.
 */

public class BundleProxy implements AppLifeCycleListenr {

    //各模块初始化的实现类名
    public static final String CERT_BUNDLE_INIT = "cn.blackfish.android.reflect_library.CertBundleInit";
    public static final String BILL_BUNDLE_INIT = "cn.blackfish.android.reflect_library.BillBundleInit";

    @Override
    public void onAppCreate(Context application) {
    }

    @Override
    public boolean onAppStop(Context context) {
        return false;
    }

    @Override
    public boolean onAppResume(Context context) {
        return false;
    }

    @Override
    public boolean onWelcomePageStart(Context context) {

        return true;
    }

    @Override
    public boolean onMainPageStart(Context context) {
        return false;
    }

    @Override
    public boolean onNetworkSet(int type) {
        return true;
    }

    @Override
    public HashMap<String, Object> getStaticsMapping() {
        return null;
    }
}
