package TCP练习;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @program: 0611
 * @description: 使用tcp发送数据
 * @author: Wangbobo
 * @created: 2022/06/11 17:35
 */
public class TcpSend {
    public static void main(String[] args) {
        //创建一个udp的socket
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
            //创建一个数据包
            byte[] bytes = "hello".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8000);
            //创建一个数据包的发送地址
            ds.send(packet);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}