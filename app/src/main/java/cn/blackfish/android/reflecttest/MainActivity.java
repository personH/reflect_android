package cn.blackfish.android.reflecttest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import cn.blackfish.android.reflect_library.AppLifeCycleListenr;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BundleInit bundleInit = new BundleInit();
        bundleInit.onAppCreate(this.getBaseContext());
        bundleInit.onNetworkSet(5);

        int i = 0;
        for (String key : bundleInit.getStaticsMapping().keySet()) {
            i++;
            Log.d(AppLifeCycleListenr.TAG, "key is:" + key);
        }
        Log.d(AppLifeCycleListenr.TAG, "count is =" + i);
    }
}
