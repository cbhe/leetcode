package 力扣;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Lc207canFinish {

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1,4},{2,4},{3,1},{3,2}};
        int numCourses = 5;
        System.out.println(new Lc207canFinish().canFinish(numCourses, prerequisites));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1 || prerequisites.length<=1){
            return true;
        }

        List<HashSet<Integer>> graph = new ArrayList<>();
        for (int i = 0; i<numCourses; i++){
            graph.add(new HashSet<>());
        }

        List<Integer> rootCourseList = new ArrayList<>();
        for (int i = 0; i<numCourses; i++){
            rootCourseList.add(i);
        }

        for (int[] req: prerequisites){
            if (req[0] == req[1]) return false;
            graph.get(req[0]).add(req[1]);
            rootCourseList.remove(Integer.valueOf(req[1])); // remove value not index
        }

        if (rootCourseList.size() <= 0){
            return false;
        }

        int[] dagLog = new int[numCourses];
        for (int rootCourse: rootCourseList){
            dagLog[rootCourse] = 1;
            Set<Integer> traceLog = new HashSet<>();
            traceLog.add(rootCourse);
            if (hasLoop(graph, rootCourse, traceLog, dagLog)){
                return false;
            }
            traceLog.remove(rootCourse);
        }

        for (int i = 0; i<numCourses; i++){
            if (dagLog[i] != 1){
                return false;
            }
        }
        return true;
    }

    private boolean hasLoop(List<HashSet<Integer>> graph, int index, Set<Integer> traceLog, int[] dagLog){

        if (graph.get(index).size() == 0) return false;
        for (int visited: traceLog){
            if (graph.get(index).contains(visited)){
                return true;
            }
        }

        for (int next: graph.get(index)){
            traceLog.add(next);
            dagLog[next] = 1;
            boolean b = hasLoop(graph, next, traceLog, dagLog);
            if (b) return true;
            traceLog.remove(next);
        }
        return false;
    }

    private boolean bfs(int numCourses, int[][] prerequisites){
        List<int[]> prereqList = new LinkedList<>();
        Collections.addAll(prereqList, prerequisites);

        Set<Integer> todo = new HashSet<>();
        do{

        }while (todo.size() != 0);
        return false;
    }
}
