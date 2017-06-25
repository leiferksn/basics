package bg.leif.basics.queue;

/**
 * Created by leiferksn on 25.06.17.
 *
 * Array implementation of a Queue
 *
 */
public class QueueOfStringsARR implements QueueOfStrings {

    private String[] queue = new String[10];
    private int front = 0;
    private int back = 0;

    @Override
    public void enqueue(String s) {
        queue[back] = s;
        back++;
        if (back >= queue.length){
            queue = resize();
        }
    }

    private String[] resize() {
        String[] copyOfStack = new String[queue.length * 2];
        int offset = back - front;
        for (int i = 0; i < offset; i++) {
            copyOfStack[i] = queue[front + i];
        }
        front = 0;
        back = front + offset;
        return copyOfStack;
    }

    @Override
    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        String s = queue[front];
        queue[front] = null;
        front++;
        return s;
    }

    @Override
    public boolean isEmpty() {
        return front == back;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return null;
        }
        String separator = " -> ";
        StringBuffer sb = new StringBuffer();
        for(int i = back - 1; i >= front; i-- ) {
            sb.append(queue[i]);
            sb.append(separator);
        }
        String s = sb.toString();
        return s.substring(0, s.length() - separator.length()) + ", size: " + queue.length;
    }
}
