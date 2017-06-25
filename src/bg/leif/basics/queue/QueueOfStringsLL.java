package bg.leif.basics.queue;

/**
 * Created by leiferksn on 25.06.17.
 *
 * LinkedList implementation of Queue
 *
 */
public class QueueOfStringsLL implements QueueOfStrings {

    private Node back = null;
    private Node front = null;

    private class Node {
        private String name;
        private Node reference;

        public String toString() {
            return name;
        }
    }

    @Override
    public void enqueue(String s) {
        Node n = new Node();
        n.name = s;
        if (isEmpty()) {
            front = n;
        } else {
            back.reference = n;
        }
        back = n;
    }

    @Override
    public String dequeue() {
        if (isEmpty()) {
            // for purists
            back = null;
            return null;
        }
        Node n = front;
        front = front.reference;
        return n.name;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        QueueOfStringsLL.Node n = front;
        while (n != null) {
            sb.append(n.toString());
            if (n.reference != null) {
                sb.append(" <- ");
            }
            n = n.reference;
        }
        return sb.toString();
    }
}
