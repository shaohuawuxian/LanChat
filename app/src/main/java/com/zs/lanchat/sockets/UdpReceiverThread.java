package com.zs.lanchat.sockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by shao on 2017/1/2.
 */

public class UdpReceiverThread extends Thread {

    DatagramSocket datagramSocket=null;
    DatagramPacket packet;

    public UdpReceiverThread(){
        try {
            datagramSocket=new DatagramSocket(9091);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        setPriority(Thread.MAX_PRIORITY);
    }
    @Override
    public void run() {
        while (true){
            try {
                if(datagramSocket==null||datagramSocket.isClosed()){
                    return;
                }
                synchronized (this){
                    byte[] buffer=new byte[8192];
                    packet=new DatagramPacket(buffer,buffer.length);
                    System.out.println("接受数据之前~~~~~");
                    datagramSocket.receive(packet);
                    System.out.println("开始接受数据~~~~~");
                    packet.setData(buffer,0,packet.getLength());
                    byte[] receiverByte=packet.getData();
                    System.out.println("内容长度："+receiverByte.length+"&&"+packet.getLength());
                    System.out.println("内容："+new String(receiverByte,0,packet.getLength()));
                    System.out.println("地址："+packet.getAddress().getHostAddress());
                    System.out.println("端口："+packet.getPort());
                }
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void cancel(){
        if(datagramSocket!=null&&!datagramSocket.isClosed()){
            datagramSocket.close();
        }
        interrupt();
    }
}
