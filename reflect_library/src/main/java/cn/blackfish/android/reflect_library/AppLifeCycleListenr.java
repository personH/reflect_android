package cn.blackfish.android.reflect_library;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by shawn on 2018/5/14.
 */

public abstract class AppLifeCycleListenr {
    public static final String TAG = AppLifeCycleListenr.class.getName();

    //支持的方法
    public interface MethodType {
        String ON_APP_CREATE = "onAppCreate";
        String ON_APP_STOP = "onAppStop";
        String ON_APP_RESUME = "onAppResume";

        String ON_WELCOME_PAGE_START = "onWelcomePageStart";
        String ON_MAINPAGE_START = "onMainPageStart";
        String ON_NETWORK_SET = "onNetworkSet";
        String GET_STATICS_MAPPING = "getStaticsMapping";
    }

    public abstract boolean onAppCreate(Context context);

    public boolean onAppStop(Context context) {

        return false;
    }

    public boolean onAppResume(Context context) {
        return false;
    }

    public boolean onWelcomePageStart(Context context) {

        return false;
    }

    public boolean onMainPageStart(Context context) {
        return false;
    }

    public boolean onNetworkSet(int type) {
        return false;
    }

    public HashMap<String, Object> getStaticsMapping() {
        return null;
    }
}
