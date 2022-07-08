package 力扣;

public class Lc252canAttendMeetings {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <2) return true;
        quickSort(intervals, 0, intervals.length-1);
        for (int i = 0; i<intervals.length-1;i++){
            if (intervals[i][1] > intervals[i+1][0]) return false;
        }
        return true;
    }

    private void quickSort(int[][] intervals, int left, int right){
        if (left >= right){
            return;
        }
        int l = left;
        int r = right;
        int[] base = intervals[l];
        while(l<r){
            while (l<r){
                if ((intervals[r][0] > base[0]) || (intervals[r][0] == base[0] && intervals[r][1] >= base[1])){
                    r--;
                } else {
                    intervals[l] = intervals[r];
                    l++;
                    break;
                }
            }
            while (l<r){
                if (intervals[l][0] < base[0] || (intervals[l][0] == base[0] && intervals[l][1] <= base[1])){
                    l++;
                } else {
                    intervals[r] = intervals[l];
                    r--;
                    break;
                }
            }
        }
        int m = l;
        intervals[m] = base;
        quickSort(intervals, left, m-1);
        quickSort(intervals, m+1, right);
    }
}
