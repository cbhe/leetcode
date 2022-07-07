package 力扣;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Lc227calculate {

    public static void main(String[] args) {
        String s = " 3/2 ";
        System.out.println(new Lc227calculate().calculate(s));
    }
    public int calculate(String s) {
        s = s.trim();
        List<Object> list = new ArrayList<>();
        // 分隔出数字和运算符
        int left = 0;
        int right = 0;
        while(left < s.length() && right < s.length()){
            for(right = left+1; right < s.length(); right ++){
                char rightChar = s.charAt(right);
                if (rightChar < '0' || rightChar > '9'){
                    int num = strToInt(s.substring(left, right));
                    list.add(num);
                    break;
                }
            }

            if (right >=  s.length()) break;

            for (left = right; left < s.length(); left++){
                char leftChar = s.charAt(left);
                if (leftChar >='0' && leftChar<='9'){
                    break;
                }
                if (leftChar != ' '){
                    list.add(leftChar);
                }
            }
        }
        list.add(strToInt(s.substring(left, right)));

        // 计算乘除
        List<Object> list2 = new ArrayList<>();
        for (int i = 0; i< list.size();i++){
            Object obj = list.get(i);

            if (obj instanceof Character){
                char c = (Character) obj;
                if (c == '*' || c == '/'){
                    int nextNum = (Integer)list.get(++i);
                    if (c == '*') {
                        list2.set(list2.size()-1, (Integer)list2.get(list2.size()-1) * nextNum);
                    } else {
                        list2.set(list2.size()-1, (Integer)list2.get(list2.size()-1) / nextNum);
                    }
                } else {
                    list2.add(c);
                }
            } else {
                list2.add(obj);
            }
        }

        // 计算加减
        int ret = (Integer)list2.get(0);
        for (int i = 1; i< list2.size(); i+=2){
            char c = (Character)list2.get(i);
            if (c == '+'){
                ret += (Integer)list2.get(i+1);
            } else {
                ret -= (Integer)list2.get(i+1);
            }
        }

        return ret;
    }
    private int strToInt(String s){
        int ret = 0;
        for (int i = s.length()-1; i>=0; i--){
            int level = s.length()-1 - i;
            ret += (s.charAt(i) - '0') * (int)Math.pow(10, level);
        }
        return ret;
    }
}
