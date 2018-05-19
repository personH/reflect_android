package cn.blackfish.android.reflect_library;

import android.content.Context;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by shawn on 2018/5/14.
 */

public class CertBundleInit implements AppLifeCycleListenr {

    @Override
    public void onAppCreate(Context application) {
        Log.d(TAG, "CertBundleInit onAppCreate start");
        System.out.println("----------");

        //初始化模块的工作
        //1、埋点
        HashMap<String, Statics> hashMap = new HashMap<>();

        hashMap.put("1111", new Statics(1, "vakye", "rrr"));
        hashMap.put("222", new Statics(2, "vakye", "rrr"));

        CommonStatics.getsInstance(application.getApplicationContext()).addBundleStatics(getStaticsMapping());
        Log.d(TAG, "CertBundleInit onAppCreate end");
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
        return false;
    }

    @Override
    public boolean onMainPageStart(Context context) {
        return false;
    }

    @Override
    public boolean onNetworkSet(int type) {
        Log.d(TAG, "networkType:" + type);
        return true;
    }

    @Override
    public HashMap<String, Statics> getStaticsMapping() {
        Log.d(TAG, "getStaticsMapping");
        HashMap<String, Statics> hashMap = new HashMap<>();
        for (int i = 0; i <= 1000; i++) {
            hashMap.put("cert" + i, new Statics(i,"value"+i,"product"+i));
        }
        return hashMap;
    }
}
