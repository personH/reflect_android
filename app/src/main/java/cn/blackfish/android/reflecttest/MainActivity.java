package cn.blackfish.android.reflecttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Proxy;

import cn.blackfish.android.reflect_library.AppLifeCycleListenr;
import cn.blackfish.android.reflect_library.BundleProxy;
import cn.blackfish.android.reflect_library.BundleManager;

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
    }
}
