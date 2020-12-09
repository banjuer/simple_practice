package xyz.banjuer.jvm.part2.ch02;

import java.util.LinkedList;
import java.util.List;

/**
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 */
public class HeapOOM {

static class OOMObject {
        private final byte[] bs = new byte[1024];
    }

    public static void main(String[] args) {
        List<OOMObject> list = new LinkedList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }


}
