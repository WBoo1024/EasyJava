package SocktChat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: 0611
 * @description: 利用sockt实现聊天功能
 * @author: Wangbobo
 * @created: 2022/06/11 14:13
 */
public class SocktChatServer {
    public static void main(String[] args) {
        /** 从控制台输入消息 */
        BufferedReader input = null;
        /** 打印控制台发送的消息的流 */
        PrintWriter output = null;
        /** 接受消息的流 */
        BufferedReader accept = null;
        /** 发送消息 */
        PrintStream send = null;
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(80);
            System.out.println("服务器启动成功,等待客户端连接...");
            socket = serverSocket.accept();
            System.out.println("客户端连接成功");
            input = new BufferedReader(new InputStreamReader(System.in));
            accept = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            send = new PrintStream(socket.getOutputStream());
            output = new PrintWriter(System.out);

            boolean flag = true;
            while (true) {
                /** 先接收客户端发送的消息 */
                String msg = accept.readLine();
                if(null == msg || " ".equals(msg)){
                    System.out.println("客户端已经关闭");
                    flag = false;
                }else if ("exit".equals(msg)) {
                    System.out.println("客户端已经关闭");
                    flag = false;
                }else {
                    System.out.println("客户端发送的消息：");
                    output.println(msg);
                    output.flush();
                    /** 往客户端发送消息 */
                    System.out.println("请输入要发送的消息：");
                    String sendMsg = input.readLine();
                    send.println(sendMsg);
                    send.flush();

                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
