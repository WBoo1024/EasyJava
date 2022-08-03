package SocktChat;

import java.io.*;
import java.net.Socket;

/**
 * @program: 0611
 * @description: 利用sockt实现聊天功能，作为客户端
 * @author: Wangbobo
 * @created: 2022/06/11 14:18
 */
public class SocktChatClient {
    public static void main(String[] args) {
        /** 从控制台输入消息 */
        BufferedReader input = null;
        /** 打印控制台发送的消息的流 */
        PrintWriter output = null;
        /** 接受消息的流 */
        BufferedReader accept = null;
        /** 发送消息 */
        PrintStream send = null;
        Socket socket = null;
        try {
            socket = new Socket("localhost", 80);
            System.out.println(socket);
            input = new BufferedReader(new InputStreamReader(System.in));
            accept = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            send = new PrintStream(socket.getOutputStream());
            output = new PrintWriter(System.out);
            boolean flag = true;
            while (true) {
                /** 往服务端发送消息 */
                System.out.println("请输入要发送的消息：");
                String msg = input.readLine();
                send.println(msg);
                send.flush();

                /** 客户端接收服务端发送的消息 */
                String acceptMsg = accept.readLine();
                if (acceptMsg == null || " ".equals(acceptMsg)) {
                    System.out.println("服务端已经关闭");
                    flag = false;
                }else if ("exit".equals(acceptMsg)) {
                    System.out.println("服务端已经关闭");
                    flag = false;
                }else {
                    System.out.println("服务端发送的消息：");
                    output.println(acceptMsg);
                    output.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
