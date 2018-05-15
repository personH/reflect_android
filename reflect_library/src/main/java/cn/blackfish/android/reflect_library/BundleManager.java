package cn.blackfish.android.reflect_library;

import android.content.Context;
import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by shawn on 2018/5/14.
 */

public class BundleManager {

    public static boolean initBundle(String className, String methodName, Context context) {
        Object object = reflectExecute(className, methodName, context);
        return object == null ? false : true;

    }

    public static boolean setNetwork(String className, int type) {
        Object object = reflectExecute(className, AppLifeCycleListenr.MethodType.ON_NETWORK_SET, type);
        return object == null ? false : true;
    }

    public static HashMap<String, Object> getHashMap(String className) {

        return (HashMap<String, Object>) reflectExecute(className, AppLifeCycleListenr.MethodType.GET_STATICS_MAPPING, null);
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
