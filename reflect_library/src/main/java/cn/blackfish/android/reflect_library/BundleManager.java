package cn.blackfish.android.reflect_library;

import android.text.TextUtils;
import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shawn on 2018/5/14.
 */

public class BundleManager implements InvocationHandler {

    private static BundleManager sInstance;

    public static BundleManager getInstance() {
        if (sInstance == null) {
            sInstance = new BundleManager();
        }
        return sInstance;
    }

    private static List<String> sBundlelist = new ArrayList<>();

    public void register(String bundleName) {
        sBundlelist.add(bundleName);
    }

    public AppLifeCycleListenr getDelegate() {
        AppLifeCycleListenr init = new BundleProxy();
        AppLifeCycleListenr appLifeCycleListenr = (AppLifeCycleListenr) Proxy.newProxyInstance(init.getClass().getClassLoader()
                , new Class[]{AppLifeCycleListenr.class}, BundleManager.getInstance());
        return appLifeCycleListenr;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (sBundlelist.isEmpty()) {
            return null;
        }

        for (String bundlClass : sBundlelist) {
            if (TextUtils.isEmpty(bundlClass)) {
                continue;
            }
            ClassLoader classLoader = proxy.getClass().getClassLoader();
            Class clazz = classLoader.loadClass(bundlClass);
            Constructor constructor = clazz.getConstructor();
            Object object = constructor.newInstance();
            method.invoke(object, args);
        }

        return null;
    }

    private static Object reflectExecute(String className, String methodName, Object... objects) {

        ClassLoader classLoader = BundleManager.class.getClassLoader();
        try {
            Class clazz = classLoader.loadClass(className);

            Method[] methodList = clazz.getDeclaredMethods();

            if (methodList == null || methodList.length <= 0) {
                return null;
            }
            for (Method method : methodList) {
                if (method == null) {
                    continue;
                }
                if (methodName.equals(method.getName())) {
                    Constructor constructor = clazz.getConstructor();
                    Object object = constructor.newInstance();
                    return method.invoke(object, objects);
                }
            }

            return null;
        } catch (ClassNotFoundException e) {
            Log.d(AppLifeCycleListenr.TAG, "ClassNotFoundException");
            return null;
        } catch (NoSuchMethodException e) {
            Log.d(AppLifeCycleListenr.TAG, "NoSuchMethodException");
            return null;
        } catch (IllegalAccessException e) {
            Log.d(AppLifeCycleListenr.TAG, "IllegalAccessException");
            return null;
        } catch (InstantiationException e) {
            Log.d(AppLifeCycleListenr.TAG, "InstantiationException");
            return null;
        } catch (InvocationTargetException e) {
            Log.d(AppLifeCycleListenr.TAG, "InvocationTargetException");
            return null;
        }
    }


}
