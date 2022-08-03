package 多人聊天室;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @program: 0611
 * @description: 实现一个客户端，完成多人聊天功能
 * @author: Wangbobo
 * @created: 2022/06/11 16:00
 */
public class SocketClient_Wang {
    public static void main(String[] args) throws IOException {
        // 1.创建一个Socket对象
        Socket socket = new Socket("172.30.1.200", 8888);
        BufferedReader bufferedReader = null;
        PrintStream printStream = null;
        while (true) {
            System.out.println("请输入要发送的消息：");
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            printStream = new PrintStream(socket.getOutputStream());
            String msg = bufferedReader.readLine();
            printStream.println(socket.getInetAddress().getHostAddress() + "/" + socket.getInetAddress().getHostName() + "发送消息：" + msg);
        }

    }
}