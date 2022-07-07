package 力扣;

public class Lc990 {

    public boolean equationsPossible(String[] equations) {
        int[] id = new int[26];
        for (int i = 0; i<id.length;i++){
            id[i] = i;
        }
        for (String equation: equations){
            int x = equation.charAt(0) - 'a';
            int y = equation.charAt(3) - 'a';
            String op = equation.substring(1, 3);
            if (op.equals("!=")) continue;

            union(id, x, y);
        }
        for (String equation: equations){
            int x = equation.charAt(0) - 'a';
            int y = equation.charAt(3) - 'a';
            String op = equation.substring(1, 3);
            if (op.equals("==")) continue;

            if (x == y || id[x] == id[y]) return false;
        }
        return true;
    }

    private void union(int[] id, int x, int y){
        if (id[x] == id[y]) return;
        int idx = id[x];
        int idy = id[y];
        for (int i = 0; i<id.length; i++){
            if (id[i] == idx) id[i] = idy;
        }
    }
}
