import java.util.Iterator;

public class Subset {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        String s;
        while (!StdIn.isEmpty()) {
            s = StdIn.readString();
            queue.enqueue(s);
        }

        Iterator<String> iterator = queue.iterator();
        for (int i = 0; i < k; i++) {
            String item = iterator.next();
            StdOut.println(item);
        }
    }
}