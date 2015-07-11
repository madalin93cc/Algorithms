package algorithms.interfaces;

/**
 * Created by Colezea on 11/07/2015.
 */
public interface UnionFind {
    boolean connected(int p, int q);
    void union(int p, int q);
    int count();
}
