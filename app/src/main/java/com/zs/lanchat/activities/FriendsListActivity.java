package com.zs.lanchat.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zs.lanchat.R;
import com.zs.lanchat.adapters.FriendsListAdater;
import com.zs.lanchat.sockets.UdpReceiverThread;
import com.zs.lanchat.sockets.UdpSendThread;

import java.util.ArrayList;

/**
 * Created by shao on 2016/12/30.
 */

public class FriendsListActivity extends BaseActivity {

    RecyclerView friendsList;
    FriendsListAdater friendsListAdater;
    UdpReceiverThread udpReceiverThread;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendslist);
        friendsList=(RecyclerView)findViewById(R.id.friendslist);
        friendsList.setLayoutManager(new LinearLayoutManager(this));
        friendsListAdater=new FriendsListAdater();
        friendsList.setAdapter(friendsListAdater);

        udpReceiverThread=new UdpReceiverThread();
        udpReceiverThread.start();
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add("s"+i);
        }
        ArrayList<String> cloneList=(ArrayList<String>)list.clone();
        System.out.println("size=="+cloneList.size());

        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               for(int i=0;i<20;i++){
                   UdpSendThread udpSendThread=new UdpSendThread("我是第"+i+"个");
                   udpSendThread.start();
               }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        udpReceiverThread.cancel();
    }
}
