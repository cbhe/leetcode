import java.util.ArrayList;
import java.util.List;

public class Lc165CompareVersion {

    public static void main(String[] args) {
        Lc165CompareVersion obj = new Lc165CompareVersion();
        String v1 = "1.0.1";
        String v2 = "1";
        System.out.println(obj.compareVersion(v1, v2));
    }
    public int compareVersion(String version1, String version2) {
        // 分隔
        String[] sa1 = version1.split("\\.");
        String[] sa2 = version2.split("\\.");

        // 转换成数字
        List<Integer> l1 = new ArrayList<>();
        for (String value : sa1) {
            l1.add(StringToInt(value));
        }
        List<Integer> l2 = new ArrayList<>();
        for (String s : sa2) {
            l2.add(StringToInt(s));
        }

        // 补齐
        int maxLen = Math.max(l1.size(), l2.size());
        int l1Size = l1.size();
        for(int i = 0; i<maxLen-l1Size; i++){
            l1.add(0);
        }
        int l2Size = l2.size();
        for(int i = 0; i<maxLen-l2Size; i++){
            l2.add(0);
        }

        // 比较
        for (int i = 0; i< maxLen; i++){
            if (l1.get(i) - l2.get(i) > 0) return 1;
            if (l1.get(i) - l2.get(i) < 0) return -1;
        }
        return 0;
    }
    private int StringToInt(String s){
        int ret = 0;
        for(int i = s.length()-1; i >= 0; i--){
            int digit = s.charAt(i) - '0';
            if (digit == 0){
                continue;
            }
            ret = ret + digit * (int) Math.pow(10, s.length()-1-i);
        }
        return ret;
    }
}
