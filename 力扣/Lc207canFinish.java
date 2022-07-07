package 力扣;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lc207canFinish {

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1,4},{2,4},{3,1},{3,2}};
        int numCourses = 5;
        System.out.println(new Lc207canFinish().canFinish(numCourses, prerequisites));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<int[]> reqList = new ArrayList<>();
        Collections.addAll(reqList, prerequisites);

        while (reqList.size() > 0){

            Set<Integer> outSet = new HashSet<>();
            // 计算出度
            for (int[] req: reqList){
                int x = req[0];
                outSet.add(x);
            }

            // 寻找出度为 0 的课程
            Set<Integer> out0set = new HashSet<>();
            for (int[] req: reqList){
                int y = req[1];
                if (!outSet.contains(y)) out0set.add(y);
            }

            // 存在依赖关系,但没有出度为 0 的课程了: 有循环依赖,返回 false
            if (out0set.size() == 0) return false;

            // 从依赖关系中删除掉出度为 0 的依赖项
            for (int i = reqList.size()-1; i>=0;i--){
                int[] req = reqList.get(i);
                if (out0set.contains(req[1])){
                    reqList.remove(i);
                }
            }
        }

        return true;
    }
}
