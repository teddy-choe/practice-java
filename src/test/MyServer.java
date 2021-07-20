package test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer {
    public static ArrayList<PrintWriter> m_OutputList;

    public static void main(String[] args) throws ClassNotFoundException {
        m_OutputList = new ArrayList<PrintWriter>();

        try{
            ServerSocket s_socket = new ServerSocket(8888);
            while(true){
                Socket c_socket = s_socket.accept();
                System.out.println("사용자 접속 했습니다");
                System.out.println("Client ip :"+ c_socket.getInetAddress());
                ClientManagerThread c_thread = new ClientManagerThread();
                c_thread.setSocket(c_socket);

                m_OutputList.add(new PrintWriter(c_socket.getOutputStream()));
                System.out.println(m_OutputList.size());
                c_thread.start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
