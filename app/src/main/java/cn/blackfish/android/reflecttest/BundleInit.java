package cn.blackfish.android.reflecttest;

import android.app.Application;
import android.content.Context;

import java.util.HashMap;

import cn.blackfish.android.reflect_library.AppLifeCycleListenr;
import cn.blackfish.android.reflect_library.BundleManager;

/**
 * Created by shawn on 2018/5/14.
 */

public class BundleInit extends AppLifeCycleListenr {

    //各模块初始化的实现类名
    public static final String CERT_BUNDLE_INIT = "cn.blackfish.android.reflect_library.CertBundleInit";
    public static final String BILL_BUNDLE_INIT = "cn.blackfish.android.reflect_library.BillBundleInit";


    @Override
    public boolean onAppCreate(Context application) {
        BundleManager.initBundle(CERT_BUNDLE_INIT, MethodType.ON_APP_CREATE, application);
        BundleManager.initBundle(BILL_BUNDLE_INIT, MethodType.ON_APP_CREATE, application);
        return true;
    }

    @Override
    public boolean onWelcomePageStart(Context context) {

        return true;
    }

    @Override
    public boolean onNetworkSet(int type) {
        super.onNetworkSet(type);
        BundleManager.setNetwork(CERT_BUNDLE_INIT, type);
        BundleManager.setNetwork(BILL_BUNDLE_INIT, type);
        return true;
    }

    @Override
    public HashMap<String, Object> getStaticsMapping() {
        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.putAll(BundleManager.getHashMap(CERT_BUNDLE_INIT));
        hashMap.putAll(BundleManager.getHashMap(BILL_BUNDLE_INIT));
        return hashMap;
    }
}
