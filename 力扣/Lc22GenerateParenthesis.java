package 力扣;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc22GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        return genParenthesis(n, new HashMap<>());
    }

    private List<String> genParenthesis(int n, Map<Integer, List<String>> cache){
        if (cache.containsKey(n)){
            return cache.get(n);
        }

        List<String> ret = new ArrayList<>();
        if (n == 0){
            ret.add("");
        } else {
            for (int i = 0; i<=n-1; i++){
                List<String> partA = genParenthesis(i, cache);
                List<String> partB = genParenthesis(n-1-i, cache);
                for (String a: partA){
                    for (String b: partB){
                        ret.add("("+a+")"+b);
                    }
                }
            }
        }
        cache.put(n,ret);
        return ret;
    }
}
