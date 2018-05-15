package cn.blackfish.android.reflect_library;

import android.content.Context;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by shawn on 2018/5/14.
 */

public class CertBundleInit extends AppLifeCycleListenr {

    @Override
    public boolean onAppCreate(Context application) {
        Log.d(TAG, "onAppCreate");

        Log.d(TAG, application.getApplicationContext().toString());
        return true;
    }

    @Override
    public boolean onNetworkSet(int type) {
        super.onNetworkSet(type);
        Log.d(TAG, "networkType:" + type);
        return true;
    }

    @Override
    public HashMap<String, Object> getStaticsMapping() {
        Log.d(TAG, "getStaticsMapping");
        HashMap<String, Object> hashMap = new HashMap<>();
        for (int i = 0; i <= 1000; i++) {
            hashMap.put("cert" + i, new Statics(i));
        }
        return hashMap;
    }
}
