package xyz.banjuer.netty.timeserver.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimeHandler {
    static ExecutorService timerPool = new ThreadPoolExecutor(2, 20, 2, TimeUnit.HOURS, new ArrayBlockingQueue<>(1024));

    static void execute(Socket socket) {
        timerPool.execute(() -> {
            System.out.println("server receive a socket...");
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                final String s = in.readLine();
                if("exit".equalsIgnoreCase(s)) {
                    System.out.println("receive exit order");
                    System.exit(0);
                }
                String time = "bad order";
                if ("query time order".equalsIgnoreCase(s)) {
                    time = new Date(System.currentTimeMillis()).toString();
                }
                out.println(time);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
