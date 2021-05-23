package xyz.banjuer.netty.timeserver.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

    static int PORT = 8080;


    public static void main(String[] args) {
        if (args.length != 0) {
            try {
                PORT = Integer.parseInt(args[0]);
            } catch (Exception e) {
                System.out.println("args:" + args[0]);
            }
        }

        try (
            ServerSocket ss = new ServerSocket(PORT)
        ){
            while (true) {
                Socket accept = ss.accept();
                TimeHandler.execute(accept);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
