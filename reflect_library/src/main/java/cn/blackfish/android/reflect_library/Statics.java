package cn.blackfish.android.reflect_library;

import java.io.Serializable;

/**
 * Created by shawn on 2018/5/14.
 */
public class Statics implements Serializable {
    public int index;
    public String name;
    public String product;

    public Statics(int index, String name, String product) {
        this.index = index;
        this.name = name;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Statics{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", product='" + product + '\'' +
                '}';
    }
}
