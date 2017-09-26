package com.zs.lanchat.activities;

import android.content.Intent;
import android.os.Bundle;

import com.zs.lanchat.UDPTest;

/**
 * Created by zhangshao on 2016/12/29.
 */

public class WelcomeActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UDPTest.udp();
        Intent intent=new Intent(this,FriendsListActivity.class);
        startActivity(intent);
        finish();
    }
}
