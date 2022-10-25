package interview.sept1422.task3;

// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.

import java.util.*;

public class Main {
    private int TTL = 0;
    private int distance = Integer.MAX_VALUE;
    private boolean pathFound = false;

    public boolean isPathFound() {
        return pathFound;
    }

    private Map<Integer, Boolean> visited;

    private Graph g;

    public Main(Graph g) {
        this.g = g;
        visited = new HashMap<>();
        for (Map.Entry<Integer, List<AdjNode>> entry : g.getData().entrySet()) {
            visited.put(entry.getKey(), false);
        }
    }

    public int getTTL() {
        return TTL;
    }

    public int getDistance() {
        return distance;
    }

    public void dfs(int s, int t, int ttl, int distance) {
        if (s == t) {
            if (ttl >= this.TTL && distance < this.distance) {
                pathFound = true;
                this.distance = distance;
                this.TTL = ttl;
                return;
            }
        }

        if (ttl == -1) {
            return;
        }

        if (visited.get(s)) {
            return;
        }

        visited.put(s, true);

        if (g.adjs(s) != null) {
            for (AdjNode node : g.adjs(s)) {
                dfs(node.getId(), t, ttl - 1, distance + node.getDist());
            }
        }

        visited.put(s, false);
    }

    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int s = sc.nextInt();
        int t = sc.nextInt();
        int TTL = sc.nextInt();

        Graph g = new Graph();

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            g.insert(a, new AdjNode(b, c));
            g.insert(b, new AdjNode(a, c));
        }

        System.out.println(g);

        // please finish the function body here.
        Main main = new Main(g);
        main.dfs(s, t, TTL, 0);
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        if (!main.isPathFound()) {
            System.out.println(-1);
            return;
        }
        System.out.println(main.getDistance() + " " + main.getTTL());
    }
}

class AdjNode {
    private int id;
    private int dist;


    public AdjNode(int id, int dist) {
        this.dist = dist;
        this.id = id;
    }

    public int getDist() {
        return dist;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{" +
                "" + id +
                ", " + dist +
                '}';
    }
}

class Graph {
    private Map<Integer, List<AdjNode>> data = new HashMap<>();

    public List<AdjNode> adjs(int id) {
        return data.get(id);
    }

    public Map<Integer, List<AdjNode>> getData() {
        return data;
    }

    public void insert(int id, AdjNode node) {
        if (data.get(id) == null) {
            data.put(id, new ArrayList<>());
        }
        data.get(id).add(node);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, List<AdjNode>> entry : data.entrySet()) {
            builder.append(entry.getKey() + ": [");
            for (AdjNode node : entry.getValue()) {
                builder.append(node.toString() + " ");
            }
            builder.append("], \n");
        }

        return builder.toString();
    }
}


/*

10 1 7 255
1 2 3
1 5 2
1 8 5
2 3 3
2 5 3
3 4 3
4 7 3
5 6 2
6 7 2
8 7 6

10 1 7 2
1 2 3
1 5 2
1 8 5
2 3 3
2 5 3
3 4 3
4 7 3
5 6 2
6 7 2
8 7 6

10 1 7 1
1 2 3
1 5 2
1 8 5
2 3 3
2 5 3
3 4 3
4 7 3
5 6 2
6 7 2
8 7 6

 */