package 力扣;


public class Lc427construct {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}};
        System.out.println(new Lc427construct().construct(grid));
    }
    public Node construct(int[][] grid) {
        return create(grid, 0, grid[0].length-1, 0, grid.length-1);
    }

    private Node create(int[][] grid, int left, int right, int top, int bottom){
        if (left == right && top == bottom){
            return new Node(grid[top][left] == 1, true);
        }

        int val = grid[top][left];
        Node cur = new Node(val == 1, true);
        for(int i = top;i<=bottom;i++){
            for (int j = left;j<=right;j++){
                if (grid[i][j]!=val){
                    cur.isLeaf = false;
                    break;
                }
            }
            if (!cur.isLeaf){
                break;
            }
        }
        if (cur.isLeaf){
            return cur;
        }

        cur.topLeft = create(grid, left,(left+right)/2, top, (top+bottom)/2 );
        cur.topRight = create(grid, (left+right)/2 + 1, right, top, (top+bottom)/2 );
        cur.bottomLeft = create(grid, left,(left+right)/2 , (top+bottom)/2 + 1, bottom );
        cur.bottomRight = create(grid, (left+right)/2 + 1, right, (top+bottom)/2 + 1, bottom );

        return cur;
    }
}

class Node{
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
