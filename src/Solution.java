
class Solution {
    public static int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        for (int[] t: trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[][] t = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        findJudge(4,t);
    }
}