package com.example.hanlu.healthyadvisor.utils;

import android.os.Environment;

import java.io.File;
import java.lang.reflect.Field;

public class FileUtils {

    private static final String ROOT = "healthyAdvisor";
    private static final String CACHE = "cache";


//    public static File getCacheDir() {
//        return getDir(CACHE);
//    }

//
//    public static File getDir(String dir) {
//        StringBuilder path = new StringBuilder();
//        File file = null;
//        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
//            path.append(Environment.getExternalStorageDirectory());
//            path.append(File.separator);
//            path.append(ROOT);
//            path.append(File.separator);
//            path.append(dir);// /storage/googlePlay2/cache
//            file = new File(path.toString());
//        } else {
//            //保存到应用的文件夹下
//            String dir1 = UiUtils.getContext().getCacheDir().getAbsolutePath();
//            path.append(dir1);
//            file = new File(path.toString());
//        }
//
//        if (!file.exists() || !file.isDirectory()) {
//            file.mkdirs();
//        }
//        return file;
//    }

}
