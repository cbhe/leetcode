package 力扣;

import java.util.ArrayList;
import java.util.List;

public class Lc1557findSmallestSetOfVertices {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegrees = new int[n];
        for (List<Integer> edge: edges){
            int y = edge.get(1);
            inDegrees[y] ++;
        }

        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i< n; i++){
            if (inDegrees[i] == 0){
                ret.add(i);
            }
        }

        return ret;
    }
}
