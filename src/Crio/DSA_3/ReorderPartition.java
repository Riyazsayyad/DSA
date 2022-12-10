package Crio.DSA_3;
import java.io.*;
import java.util.*;
public class ReorderPartition {
    public static ListNode partition( ListNode head , int x) {
        ListNode sH = null, sT = null;
        ListNode eH = null, eT = null;
        ListNode gH = null, gT = null;
        /*
        sH -> small head sT -> small tail
        g -> greater , e -> equal
         */
        while (head != null){
            if (head.val == x){
                if(eH == null){
                    eH = eT = head;
                }else {
                    eT.next = head;
                    eT = eT.next;
                }
            }else if (head.val < x){
                if(sH == null){
                    sH = sT = head;
                }else {
                    sT.next = head;
                    sT = sT.next;
                }
            }else {
                if(gH == null){
                    gH = gT = head;
                }else {
                    gT.next = head;
                    gT = gT.next;
                }
            }
            head = head.next;
        }
        // merging three sub list sH > sT > eH > eT > gH > gT > null
        if(gT != null)  gT.next = null;
        if(sT == null){
            if(eT == null)  return gH;
            eT.next = gH;
            return eH;
        }
        if(eH == null){
            sT.next = gH;
            return sH;
        }

        sT.next =  eH;
        eT.next = gH;
        return sH;
    }
}
