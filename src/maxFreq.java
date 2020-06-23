import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class maxFreq {

    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,1,2,3,4,4,4};
        System.out.println(maxFrequence(arr));
    }

    // 4 - 4 times
    // 1 - 2 times
    // 2 - 2 times
    // 3 - 1 time
    // 5 - 1 time
    // 6 - 1 time


    public static List maxFrequence(int[] arr){

        List<Integer> list = new ArrayList<>();

        if(arr.length==0){
            return list;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }


        while(!map.isEmpty()){
            int max = 0;
            int maxFreq = 0;
            for(int j : map.keySet()){
                if(map.get(j)>maxFreq){
                    maxFreq=map.get(j);
                    max = j;
                }
            }

            list.add(max);
            map.remove(max);
        }

        return list;
    }

}
