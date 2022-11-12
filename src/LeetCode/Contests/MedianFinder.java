package LeetCode.Contests;
import java.util.*;
public class MedianFinder {
    public ArrayList<Integer> arr = new ArrayList<Integer>();
    public int sum =0;
    public MedianFinder() {

    }

    public void addNum(int num) {
        sum+=num;
        arr.add(num);
    }

    public double findMedian() {
        double temp = sum;
        double len = arr.size();
        System.out.println(temp/len);
        return  Math.round((temp/len)*100000 / 100000.0);
    }

    public static void main(String[] args){
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
    }
}
