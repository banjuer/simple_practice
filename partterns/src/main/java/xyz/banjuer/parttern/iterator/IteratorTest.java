package xyz.banjuer.parttern.iterator;

public class IteratorTest {

    public static void main(String[] args) {
        int strLen = 20;
        String[] ss = new String[strLen];
        for (int i = 0; i < strLen; i++) {
            ss[i] = i + "";
        }
        ICollection<String> list = new MyList<>(ss);
        IIterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }

}
