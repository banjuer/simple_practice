package xyz.banjuer.parttern.iterator;

public class MyList<E> implements ICollection<E> {

    private E[] arr;

    public MyList(E[] arr) {
        this.arr = arr;
    }

    @Override
    public IIterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator<E> implements IIterator<E> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < arr.length;
        }

        @Override
        public E next() {
            return (E) arr[index++];
        }
    }

}
