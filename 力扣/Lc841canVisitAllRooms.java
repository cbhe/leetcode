package 力扣;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc841canVisitAllRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] roomArr = new int[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        roomArr[0] = 1;
        queue.add(0);
        while (!queue.isEmpty()){
            int room = queue.remove();
            for (int key: rooms.get(room)){
                if (roomArr[key] == 0){
                    roomArr[key] = 1;
                    queue.add(key);
                }
            }
        }

        for (int i = 0; i< roomArr.length; i++){
            if (roomArr[i] == 0) return false;
        }
        return true;
    }
}
