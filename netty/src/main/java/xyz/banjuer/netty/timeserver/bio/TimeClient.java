package xyz.banjuer.netty.timeserver.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class TimeClient {

    static int MAX_TRY_TIMES = 100;
    static int SERVER_PORT = 8080;

    public static void main(String[] args) {
        int THREADS = 10;
        final AtomicInteger MAX_TIMES = new AtomicInteger(10000);

        // 模拟THREADS个客户端
        for (int i = 0; i < 1; i++) {
            new Thread(() -> send(MAX_TIMES)).start();
        }
    }

    static void send(AtomicInteger max) {
        final Socket socket = getClient();
        try (
            final PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            String ORDER = "query time order";
            for (int i = 0; i < max.get(); i++) {
                out.println(ORDER);
                System.out.println("client" + Thread.currentThread().getId() + " send:" + ORDER);
                final String s = in.readLine();
                System.out.println("client" + Thread.currentThread().getId() + " receive:" + s);
                max.decrementAndGet();
            }
            out.println("exit");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static Socket getClient() {
        for (int i = 0; i < MAX_TRY_TIMES; i++) {
            try {
                return new Socket("127.0.0.1", SERVER_PORT);
            } catch (Exception e) {
                System.out.println(e + " " + SERVER_PORT);
            }
        }
        throw new RuntimeException("unable get an usable port");
    }

}
