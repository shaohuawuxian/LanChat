package com.zs.lanchat;

import android.app.Application;

import com.zs.lanchat.sockets.UdpReceiverThread;

/**
 * Created by zhangshao on 2016/12/29.
 */

public class ChatApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new UdpReceiverThread().start();//初始化udp接收器
    }

}
