package bg.leif.basics.queue;

/**
 * Created by leiferksn on 25.06.17.
 */
public interface QueueOfStrings {

    void enqueue(String s);
    String dequeue();
    boolean isEmpty();

}
