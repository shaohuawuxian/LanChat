package com.zs.lanchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by shao on 2016/12/31.
 */

public class UDPTest {


    public static void udp(){
        try {
            //DatagramSocket datagramSocket=new DatagramSocket();
            DatagramPacket packet=new DatagramPacket(new byte[10000],10000);
            System.out.println("packet.data.length="+packet.getData().length);
            System.out.println("packet.length="+packet.getLength());
//            datagramSocket.receive(packet);
//            datagramSocket.send(packet);
            //datagramSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
