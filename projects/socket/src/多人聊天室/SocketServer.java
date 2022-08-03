package 多人聊天室;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: 0611
 * @description: 部署服务端，实现多人在线聊天功能
 * @author: Wangbobo
 * @created: 2022/06/11 15:59
 */
public class SocketServer {
    public static void main(String[] args) {
        // 1.创建一个ServerSocket对象
        ServerSocket serverSocket = null;
        List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());
        ExecutorService executors = Executors.newFixedThreadPool(10);
        try {
            serverSocket = new ServerSocket(80);
            // 2.等待客户端的连接
            System.out.println("服务端已打开，等待客户端连接...");

            while (true) {
                // 3.接收客户端的连接
                Socket socket = serverSocket.accept();
                ServerHandler serverHandler = new ServerHandler(socket, socketList);
                executors.execute(serverHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
