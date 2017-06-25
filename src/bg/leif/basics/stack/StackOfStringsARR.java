package bg.leif.basics.stack;

/**
 * Created by leiferksn on 25.06.17.
 *
 * Array implementation of a stack
 */
public class StackOfStringsARR implements StackOfStrings {

    private String[] stack = new String[5];
    private int top = 0;

    @Override
    public boolean isEmpty() {
        return top <= 0;
    }

    @Override
    public void push(String element) {
        if (top >= stack.length){
            stack = resize();
        }
        stack[top] = element;
        top++;
    }

    @Override
    public String pop() {
        if (!isEmpty()){
            String topElement = stack[top - 1];
            stack[top - 1] = null;
            top--;
            return topElement;
            // return stack[--top];
        }
        return null;
    }

    private String[] resize() {
        String[] copyOfStack = new String[top * 2];
        for (int i = 0; i < stack.length; i++) {
            copyOfStack[i] = stack[i];
        }
        return copyOfStack;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return null;
        }
        String separator = " -> ";
        StringBuffer sb = new StringBuffer();
        for(int i = top -1; i >= 0; i-- ) {
            sb.append(stack[i]);
            sb.append(separator);
        }
        String s = sb.toString();
        return s.substring(0, s.length() - separator.length()) + ", size: " + stack.length;
    }
}
