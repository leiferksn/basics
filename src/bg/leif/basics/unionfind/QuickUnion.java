package bg.leif.basics.unionfind;

/**
 * Created by leiferksn on 18.06.17.
 *
 * Lazy approach - find is more complicated, union is easy
 *
 * Because we use trees to connect the elements, the
 * performance here depends on the depth of
 */
public class QuickUnion extends UnionFind {

    public QuickUnion(int aElements){
        init(aElements);
    }

    /**
     * Performance (number of array accesses) depends on the depth of aElement
     * @param aElement element for which we need to find the root
     * @return the root element
     */
    private int root(int aElement) {
        int root = elements[aElement];
        if (root != aElement) {
            return root(root);
        } else {
            return root;
        }

        /*
        without recursion it will be:

        while (i != elements[i]) {
        i = elements[i]
        }
        return i;
         */
    }

    @Override
    public void union(int p, int q) {
        int firstRoot = root(p);
        int secondRoot = root(q);
        elements[firstRoot] = secondRoot;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
