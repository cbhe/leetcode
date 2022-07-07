package 力扣;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc323countComponents {
    public int countComponents1(int n, int[][] edges) {
        List<int[]> edgeList = new LinkedList<>();
        Collections.addAll(edgeList, edges);

        int ret = 0;
        // 找出单个的节点
        int[] nodeArr = new int[n];
        for (int i = 0; i<edges.length; i++){
            for (int j = 0; j<edges[0].length; j++){
                int nodeIndex = edges[i][j];
                nodeArr[nodeIndex] = 1;
            }
        }
        for (int i = 0; i<n;i++){
            if (nodeArr[i] == 0) ret++;
        }

        while (!edgeList.isEmpty()){
            int root = edgeList.get(0)[0];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(root);
            ret++;
            while(!queue.isEmpty()){
                int node = queue.remove();
                for (int i = edgeList.size()-1; i>=0; i--){
                    int[] edge = edgeList.get(i);
                    int x = edge[0];
                    int y = edge[1];
                    if (x != node && y != node){
                        continue;
                    }
                    edgeList.remove(i);
                    if (x != node) queue.add(x);
                    if (y != node) queue.add(y);
                }
            }
        }
        return ret;
    }


    public int countComponents(int n, int[][] edges) {

        int[] id = new int[n];

        for (int i = 0; i<n;i++){
            id[i] = i;
        }

        int count = n;
        for (int[] e: edges){
            if (union(id, e[0], e[1])){
                count--;
            }
        }

        return count;
    }

    private boolean union(int[] id, int x, int y){
        if (id[x] == id[y]) return false;
        int xId = id[x];
        int yId = id[y];
        for (int i = 0; i < id.length; i++){
            if (id[i] == xId)
                id[i] = yId;
        }
        return true;
    }
}
