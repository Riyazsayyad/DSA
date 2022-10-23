package CoursePractice.Arrays;
import java.util.Arrays;

public class Start {
    public static void main(String [] args){
        //How to create Array?
        int[] arr;
        arr = new int[]{1,2,3};
        System.out.println(Arrays.toString(arr));
        String sArray[]={"A","B","C"};
        System.out.println(Arrays.toString(sArray));
        //Insertion in Array?
        sArray[2] = "F";
        System.out.println(Arrays.toString(sArray));
        Start s = new Start();
        s.Sda(5);
        s.insert(0,5);
        System.out.println(s.Search(1));
        System.out.println(s.Search(69));
 }
    //Single Dimension Array
    int arr[] = null;
    public void Sda(int Size){
        arr = new int[Size];
        for(int i=0;i<Size;i++)
            arr[i] = Integer.MIN_VALUE;

    }
    public void insert(int location,int valuetobeInserted){
        try {
            if(arr[location]==Integer.MIN_VALUE){
                arr[location] = valuetobeInserted;
                System.out.println("Successfully Inserted");
            }else
                System.out.println("Already Occupied");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Index to access array");
        }

        //Traversing of Array
        int b[]={1,23,345,545646,4,56446,46,4,23};
        for (int i =0;i<b.length;i++)
            System.out.print(b[i] + " ");

    }

    //Searching in Array
    public String Search(int valueToSearch){
        int b[]={1,23,345,545646,4,56446,46,4,23};
        for (int i =0;i<b.length;i++){
            if (b[i] == valueToSearch)
                    return ("Value found at "+i+" index");
        }
        return "Value not present in Array";

    }

    //Two Dimensional Array



}
