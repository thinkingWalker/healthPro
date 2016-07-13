package com.example.hanlu.healthyadvisor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.adapter.CommunicateRecylerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2016/7/12  19:04
 *
 * @desc
 */
public class CommunicateActivity  extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communicate);

        list = new ArrayList<>();
        for (int i=0;i<100;i++){
            list.add("你好" + i);
        }


        initView();
        setClickListener();
    }

    private void setClickListener() {
        fab.setOnClickListener(this);
    }

    private void initView() {
        fab = (FloatingActionButton) findViewById(R.id.fab);
        recyclerView = (RecyclerView) findViewById(R.id.recylerview);
        recyclerView.setAdapter(new CommunicateRecylerAdapter(list));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                startActivity(new Intent(CommunicateActivity.this,LiaoLiaoAddActivity.class));
                break;
        }
    }
}
