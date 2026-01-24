package binarysearch;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {50, 60, 70, 80},
                {90, 91, 92, 93},
                {94, 95, 96, 97}
        };
        System.out.println(Arrays.toString(findRange(matrix, 92)));
    }

    static int[] binarySearch(int[][] matrix, int row, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(matrix[row][mid] == target)
                return new int[]{row, mid};
            if(matrix[row][mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return new int[]{-1, -1};
    }

    static int[] findRange(int[][] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length; //be cautious, matrix may be empty

        if(rows == 1)
            return binarySearch(matrix, 0, 0, cols - 1, target);

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

        //run the loop till 2 rows are remaining
        while(rStart < (rEnd - 1)){
            int mid = rStart + (rEnd - rStart) / 2;
            if(matrix[mid][cMid] == target)
                return new int[]{mid, cMid};
            if(matrix[mid][cMid] < target)
                rStart = mid;
            else
                rEnd = mid;
        }

        //now, we have two rows
        //check whether the target lies in the col of 2 rows
        if(matrix[rStart][cMid] == target)
            return new int[]{rStart, cMid};

        if(matrix[rStart + 1][cMid] == target)
            return new int[]{rStart + 1, cMid};

        //if not, search in these four sections
        if(target <= matrix[rStart][cMid - 1])
            return binarySearch(matrix, rStart, 0, cMid - 1, target);

        if(target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1])
            return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);

        if(target <= matrix[rStart + 1][cMid - 1])
            return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);

        else
            return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target);
    }
}
