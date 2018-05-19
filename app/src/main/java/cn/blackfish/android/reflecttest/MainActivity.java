package cn.blackfish.android.reflecttest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import cn.blackfish.android.reflect_library.AppLifeCycleListenr;
import cn.blackfish.android.reflect_library.BundleProxy;
import cn.blackfish.android.reflect_library.BundleManager;
import cn.blackfish.android.reflect_library.CommonStatics;
import cn.blackfish.android.reflect_library.Statics;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * bundle init
         */
        BundleManager.getInstance().register(BundleProxy.CERT_BUNDLE_INIT);
        BundleManager.getInstance().register(BundleProxy.BILL_BUNDLE_INIT);


        AppLifeCycleListenr init = new BundleProxy();
        AppLifeCycleListenr appLifeCycleListenr = (AppLifeCycleListenr) Proxy.newProxyInstance(init.getClass().getClassLoader()
                , new Class[]{AppLifeCycleListenr.class}, BundleManager.getInstance());
        appLifeCycleListenr.onAppCreate(this);

        final HashMap<String, Statics> hashMap = CommonStatics.getsInstance(this.getApplicationContext()).getStaticcmap();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (String key : hashMap.keySet()) {
                    Statics statics = (Statics) hashMap.get(key);
                    Log.d("Mainactivity", statics.toString());
                }
            }
        }).start();
    }
}
