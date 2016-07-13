package com.example.hanlu.healthyadvisor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.bean.MyUser;
import com.litesuits.android.log.Log;
import com.litesuits.common.utils.MD5Util;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Admin on 2016/7/12  16:18
 *登录注册操作
 * @desc
 */
public class LoginActivity extends AppCompatActivity {

    private EditText userName;
    private EditText passWord;
    private MyUser user;
    private MyUser userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = (EditText) findViewById(R.id.username);
        passWord = (EditText) findViewById(R.id.password);
        user = new MyUser();//初始化用户
        userLogin = new MyUser();
    }

    public void regist(View view){
        user.setUsername(userName.getText().toString());
        byte[] bytes = MD5Util.md5(passWord.getText().toString());
        user.setPassword(new String(bytes));
        user.signUp(new SaveListener<MyUser>() {
            @Override
            public void done(MyUser bombu, BmobException e) {
                if (e==null){
                    //注册成功
                    Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    userName.setText("");
                    passWord.setText("");
                }else {
                    //注册出错误
                    String string = e.toString();
                    Log.i("message",string);
                }
            }
        });
    }

    public void login(View view){
        userLogin.setUsername(userName.getText().toString());
        byte[] bytes = MD5Util.md5(passWord.getText().toString());

        userLogin.setPassword(new String(bytes));
        userLogin.login(new SaveListener<MyUser>() {
            @Override
            public void done(MyUser myUser, BmobException e) {
                if (e==null){
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }else {
                    String message = e.getMessage();
                    Log.i("message",message);
                }
            }
        });
    }



}
