package interview.sept2622.task3;


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 读取依赖关系
//        String[] data = sc.next().split(",");
        String[] data = "a1-a2,a5-a6,a2-a3".split(",");

        // 读取故障服务 id
//        String[] failures = sc.next().split(",");
        String[] failures = "a5,a2".split(",");

        // 将所有服务写入 set, 构建图对象, 创建访问标记表
        Set<String> services = new LinkedHashSet<>();
//        Map<String, Boolean> visited = new HashMap<>();
        Graph g = new Graph();
        for (String entry : data) {
            String[] ss = entry.split("-");
            services.add(ss[0]);
            services.add(ss[1]);

            g.add(ss[1], ss[0]);
//            visited.put(ss[0], false);
//            visited.put(ss[1], false);
        }
        System.out.println(services);


        // 遍历故障服务, 做深度优先搜索, 在服务 set 中去除掉故障的服务
        for (String id : failures) {
            dfs(g, id, services);
        }

        // 输出剩余的服务 (无故障)
        int foo = 0;
        for (String service : services) {
            if (foo == 0) {
                System.out.print(service);
                foo++;
            } else {
                System.out.print("," + service);
            }
        }
    }

    private static void dfs(Graph g, String id, Set<String> services) {
        services.remove(id);
        List<String> adjs = g.adj(id);
        for (String adj : adjs) {
            dfs(g, adj, services);
        }
    }
}

class Graph {
    private Map<String, List<String>> data = new HashMap<>();

    public void add(String from, String to) {
        if (data.get(from) == null) {
            List<String> list = new ArrayList<>();
            list.add(to);
            data.put(from, list);
        } else {
            data.get(from).add(to);
        }
    }

    public List<String> adj(String key) {
        return data.get(key) == null ? Collections.EMPTY_LIST : data.get(key);
    }
}
