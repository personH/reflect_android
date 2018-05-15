package cn.blackfish.android.reflect_library;

import java.io.Serializable;

/**
 * Created by shawn on 2018/5/14.
 */

public class Statics implements Serializable {
    public int index;

    public Statics(int index) {
        this.index = index;
    }

    @Override
    public int hashCode() {
        return index;
    }
}
