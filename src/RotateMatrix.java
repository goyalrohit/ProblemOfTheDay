//Left Rotate Matrix K times
//You are given an integer k and matrix mat. Return a matrix where it is rotated Left k times.
//Examples:
//Input: k=1, mat=[[1,2,3],[4,5,6],[7,8,9]]
//Output:
//1 2 3
//4 5 6
//7 8 9
//Explanation: Rotate the matrix by one
//1 2 3       2 3 1
//4 5 6  =>   5 6 4
//7 8 9       8 9 7

public class RotateMatrix {
    int[][] rotateMatrix(int k, int mat[][]) {
        // code here
        int n=mat.length,m=mat[0].length;
        k%=m;
        if(k==0)
            return mat;
        for(int row=0;row<n;row++){
            reverseArray(mat[row],0,m-1);
            reverseArray(mat[row],0,m-k-1);
            reverseArray(mat[row],m-k,m-1);
        }
        return mat;
    }
    void reverseArray(int[] arr,int i,int j){
        i--;
        j++;
        while(++i<--j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        RotateMatrix obj = new RotateMatrix();
        int[][] result = obj.rotateMatrix(k, mat);
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
}
}
