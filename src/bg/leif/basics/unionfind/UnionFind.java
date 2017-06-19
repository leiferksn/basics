package bg.leif.basics.unionfind;

/**
 * Created by leiferksn on 18.06.17.
 */
public abstract class UnionFind {

    protected int[] elements;

    /**
     *  we can't change init -> we still need to initialze,
     *  so N operations
     */
    protected void init (int aElements) {
        elements = new int[aElements];
        for (int i = 0; i < aElements; i++) {
            elements[i] = i;
        }
    }

    public void outputElements() {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
    public abstract void union(int p, int q);
    public abstract boolean connected (int p, int q);

}
