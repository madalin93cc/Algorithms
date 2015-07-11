import java.util.Scanner;

/**
 * Given a set of N objects.
 * Union command: connect two objects.
 * Find/connected query: is there a path connecting the two objects?
 * Applications involve manipulating objects of all types:
 *  Pixels in a digital photo.
 *  Computers in a network.
 *  Friends in a social network.
 *  Transistors in a computer chip.
 *  Elements in a mathematical set.
 *  Variable names in Fortran program.
 *  Metallic sites in a composite system.
 *
 * Weighted quick-union
 *  Initialize -> N
 *  Find. Identical to quick-union: return find(p) == find(q) -> lgN
 *  Union. Modify quick-union to: -> lg(N)
 *      Link root of smaller tree to root of larger tree.
 *      Update the sz[] array.
 */
public class UnionFind {

    private int[] id;   // parent link(site indexes)
    private int[] sz;   // size of component for roots(site indexes)
    private int count;  // number of components

    public UnionFind(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }

    public int count(){
        return count;
    }

    private int find(int p){
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int i = find(p);
        int j = find(q);

        if (i == j) return;

        if (sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String line = null;
        int N = in.nextInt();
        UnionFind uf = new UnionFind(N);
        line = in.nextLine();
        while (!(line = in.nextLine()).isEmpty())
        {
            String[] ints = line.split(" ");
            int p = Integer.parseInt(ints[0]);
            int q = Integer.parseInt(ints[1]);
            if (!uf.connected(p, q))
            {
                uf.union(p, q);
                System.out.println(p + " " + q);
            }
        }
    }
}
