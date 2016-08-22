package com.example.admin.filepathtest.Base;

import com.example.admin.filepathtest.TestActivitys.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2016/8/19.
 */
public class FirstItems {

    public static List<String> getItems(){
       String[] str =new String[]{"android路径","Touch事件分发","滑动","ViewDrawHelper滑动","Show 和Hidden"};

        return  Arrays.asList(str);
    }
    public static Class getClassByPosition(int position){
        Class[] classes=new Class[]{PathActivity.class, TouchActivity.class, SlideActivity.class,
                DragHelperActivity.class, ShowHidActivity.class};
        return classes[position];
    }
}
