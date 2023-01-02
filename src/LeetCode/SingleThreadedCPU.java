package LeetCode;

import javafx.util.Pair;

import java.util.*;

public class SingleThreadedCPU {

    public static int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        ArrayList<int[]> sortedArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //start time,processing time,index
            int[] temp = {tasks[i][0],tasks[i][1],i};
            sortedArr.add(temp);
        }
        sortedArr.sort(Comparator.comparingInt(a -> a[0]));
        long currtime = 0;
        int index = 0,ansIndex = 0;
        var ans = new int[n];
        // <Processing time,Index>
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getpTime).thenComparingInt(Pair::getIndex));

        while (index < n || !pq.isEmpty()){
            if(pq.isEmpty() && currtime < sortedArr.get(index)[0])  currtime = sortedArr.get(index)[0];

            while (index < n && sortedArr.get(index)[0] <= currtime){
                pq.add(new Pair(sortedArr.get(index)[1],sortedArr.get(index)[2]));
                index++;
            }

            Pair curr_task = pq.poll();
            currtime += curr_task.pTime;
            ans[ansIndex++] = curr_task.index;

        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] tasks = {{1,2},{2,4},{3,2},{4,1}};
        var ans = getOrder(tasks);
        for(int a: ans) System.out.print(a+" ");
    }
    public static class Pair{
        int index, pTime;
        public Pair(int pTime,int index){
            this.index = index;
            this.pTime = pTime;
        }
        public int getIndex(){
            return index;
        }

        public int getpTime() {
            return pTime;
        }
    }
}

    /*
    {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>((x,y)-> x.enqueueTime-y.enqueueTime), availableQueue = new PriorityQueue<>((x,y)->x.processingTime!=y.processingTime ? x.processingTime-y.processingTime : x.index-y.index);
        int[] result = new int[tasks.length];
        for(int i=0;i<tasks.length;i++) taskQueue.offer(new Task(i, tasks[i][0], tasks[i][1]));
        int index=0, currentTime = taskQueue.peek().enqueueTime;
        while(!taskQueue.isEmpty() || !availableQueue.isEmpty()) {
            while(!taskQueue.isEmpty() && taskQueue.peek().enqueueTime <= currentTime)
                availableQueue.offer(taskQueue.poll());
            if(!availableQueue.isEmpty()) {
                currentTime = currentTime + availableQueue.peek().processingTime;
                result[index++] = availableQueue.poll().index;
            } else currentTime = taskQueue.peek().enqueueTime;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] tasks = {{1,2},{2,4},{3,2},{4,1}};
    }

}

class Task {
    int index, enqueueTime, processingTime;

    public Task(int index, int enqueueTime, int processingTime) {
        this.index = index;
        this.enqueueTime = enqueueTime;
        this.processingTime = processingTime;
    }
}

     */