package Crio.DSA_1.Simple_DS;

import java.util.PriorityQueue;
import java.util.Queue;

// Java implementation of the approach
@SuppressWarnings("ALL")
class GFG
{

    // Representation of node
    static class Node
    {
        int data;
        Node next;
    };


    // Function to insert a node at the beginning
    static Node insert(Node head, int item)
    {
        Node temp = new Node();
        temp.data = item;
        temp.next = head;
        head = temp;
        return head;
    }

    // Function to count the number of
// duplicate nodes in the linked list
    static int countNode(Node head)
    {
        int count = 0;

        while (head.next != null)
        {

            // Starting from the next node
            Node ptr = head.next;
            while (ptr != null)
            {

                // If some duplicate node is found
                if (head.data == ptr.data)
                {
                    count++;
                    break;
                }
                ptr = ptr.next;
            }

            head = head.next;
        }

        // Return the count of duplicate nodes
        return count;
    }

    // Driver code
    public static void main(String args[])
    {
        Node head = null;
        head = insert(head, 5);
        head = insert(head, 7);
        head = insert(head, 5);
        head = insert(head, 1);
        head = insert(head, 7);

        System.out.println( countNode(head));
    }
    Queue<Integer> pQ = new PriorityQueue<>();
    public void insert(int element) {

        pQ.add(element);
    }

    public int getFirst() {
        return pQ.peek();
    }
}

// This code is contributed by Arnab Kundu
