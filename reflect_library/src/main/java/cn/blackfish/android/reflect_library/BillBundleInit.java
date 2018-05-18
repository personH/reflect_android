package cn.blackfish.android.reflect_library;

import android.content.Context;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by shawn on 2018/5/14.
 */

public class BillBundleInit implements AppLifeCycleListenr {

    @Override
    public void onAppCreate(Context application) {
        Log.d(TAG, "BillBundleInit onAppCreate start");
        System.out.println("----------");
        Log.d(TAG, "BillBundleInit onAppCreate end");
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
    public HashMap<String, Object> getStaticsMapping() {
        Log.d(TAG, "getStaticsMapping");
        HashMap<String, Object> hashMap = new HashMap<>();
        for (int i = 0; i <= 1000; i++) {
            hashMap.put("bill" + i, new Statics(i));
        }
        return hashMap;
    }
}
