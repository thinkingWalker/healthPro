package com.example.hanlu.healthyadvisor.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.activity.BaseActivity;
import com.example.hanlu.healthyadvisor.bean.FoodAllListInfo;
import com.example.hanlu.healthyadvisor.holder.BaseHolder;
import com.example.hanlu.healthyadvisor.holder.FoodAllHolder;
import com.example.hanlu.healthyadvisor.protocol.FoodAllListProtocol;
import com.example.hanlu.healthyadvisor.utils.ACache;
import com.example.hanlu.healthyadvisor.utils.UiUtils;
import com.example.hanlu.healthyadvisor.view.EmptyLayout;
import com.example.hanlu.healthyadvisor.view.LoadingView;
import com.google.gson.Gson;
import com.umeng.analytics.MobclickAgent;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by hanlu on 2016/3/5.
 */
public class FoodAll extends Activity implements RadioGroup.OnCheckedChangeListener {
    int page = 1;
    private ListView listView;
    private RadioGroup radioGroup;
    private List<FoodAllListInfo.ResultEntity> result;
    private int myID;
    public static final String url="http://api.avatardata.cn/Food/List";
    public static final String key="ca7f16de78a2464292d19b2cde46038b";
    private ACache mCache;
    private EmptyLayout empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    public void initView() {
        setContentView(R.layout.actvity_foodall);
        mCache = ACache.get(this);
        listView = (ListView) findViewById(R.id.food_all_content);
        radioGroup = (RadioGroup) findViewById(R.id.rg);
        empty = (EmptyLayout) findViewById(R.id.empty_layout);
        empty.setOnLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData(myID);
            }
        });
        empty.setErrorType(EmptyLayout.NETWORK_LOADING);
        RadioButton radioButton= (RadioButton) radioGroup.getChildAt(0);
        radioButton.setChecked(true);
        radioGroup.setOnCheckedChangeListener(this);

        getData(2);
    }

    public  void requestNetwork(final int id2){
        OkHttpUtils.get()
                .url(url)
                .addParams("key", key)
                .addParams("page",String.valueOf(page))
                .addParams("rows","20")
                .addParams("id",String.valueOf(id2))
                .build()
                .execute(new FoodAllCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        e.printStackTrace();
                        empty.setErrorType(EmptyLayout.NETWORK_ERROR);
                    }
                    @Override
                    public void onResponse(FoodAllListInfo response, int id) {
                        if (response.getResult().size()==0){
                            empty.setErrorType(EmptyLayout.NODATA);
                        }
                        Log.i("getData", "onResponse: " + id2);
                        mCache.put("FoodAllListInfo" + id2, response, 60 * 60 * 24);//保存24个小时

                        showSuccessView(response);
                    }
                });
    }

    public void getData(int id){
        empty.setErrorType(EmptyLayout.NETWORK_LOADING);
        this.myID=id;
        FoodAllListInfo foodAllListInfo = (FoodAllListInfo) mCache.getAsObject("FoodAllListInfo"+id);
        if (foodAllListInfo!=null){
            //直接从本地读取
            showSuccessView(foodAllListInfo);
            Log.i("getData", "getData: "+"本地");
        }else {
            //请求网络
            requestNetwork(id);
            Log.i("getData", "getData: " + "网络"+id);

        }




    }
    public abstract class FoodAllCallback extends Callback<FoodAllListInfo> {
        @Override
        public FoodAllListInfo parseNetworkResponse(Response response, int id) throws Exception {
            {
                Gson gson = new Gson();
                FoodAllListInfo foodAllListInfo = gson.fromJson(response.body().string(), FoodAllListInfo.class);
                Log.i("gson", "parseNetworkResponse: " + foodAllListInfo.toString());
                return foodAllListInfo;
            }
        }
    }

    private void showSuccessView(FoodAllListInfo foodAllListInfo) {
        empty.setErrorType(EmptyLayout.HIDE_LAYOUT);
        this.result=foodAllListInfo.getResult();
        listView.setAdapter(new FoodAllAdapter());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(UiUtils.getContext(), FoodAllDetailActivity.class);
                intent.putExtra("id",result.get(position).getId());
                startActivity(intent);
            }
        });
    }



    private class FoodAllAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return result.size();
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(UiUtils.getContext(), R.layout.holder_foodall_list, null);
            final ImageView imageView = (ImageView) view.findViewById(R.id.item_food_all_image);
            TextView  name= (TextView) view.findViewById(R.id.item_food_all_name);
            name.setText(result.get(position).getName());
            Bitmap asBitmap = mCache.getAsBitmap("FoodAllListInfoImage"+position+myID);
            if (asBitmap!=null){
                //保存的如果有的话
                imageView.setImageBitmap(asBitmap);
                Log.i("getData", "getView: "+"从本地图片");
            }else {
                setFoodImage(imageView,position);
                Log.i("getData", "getView: " + "从网络图片");

            }
            return view;
        }
    }


    public void setFoodImage(final ImageView imageView, final int position){
        //请求图片
        OkHttpUtils
                .get()
                .url(result.get(position).getImg())
                .build()
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                    }
                    @Override
                    public void onResponse(Bitmap response, int id) {
                        mCache.put("FoodAllListInfoImage"+position+myID,response);//保存图片
                        imageView.setImageBitmap(response);
                    }
                });
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.gai:
                getData(2);
                break;
            case R.id.qi:
                getData(3);
                break;
            case R.id.pinxue:
                getData(4);
                break;
            case R.id.jiannao:
                getData(5);
                break;
            case R.id.jianghuo:
                getData(6);
                break;
            case R.id.immunity:
                getData(7);
                break;
            case R.id.bianmi:
                getData(8);
                break;
            case R.id.qingchang:
                getData(9);
                break;
            case R.id.diarrhea:
                getData(10);
                break;
            case R.id.fever:
                getData(11);
                break;
            case R.id.sweat:
                getData(12);
                break;
            case R.id.buxue:
                getData(13);
                break;
            case R.id.iron:
                getData(14);
                break;
            case R.id.zn:
                getData(15);
                break;
            case R.id.xi:
                getData(16);
                break;
            case R.id.dian:
                getData(17);
                break;
            case R.id.lung:
                getData(18);
                break;
            case R.id.liver:
                getData(19);
                break;
            case R.id.kidney:
                getData(20);
                break;
            case R.id.heart:
                getData(21);
                break;
            case R.id.qixue:
                getData(22);
                break;
            case R.id.yangxue:
                getData(23);
                break;
            case R.id.jianppi:
                getData(24);
                break;
            case R.id.stomach:
                getData(25);
                break;
            case R.id.eyes:
                getData(26);
                break;
            case R.id.intestines:
                getData(27);
                break;
            case R.id.forgetful:
                getData(28);
                break;
            case R.id.damp:
                getData(29);
                break;
            case R.id.appetite:
                getData(30);
                break;
            case R.id.digestion:
                getData(31);
                break;
            case R.id.radiation:
                getData(32);
                break;
            case R.id.smog:
                getData(33);
                break;
            case R.id.decompression:
                getData(34);
                break;
            case R.id.dyspepsia:
                getData(35);
                break;
            case R.id.afteroperation:
                getData(36);
                break;
            case R.id.buxu:
                getData(37);
                break;
            case R.id.zhuagnyao:
                getData(38);
                break;
            case R.id.hemostasis:
                getData(39);
                break;
            case R.id.sugan:
                getData(40);
                break;
            case R.id.diuresis:
                getData(41);
                break;
            case R.id.yeniao:
                getData(42);
                break;
            case R.id.malnutrition:
                getData(43);
                break;
            case R.id.weileng:
                getData(44);
                break;
            case R.id.luansheng:
                getData(45);
                break;
            case R.id.yuhan:
                getData(46);
                break;
            case R.id.fattening:
                getData(47);
                break;
            case R.id.weight:
                getData(48);
                break;

            case R.id.huoxue:
                getData(49);
                break;
            case R.id.carsickness:
                getData(50);
                break;
            case R.id.ziyin:
                getData(51);
                break;
            case R.id.yishou:
                getData(52);
                break;

            case R.id.yizhi:
                getData(53);
                break;
            case R.id.xiaoshu:
                getData(54);
                break;
            case R.id.qingre:
                getData(55);
                break;
            case R.id.memory:
                getData(56);
                break;

            case R.id.kaiwei:
                getData(57);
                break;
        }
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

}
