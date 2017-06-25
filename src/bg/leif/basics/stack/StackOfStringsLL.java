package bg.leif.basics.stack;

/**
 * Created by leiferksn on 25.06.17.
 *
 * LinkedList implementation of Stack
 *
 */
public class StackOfStringsLL implements StackOfStrings {

    private Node topNode = null;

    private class Node {
        private String name;
        private Node reference;

        public String toString() {
            return name;
        }
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void push(final String element) {
        Node node = new Node();
        node.name = element;
        node.reference = topNode;
        topNode = node;
    }

    @Override
    public String pop() {
        if (!isEmpty()) {
            Node top = topNode;
            topNode = topNode.reference;
            return top.name;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node n = topNode;
        while (n != null) {
            sb.append(n.toString());
            if (n.reference != null) {
                sb.append(" -> ");
            }
            n = n.reference;
        }
        return sb.toString();
    }
}
