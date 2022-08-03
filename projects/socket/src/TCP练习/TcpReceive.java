package TCP练习;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @program: 0611
 * @description: 使用Tcp接收数据
 * @author: Wangbobo
 * @created: 2022/06/11 17:39
 */
public class TcpReceive {
    public static void main(String[] args) {
        //创建一个udp的socket
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(8000);
            //创建一个数据包
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            //接收数据
            ds.receive(packet);
            //获取数据包的数据
            String str = new String(bytes, 0, packet.getLength());
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}