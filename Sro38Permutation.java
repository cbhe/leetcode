import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sro38Permutation {

    public static void main(String[] args) {

    }
    public String[] permutation(String s) {
        List<Integer> traceLog = new ArrayList<>();
        Set<String> resSet = new HashSet<>();

        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i<s.length(); i++){
            if (charSet.contains(s.charAt(i))) continue;
            charSet.add(s.charAt(i));
            backTrack(s, i, traceLog, resSet);
        }

        return resSet.toArray(new String[0]);
    }
    private void backTrack(String s, int index, List<Integer> traceLog, Set<String> resSet){
        traceLog.add(index);

        // 结束条件
        if (traceLog.size() == s.length()){
            String res = "";
            for (int i: traceLog){
                res += s.charAt(i);
            }
            resSet.add(res);
        }

        // 回溯
        Set<Integer> usedIndexSet = new HashSet<>(traceLog);
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            if (usedIndexSet.contains(i)) continue;
            // 剪枝
            if (charSet.contains(s.charAt(i))) continue;
            charSet.add(s.charAt(i));

            backTrack(s, i, traceLog, resSet);
        }

        traceLog.remove(traceLog.size()-1);
    }
}
