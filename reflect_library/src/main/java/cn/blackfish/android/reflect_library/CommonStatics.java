package cn.blackfish.android.reflect_library;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shawn on 2018/5/19.
 * <p>
 * 优先取缓存，缓存是接口更新，也可能是内存写到缓存。
 * 通过版本号更新本地的缓存
 */

public class CommonStatics {
    public static final String STATIC_MAP = "STATIC_MAP";
    private static Context context;
    private static CommonStatics sInstance;


    private CommonStatics(Context context) {
        this.context = context;
    }

    public static CommonStatics getsInstance(Context context) {
        if (sInstance == null) {
            sInstance = new CommonStatics(context);
        }
        return sInstance;
    }


    //
    private static final Gson GSON = new GsonBuilder().create();
    //是否有接口更新埋点

    public static HashMap<String, Statics> sStaticcmap = new HashMap<>();

    public void addBundleStatics(HashMap<String, Statics> hashMap) {
        sStaticcmap.putAll(hashMap);
    }

    public HashMap<String, Statics> getStaticcmap() {
//        if (getCache() == null || getCache().size() <= 0) {
//            setCache(sStaticcmap);
        return sStaticcmap;
//        } else {
//            return getCache();
//        }
    }

    public void getStaticFromNet() {
        //从接口获取更新埋点，更新缓存
    }

    private static HashMap<String, Statics> getCache() {
        return DiskCacheUtils.getInstance(context).getMapCache();
    }

    private static void setCache(HashMap<String, Statics> cache) {
        //更新缓存
        DiskCacheUtils.getInstance(context).setMapCache(cache);
    }


}
