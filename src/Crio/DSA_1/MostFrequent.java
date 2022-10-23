package Crio.DSA_1;
import java.util.*;
public class MostFrequent {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {

        String s = "A cat with rabiesretardsa dudefor no apparent reason.";
        //Statements are unique.
        //A cat with rabiesretardsa dudefor no apparent reason.


        Object[] ans = mostFrequent(s);
        System.out.println(ans[0] + " " + ans[1]);
    }

    // TODO: Implement this method
    static Object[] mostFrequent(String s) {
        //DS Initializations
        Map map =new HashMap();
        ArrayList<Character> maxCh = new ArrayList<>();
        Object[] ret = new Object[2];
        int count=0;

        for(int i=0;i<s.length();i++){
            if(!map.containsKey((s.charAt(i)))){
                count=1;
                map.put(s.charAt(i),count);
            }
            else{
                map.replace(s.charAt(i),map.get(s.charAt(i)),(int)map.get(s.charAt(i))+1);
            }
        }

        int maxVal = (int) Collections.max(map.values());
        Iterator iter = map.entrySet().iterator();

        while(iter.hasNext())
        {
            Map.Entry<Character, Integer> new_Map = (Map.Entry<Character, Integer>)  iter.next();
            if(new_Map.getValue()==maxVal)
            {
                //System.out.println(new_Map.getValue());
                maxCh.add(new_Map.getKey());
            }
        }
        //System.out.println(maxCh);
        char min = Collections.min(maxCh);
        ret[0] = min;
        ret[1] = maxVal;
        return ret;
        //System.out.println(maxVal+" "+min);
        //System.out.println(map.keySet()+" "+ map.values());


//        Iterator iter = map.entrySet().iterator();
//        Map.Entry<Character, Integer> new1_Map = (Map.Entry<Character, Integer>)  iter.next();
//        char First=new1_Map.getKey();
//        int maxVal = (int) Collections.max(map.values());
//        ret[1]=maxVal;
//
//
//
//        char Sec=0;
//        while(iter.hasNext()){
//            Map.Entry<Character, Integer> new_Map = (Map.Entry<Character, Integer>)  iter.next();
//            if(new_Map.getValue()==maxVal)
//                System.out.println(new_Map.getValue());
//                Sec=new_Map.getKey();
//        }
//        System.out.println(map.keySet()+" "+map.values()+" "+map.get(First)+" "+map.get(Sec)+" "+First+" "+Sec);
//        if ((int)(map.get(First))==(int)(map.get(Sec))) {
//            System.out.println(Sec+" "+(map.get(First))+" "+(map.get(Sec)));
//            if (First - '0' > Sec - '0')
//                ret[0] = Sec;
//            ret[0] = First;
//        }
//        else
//            if ((int)map.get(Sec)==(int)maxVal)
//                ret[0]=Sec;
//            else
//                ret[0]=First;


    }
}
