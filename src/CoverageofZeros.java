//Given a binary matrix contains 0s and 1s only, we need to find the sum of coverage of all zeros of the matrix where coverage for a particular 0 is defined as a total number of ones around a zero in left, right, up and bottom directions.

//Examples:
//Input:
//matrix = [[0, 1, 0],
//        [0, 1, 1],
//        [0, 0, 0]]
//Output: 6
//Explanation: There are a total of 6 coverage are there


public class CoverageofZeros {
    public int findCoverage(int[][] matrix) {
        // code here
        int row  = matrix.length;
        int col = matrix[0].length;
        int count = 0;
        int left = 0, right = 0, up = 0, buttom = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 1){

                 /*
                 // First Logic

                    if(j > 0 &&  matrix[i][j-1] == 0){
                        count++;
                    }
                    if(j < col - 1 && matrix[i][j+1] == 0){
                        count++;
                    }

                    if(i > 0 &&  matrix[i-1][j] == 0){
                        count++;
                    }
                    if(i < row - 1 && matrix[i+1][j] == 0){
                        count++;
                    }
            */

                    // Secound Logic

            /*
                 left += j > 0 &&  matrix[i][j-1] == 0 ? 1 : 0;
                 right += j < col - 1 &&  matrix[i][j+1] == 0 ? 1 : 0;
                 up  += i > 0 &&  matrix[i-1][j] == 0 ? 1 : 0;
                 buttom += i < row-1 && matrix[i+1][j] == 0 ? 1 : 0;

            */

                    // Third Logic

                    left = j > 0 &&  matrix[i][j-1] == 0 ? count++ : 0;
                    right = j < col - 1 &&  matrix[i][j+1] == 0 ? count++ : 0;
                    up  = i > 0 &&  matrix[i-1][j] == 0 ? count++ : 0;
                    buttom = i < row-1 && matrix[i+1][j] == 0 ? count++ : 0;


                }

                //  count = left + right + up + buttom;
            }
        }
        return count;

    }
}
