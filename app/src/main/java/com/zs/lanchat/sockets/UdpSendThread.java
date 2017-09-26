package com.zs.lanchat.sockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by shao on 2017/1/2.
 */

public class UdpSendThread extends Thread {

    DatagramSocket datagramSocket=null;
    DatagramPacket packet;
    String name;

    public UdpSendThread(String name){
        try {
            datagramSocket=new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        this.name=name;
    }
    @Override
    public void run() {

        synchronized (this){
            if(datagramSocket==null||datagramSocket.isClosed()){
                return;
            }
            try {
                datagramSocket.setBroadcast(true);
                InetAddress inetAddress=InetAddress.getByName("255.255.255.255");
                byte[] sendContent=(name+"我是广播").getBytes();
                packet=new DatagramPacket(sendContent,sendContent.length,inetAddress,9091);
                datagramSocket.send(packet);
                datagramSocket.close();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
