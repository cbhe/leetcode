import java.util.ArrayList;
import java.util.List;

public class Lc253MinMeetingRooms {

    public static void main(String[] args) {

        Lc253MinMeetingRooms obj = new Lc253MinMeetingRooms();
        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(obj.minMeetingRooms(intervals));
    }

    public int minMeetingRooms(int[][] intervals) {
        quickSort(intervals, 0, intervals.length-1);
        List<List<int[]>> roomList = new ArrayList<>();

        // 给每个 interval 寻找会议室
        for (int[] interval: intervals){
            boolean findOneRoom = false;
            // 搜索所有会议室, 查看会议安排
            for (List<int[]> room: roomList){
                int[] lastMeeting = room.get(room.size()-1);
                // 如果该会议室最后一次会议的结束时间早于 interval 开始时间,则 interval 可安排在该会议室
                if (lastMeeting[1] <= interval[0]){
                    // 找到了会议室
                    findOneRoom = true;
                    room.add(interval);
                    break;
                }
            }
            if (!findOneRoom){
                // 没找到会议室, 申请新会议室
                List<int[]> room = new ArrayList<>();
                room.add(interval);
                roomList.add(room);
            }
        }

        return roomList.size();
    }

    // 按照第一个元素升序排列, 第一个元素相等时按照第二个元素升序排列
    private void quickSort(int[][] intervals, int left, int right){

        if (left >= right){
            return;
        }

        int[] standard = intervals[left];
        int l = left;
        int r = right;
        while(l < r){
            while ((l < r) && lessThanOrEquals(standard, intervals[r])){
                r--;
            }
            intervals[l] = intervals[r];

            while ((l<r) && lessThanOrEquals(intervals[l], standard)){
                l++;
            }
            intervals[r] = intervals[l];
        }

        intervals[l] = standard;

        quickSort(intervals, left, l-1);
        quickSort(intervals,l+1, right);
    }

    private boolean lessThanOrEquals(int[] a1, int[] a2){
        // a1的第一个元素小于a2的第一个元素,或者第一个元素相等但a1 第二个元素小于等于 a2 的第二个元素
        return (a1[0] < a2[0])
                || (a1[0] == a2[0] && a1[1] <= a2[1]);
    }
}
