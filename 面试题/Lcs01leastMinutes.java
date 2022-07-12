package 面试题;

public class Lcs01leastMinutes {
    public int leastMinutes(int n) {
        if (n == 1) return 1;

        int ret = 2;
        while (1 << (ret - 1) < n){
            ret ++;
        }
        return ret;
    }
}
