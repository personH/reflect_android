package cn.blackfish.android.reflect_library;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * Created by shawn on 2018/5/19.
 */

public class DiskCacheUtils {
    private Context mContext;

    private static DiskCacheUtils sInstance;
    SharedPreferences sharedPreferences;

    private DiskCacheUtils(Context mContext) {
        this.mContext = mContext;
        sharedPreferences = mContext.getSharedPreferences("demo", Context.MODE_PRIVATE);
    }

    public static DiskCacheUtils getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DiskCacheUtils(context);
        }
        return sInstance;
    }


    public <T> T getCache(String key, Class<T> tClass) {

        String value = sharedPreferences.getString(key, "");
        if (TextUtils.isEmpty(value)) {
            return null;
        }

        T object = new Gson().fromJson(value, tClass);

        return object;
    }

    public void setMapCache(HashMap<String, Statics> hashMap) {
        if (hashMap == null) {
            return;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (String key : hashMap.keySet()) {
            if (TextUtils.isEmpty(key)) {
                continue;
            }
            editor.putString(key, new Gson().toJson(hashMap.get(key)));
        }
        editor.commit();
    }

    public HashMap<String, Statics> getMapCache() {
        Map<String,String> stringMap= (Map<String, String>) sharedPreferences.getAll();
        Gson gson=new Gson();
        HashMap<String,Statics> staticsHashMap=new HashMap<>();
        for(String key:stringMap.keySet()){
            String json=stringMap.get(key);
            Statics statics=gson.fromJson(json,Statics.class);
            staticsHashMap.put(key,statics);
        }
        return staticsHashMap;
    }


    public void setCache(String key, Object object) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, new Gson().toJson(object));
        editor.commit();
    }
}
