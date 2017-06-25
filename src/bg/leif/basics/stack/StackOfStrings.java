package bg.leif.basics.stack;

/**
 * Created by leiferksn on 25.06.17.
 */
public interface StackOfStrings {
    boolean isEmpty();

    void push(String element);

    String pop();

    String toString();
}
