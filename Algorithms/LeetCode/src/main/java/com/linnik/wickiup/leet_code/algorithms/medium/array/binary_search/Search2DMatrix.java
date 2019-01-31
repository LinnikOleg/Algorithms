package com.linnik.wickiup.leet_code.algorithms.medium.array.binary_search;

/**
 * @author LinnykOleh
 */
public class Search2DMatrix {

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     *
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     * For example,
     *
     * Consider the following matrix:
     *
     *   [
     *     [1,   3,  5,  7],
     *     [10, 11, 16, 20],
     *     [23, 30, 34, 50]
     *   ]
     * Given target = 3, return true.
     *
     * @param matrix given matrix
     * @param target target to find
     * @return        is exist target in matrix
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length > 0 && matrix[0].length > 0) {
            int rowIndex = findRow(matrix, target);
            if (rowIndex != -1) {
                return findTarget(matrix[rowIndex], target);
            }
        }
        return false;
    }

    private boolean findTarget(int[] array, int target){
        int left = 0;
        int right = array.length - 1;
        int mid;

        while(left <= right){
            mid = left + ((right - left) / 2);
            int midValue = array[mid];
            if(midValue == target){
                return true;
            }
            if(midValue > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }

    private int findRow(int[][] matrix, int target){
        int left = 0;
        int right = matrix.length - 1;
        int mid;

        while(left <= right){
            mid = left + ((right - left) / 2);
            int midRowFirstValue = matrix[mid][0];
            if(midRowFirstValue <= target){
                if(midRowFirstValue < target && matrix[mid].length == 1){
                    left = mid + 1;
                    continue;
                }
                return mid;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Search2DMatrix().searchMatrix(
                new int[][]{
                        new int[]{ 1, 3, 5, 7},
                        new int[]{10,11,16,20},
                        new int[]{23,30,34,50}},
                3));

        System.out.println(new Search2DMatrix().searchMatrix(
                new int[][]{
                        new int[]{1}},
                1));

        System.out.println(new Search2DMatrix().searchMatrix(
                new int[][]{
                        new int[]{}},
                1));

        System.out.println(new Search2DMatrix().searchMatrix(
                new int[][]{
                        new int[]{1}},
                0));

        System.out.println(new Search2DMatrix().searchMatrix(
                new int[][]{
                        new int[]{1,1}},
                0));

        System.out.println(new Search2DMatrix().searchMatrix(
                new int[][]{
                        new int[]{1},
                        new int[]{3}},
                3));

        System.out.println(new Search2DMatrix().searchMatrix(
                new int[][]{
                        new int[]{1, 3, 5}},
                1));

        System.out.println(new Search2DMatrix().searchMatrix(
                new int[][]{
                        new int[]{1, 1}},
                2));

        System.out.println(new Search2DMatrix().searchMatrix(
                new int[][]{
                        new int[]{1, 1},
                        new int[]{2, 2}},
                2));
    }
}

class Search2DMatrix_Best {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length > 0 && matrix[0].length > 0) {
            int row = 0;
            int column = matrix[0].length - 1;

            while (row < matrix.length && column >= 0) {
                if (matrix[row][column] == target) {
                    return true;
                } else if (matrix[row][column] > target) {
                    column--;
                } else {
                    row++;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Search2DMatrix_Best().searchMatrix(
                new int[][]{
                        new int[]{ 1, 3, 5, 7},
                        new int[]{10,11,16,20},
                        new int[]{23,30,34,50}},
                34));

        System.out.println(new Search2DMatrix_Best().searchMatrix(
                new int[][]{
                        new int[]{1}},
                1));

        System.out.println(new Search2DMatrix_Best().searchMatrix(
                new int[][]{
                        new int[]{}},
                1));

        System.out.println(new Search2DMatrix_Best().searchMatrix(
                new int[][]{
                        new int[]{1}},
                0));

        System.out.println(new Search2DMatrix_Best().searchMatrix(
                new int[][]{
                        new int[]{1,1}},
                0));

        System.out.println(new Search2DMatrix_Best().searchMatrix(
                new int[][]{
                        new int[]{1},
                        new int[]{3}},
                3));

        System.out.println(new Search2DMatrix_Best().searchMatrix(
                new int[][]{
                        new int[]{1, 3, 5}},
                1));

        System.out.println(new Search2DMatrix_Best().searchMatrix(
                new int[][]{
                        new int[]{1, 1}},
                2));

        System.out.println(new Search2DMatrix_Best().searchMatrix(
                new int[][]{
                        new int[]{1, 1},
                        new int[]{2, 2}},
                2));
    }

}
