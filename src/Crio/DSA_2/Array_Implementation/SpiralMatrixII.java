package Crio.DSA_2.Array_Implementation;

public class SpiralMatrixII {
    public static void main(String args[]) {
        //Scanner sc = new Scanner(System.in);
        int n = 5;
        int result[][] = spiralMatrixII(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] spiralMatrixII(int n) {
        //Var Initialization
        int [] [] matA = new int [n] [n];
        int L = 0;
        int D = n-1;
        int R = n-1;
        int U = 0;
        int count =1;

        //Code
        while (U<D){
            //System.out.println(D+" "+L+" "+U+" "+R);

            // ---> for left
            for(int i = L;i<D+1;i++){
                matA[L][i] = count;
                ++count;
            }L++;

            // v for down
            for(int j = L;j<D+1;j++){
                matA[j][D] =count;
                ++count;
            }R--;

            //<--- for right
            for(int k = R;k>=U;k--){
                matA[D][k] = count;
                ++count;
            }D--;

            //^ for up
            for(int l = D;l>U;l--){
                matA[l][U]=count;
                ++count;
            }U++;
        }
        if(U==D)
            matA[U][D] = count;

        return matA;
    }
}
