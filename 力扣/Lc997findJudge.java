package 力扣;

public class Lc997findJudge {
    public int findJudge1(int n, int[][] trust) {
        for (int i = 1; i<= n; i++){
            int trustPeople = 0;
            int j = 0;
            for (; j<trust.length;j++){
                int[] pair = trust[j];
                if (pair[0] == i) break;
                if (pair[1] == i) trustPeople++;
            }
            if (j < trust.length) continue;
            if (trustPeople >= n-1){
                return i;
            }
        }
        return -1;
    }

    public int findJudge(int n, int[][] trust){

        int[] inDegrees = new int[n+1];
        int[] outDegrees = new int[n+1];

        for (int[] edge: trust){
            int x = edge[0];
            int y = edge[1];

            outDegrees[x]++;
            inDegrees[y] ++;
        }

        for (int i = 1; i< n+1; i++){
            if (inDegrees[i] == n - 1 && outDegrees[i] == 0){
                return i;
            }
        }
        return -1;
    }
}
