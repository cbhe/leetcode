package 力扣;

import java.awt.font.GraphicAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Lc261validTree {

    public static void main(String[] args) {
        int[][] edges = new int[][] {{0,1},{2,3},{1,2}};
        int n = 4;
        System.out.println(new Lc261validTree().validTree(n, edges));
    }
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0)
            return n == 1;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i< n; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] e: edges){
            int x = e[0];
            int y = e[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int root = edges[0][0];
        boolean[] visited = new boolean[n];
        if (hasLoop(graph, -1, root,visited)) {
            return false;
        }

        for (int i = 0; i<visited.length;i++){
            if (!visited[i]) return false;
        }
        return true;
    }

    private boolean hasLoop(List<List<Integer>> graph, int pre, int index, boolean[] visited){

        if (visited[index]) return true;
        visited[index] = true;
        if (graph.get(index).size() == 1 && pre != -1) return false;

        for (int next: graph.get(index)){
            if (next == pre) continue;
            if (hasLoop(graph, index, next, visited)) return true;
        }
        return false;
    }
}
