package Crio.DSA_2;

import java.util.*;

class Student {
    int id;
    String name;
    int marks[] = new int[5];

    public Student(int id, String name, int marks[]) {
        this.id = id;
        this.name = name;

        for (int i = 0; i < 5; i++) {
            this.marks[i] = marks[i];
        }
    }
}

class MarksSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student arr[] = new Student[n];

        for (int i = 0; i < n; i++) {

            int id = sc.nextInt();
            String name = sc.next();
            int marks[] = new int[5];

            for (int j = 0; j < 5; j++)
                marks[j] = sc.nextInt();
            arr[i] = new Student(id, name, marks);
        }

        int res[] = marksSort(n, arr);

        for (int j : res) {
            System.out.print(j + " ");
        }
    }

    static int[] marksSort(int n, Student arr[]) {
        Arrays.sort(arr,StudentCompare);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = arr[i].id;
        return ans;
    }

    public static Comparator<Student> StudentCompare = new Comparator<Student>() {
        @Override
        public int compare(Student a, Student b) {
            int sum1=0,sum2=0;
            for(int x : a.marks) sum1+=x;
            for(int y : b.marks) sum2+=y;

            if (sum1 > sum2 ) return -1;
            else if(sum1 < sum2) return 1;
            else if(sum1 == sum2){
                if(!a.name.equals(b.name))    return (a.name).compareTo(b.name); // Comparing entire string 
                else if (a.name.equals(b.name)) return Integer.compare(a.id, b.id);
            }
            return 0;
        }
    };
}
