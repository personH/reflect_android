package cn.blackfish.android.reflect_library;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by shawn on 2018/5/14.
 */

public interface AppLifeCycleListenr {
    String TAG = AppLifeCycleListenr.class.getName();

    void onAppCreate(Context context);

    boolean onAppStop(Context context);

    boolean onAppResume(Context context);

    boolean onWelcomePageStart(Context context);

    boolean onMainPageStart(Context context);

    boolean onNetworkSet(int type);

    HashMap<String, Object> getStaticsMapping();
}
