package 多人聊天室;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;

/**
 * @program: 0611
 * @description:
 * @author: Wangbobo
 * @created: 2022/06/11 16:11
 */
public class ServerHandler implements Runnable {
    private Socket socket;
    private List<Socket> socketList;
    BufferedReader bufferedReader = null;
    PrintStream printStream = null;

    public ServerHandler(Socket socket, List<Socket> socketList) {
        this.socket = socket;
        this.socketList = socketList;
    }

    @Override
    public void run() {
        try {
            socketList.add(socket);
            System.out.println("有新的客户端连接，当前在线人数：" + socketList.size());
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printStream = new PrintStream(System.out);
            while (true) {
                String msg = bufferedReader.readLine();
                printStream.println(socket.getInetAddress() + socket.getInetAddress().getHostName() + "/" + "发送消息" + msg);
                printStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socketList.remove(socket);
            System.out.println("有客户端断开连接，当前在线人数：" + socketList.size());
        }


    }
}
