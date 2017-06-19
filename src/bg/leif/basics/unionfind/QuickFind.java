package bg.leif.basics.unionfind;

/**
 * Created by leiferksn on 18.06.17.
 *
 * Eager approach - find is easy, union is slow
 *
 */

public class QuickFind  extends UnionFind {

    public QuickFind(int aElements){
        init(aElements);
    }

    @Override
    public boolean connected(int p, int q){
        return this.elements[p] == this.elements[q];
    }

    /**
     *  at most 2N + 2 accesses -> every time we execute union command,
     *  we need to go and this sucks. if we have n elements to execute union command for
     *  we end up with n^2 operations.
     *
     */
    @Override
    public void union(int p, int q) {
        int wasId = elements[p];
        int toBeId = elements[q];
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == wasId) {
                elements[i] = toBeId;
             }
        }
    }

    // n accesses
    @Override
    protected void init(int aElements){
        int numberOfElements = aElements <= 0 ? 10 : aElements;
        elements = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            elements[i] = i;
        }
    }

}
