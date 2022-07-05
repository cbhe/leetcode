import java.util.ArrayList;
import java.util.List;

public class Lc763PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        // 统计每个字母最后出现的位置
        int[] lastPos = new int[26];
        for (int i=s.length()-1; i>=0; i--){
            if (i!=0 && lastPos[s.charAt(i)-'a']==0){
                lastPos[s.charAt(i)-'a'] = i;
            }
        }

        List<Integer> partitionList = new ArrayList<>();
        int left = 0;
        int right = 0;
        while(right<s.length()) {
            for (int i = left; i <= right; i++) {
                if (lastPos[s.charAt(i)-'a'] > right){
                    right = lastPos[s.charAt(i)-'a'];
                }
            }
            partitionList.add(right-left+1);

            right++;
            left = right;
        }

        return partitionList;
    }
}
