package xyz.banjuer.csbase.interview;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 计算pi值
 * 蒙特卡洛算法
 * 半径为5的圆，与长为10的正方形
 */
public class GetPI {

    private final int R = 5;
    private final Point CENTER = new Point(R, R);

    static class Point {

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }

    Point getPoint() {
        int x = ThreadLocalRandom.current().nextInt(2 * R + 1);
        int y = ThreadLocalRandom.current().nextInt(2 * R + 1);
        return new Point(x, y);
    }

    double getDistanceFromCenter(Point p) {
        return Math.sqrt((p.x - CENTER.x)*(p.x - CENTER.x) + (p.y - CENTER.y) * (p.y - CENTER.y));
    }

    double getPI(int rounds) {
        int inCircle = 0;
        for (int i = 0; i < rounds; i++) {
            double distance = getDistanceFromCenter(getPoint());
            if (distance < R) {
                ++inCircle;
            }
        }
        return (inCircle / (rounds*1.0))*4;
    }

    public static void main(String[] args) {
        GetPI pi = new GetPI();
        int rounds = 3000000;
        System.out.println(pi.getPI(rounds));
    }

}
