package com.example.hanlu.healthyadvisor.protocol;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import com.example.hanlu.healthyadvisor.utils.Constant;
import com.example.hanlu.healthyadvisor.utils.FileUtils;
import com.example.hanlu.healthyadvisor.utils.UiUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseStream;
import com.lidroid.xutils.http.client.*;
import com.lidroid.xutils.http.client.HttpRequest;
import com.litesuits.common.assist.Network;

import org.apache.http.HttpResponse;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by hanlu on 2016/1/10.
 */
public abstract class BaseProtocol<T> {
    private static final String TAG = "hahahaha";
    private int page;
    //首先从本地读取，如果本地读取不到就从网络读取，并且读取后保存到本地，然后在去解析

    public T load(int page, int classfy, float longitude, float latitude,String name,String number,String code) {
        String json = null;
        this.page=page;
        if (json == null || json.length()==0) {
            //如果从本地读取不到就要从网络上去读取了
            json = loadFromServer(page, classfy, longitude, latitude,name,number,code);
            Log.i(TAG, "load: " + "执行了吗");
            //保存在本地
            saveLocal(json,page);
        }
        if (json != null) {
            return parseJson(json);
        }
        return null;
    }

    private boolean isReadFile() {
        if (!Network.isConnected(UiUtils.getContext())) {
            return true;
        }

        if (!isCacheDataFailure(UiUtils.getContext(),getCacheFile(page)) && isExistDataCache(UiUtils.getContext(), getCacheFile(page))){
            return true;
        }

        return false;
    }
    // wifi缓存时间为5分钟
    private static long wifi_cache_time = 5 * 60 * 1000;
    // 其他网络环境为1小时
    private static long other_cache_time = 60 * 60 * 1000;
    /**
     * 判断缓存是否已经失效
     */
    public static boolean isCacheDataFailure(Context context, String cachefile) {
        File data = context.getFileStreamPath(cachefile);
        if (!data.exists()) {

            return false;
        }
        long existTime = System.currentTimeMillis() - data.lastModified();
        boolean failure = false;
        if (Network.isWifiConnected(UiUtils.getContext())) {
            failure = existTime > wifi_cache_time ? true : false;
        } else {
            failure = existTime > other_cache_time ? true : false;
        }
        return failure;
    }

    protected abstract T parseJson(String json);



    //文件保存到本地


    //保存json到本地
    private void saveLocal(String json,int page) {
        URI uri=null;
        try {
             uri=new URI(getUrl());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        File file=new File(UiUtils.getContext().getFilesDir(),getCacheFile(page));
        BufferedWriter bw=null;

        try {
            Log.i(TAG, "savlocal: "+file.getAbsolutePath()+file.exists());

             bw = new BufferedWriter(new FileWriter(file));
            bw.write(json);
            bw.flush();
            bw.close();
            Log.i(TAG, "saveLocal: "+bw.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断缓存是否存在
     *
     * @param cachefile
     * @return
     */
    public static boolean isExistDataCache(Context context, String cachefile) {
        if (context == null)
            return false;
        boolean exist = false;
        File data = context.getFileStreamPath(cachefile);
        if (data.exists())
            exist = true;
        return exist;
    }


    private String loadFromServer(int page, int classify, float longitude, float latitude,String name,String number,String code) {
        String path = getUrl() + "?key=" + getKey() +"&id="+classify+  "&rows="+ Constant.ROW_COUNTS + "&page=" + page
                + "&classify=" + classify + "&x=" + longitude + "&y=" + latitude+"&name="+name+"&number="+number+"&code="+code;
        HttpUtils utils = new HttpUtils();
        try {
            ResponseStream responseStream = utils.sendSync(HttpRequest.HttpMethod.GET, path);
            String string = responseStream.readString();
            return string;

        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getClassify() {
        return 0;
    }

    protected abstract String getKey();

    protected abstract String getUrl();

    public String readFile(int page){
        URI uri=null;
        try {
            uri=new URI(getUrl());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        File file=new File(UiUtils.getContext().getFilesDir(),getCacheFile(page));

        BufferedReader reader=null;
        try {
            reader=new BufferedReader(new FileReader(file));
            String line =null;
            StringBuffer sb=new StringBuffer();
            while ((line=reader.readLine())!=null){
                sb.append(line.trim());
            }
            Log.i(TAG, "readFile: "+sb.toString());
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private String getCacheFile(int page) {
        return getKey()+"page"+page+"id"+getId();
    }

    protected String getId() {
        return "";
    }

    public String getFromLocal(int page){
        File dirFile=Environment.getExternalStorageDirectory();
        File file=new File(dirFile,"data.txt");

        try {
            FileReader fr=new FileReader(file);
            StringWriter sw=new StringWriter();

            BufferedReader br=new BufferedReader(fr);
            while(br.readLine()!=null){
                String s=br.readLine();
                sw.write(s);
            }

            Log.i(TAG, "getFromLocal: "+sw.toString());
            return sw.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
