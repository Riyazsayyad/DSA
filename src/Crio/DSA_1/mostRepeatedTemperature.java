package Crio.DSA_1;

import java.util.*;


public class mostRepeatedTemperature {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        //Scanner sc = new Scanner(System.in);
        int n = 5;

        int a[] = {-10 ,11, 15, 20, 11};

//        for (int i = 0; i < n; i++) {
//            a[i] = Integer.parseInt(sc.next());
//        }

        int ans = mostRepeatedTemperature(n, a);
        System.out.println(ans);
    }

    // TODO: Implement this method
    static int mostRepeatedTemperature(int n, int a[]) {
        Map map =new HashMap();
        int count=0;

        for(int i=0;i<a.length;i++){
            if(!map.containsKey(a[i])) {
                count=1;
                map.put(a[i],count);
            }
            else{
                map.replace(a[i],map.get(a[i]),(int)map.get(a[i])+1);
            }
        }

        int maxVal =(int) Collections.max(map.values());
        int ans=0;
        //System.out.println(map.keySet()+" "+map.values()+" "+maxVal);
        Iterator iter = map.entrySet().iterator();

        while (iter.hasNext()){
            Map.Entry<Integer, Integer> new_Map = (Map.Entry<Integer, Integer>)  iter.next();

            if(new_Map.getValue()==maxVal){
                ans = new_Map.getKey();
            }
        }
        return ans;
    }
}
