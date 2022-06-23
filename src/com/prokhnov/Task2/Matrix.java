package com.prokhnov.Task2;

public class Matrix {
    private final int[][] matrix;

    public Matrix(int size) {
        this.matrix = new int[size][size];
    }

    public void setWeightOfWay(int a, int b, int weight) {
        matrix[a][b-1] = weight;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
