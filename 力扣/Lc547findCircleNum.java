package 力扣;

public class Lc547findCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int[] id = new int[isConnected.length];
        int count = isConnected.length;
        for (int i = 0; i<id.length;i++){
            id[i] = i;
        }

        for (int i = 0; i<isConnected.length;i++){
            for (int j=0;j<isConnected.length;j++){
                if (isConnected[i][j] == 1){
                    if (union(id, i, j)){
                        count--;
                    }
                }
            }
        }

        return count;
    }
    private boolean union(int[] id, int x, int y){
        if (id[x] == id[y]) return false;
        int xId = id[x];
        int yId = id[y];
        for (int i = 0; i<id.length;i++){
            if (id[i] == xId){
                id[i] = yId;
            }
        }
        return true;
    }
}
