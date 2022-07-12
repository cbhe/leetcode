package 剑指offer;

import java.util.Arrays;

public class Sro3iiCountBits {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(Arrays.toString(new Sro3iiCountBits().countBits(n)));
    }
    public int[] countBits(int n) {
        if (n == 0) return new int[]{0};
        if (n == 1) return new int[]{0, 1};
        int[] ret = new int[n+1];
        ret[0] = 0;
        ret[1] = 1;
        int p = 1;
        for (int i = 2; i < ret.length; i++){
            int small = 1 << p;
            int large = 1 << (p+1);
            if (i < large){
                ret[i] = ret[i-small] + 1;
            } else {
                ret[i] = 1;
                p++;
            }
        }

        return ret;
    }
}
