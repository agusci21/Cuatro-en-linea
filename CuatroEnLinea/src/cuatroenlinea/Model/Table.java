package cuatroenlinea.Model;

import static java.lang.Math.min;
import static java.lang.Math.max;

public class Table {
    int[][] pointMatrix;

    public void restartPointMatrix() {
        pointMatrix = new int[7][6];
        for (int i = 0; i < pointMatrix.length; i++) {
            for (int j = 0; j < pointMatrix[0].length; j++) {
                pointMatrix[i][j] = 0;
            }
        }
    }

    public int getFirstEmptyPanel(int index) {
        int[] list = pointMatrix[index];
        for (int i = 5; i >= 0; i--) {
            if (list[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public void setValueAt(int value, int x, int y) {
        pointMatrix[x][y] = value;
    }

    public boolean veryficateWinner() {
        return verticalVerification() || horizontalVerification() || veryfyDiagonals();
    }

    private boolean verticalVerification() {
        boolean winner = false;
        for (int i = 0; i < 7; i++) {
            String pattenBuild = "";
            int[] line = pointMatrix[i];
            for (int j = 0; j < line.length; j++) {
                pattenBuild += "" + line[j];
            }
            if (pattenBuild.contains("1111") || pattenBuild.contains("2222")) {
                winner = true;
            }
        }
        return winner;
    }

    private boolean horizontalVerification() {
        boolean winner = false;
        int[][] matrixCpy = transposeMatrix(pointMatrix);

        for (int i = 0; i < matrixCpy.length; i++) {
            String pattenBuild = "";
            int[] line = matrixCpy[i];
            for (int j = 0; j < line.length; j++) {
                pattenBuild += "" + line[j];
            }
            if (pattenBuild.contains("1111") || pattenBuild.contains("2222")) {
                winner = true;
            }
        }

        return winner;
    }

    private boolean veryfyDiagonals() {

        int[][] aux = pointMatrix.clone();

        int w = aux[0].length;
        int h = aux.length;
        String diagonal;
        for (int i = 1 - w; i < h; i++){
            diagonal = "";
            for (int x = -min(0, i), y = max(0, i); x < w && y < h; x++, y++){
                diagonal += aux[y][x];
            }
            if(diagonal.contains("1111") || diagonal.contains("2222")){
                return true;
            }
        }

        aux = transposeMatrix(aux);

        for (int i = 1 - w; i < h; i++){
            diagonal = "";
            for (int x = -min(0, i), y = max(0, i); x < w && y < h; x++, y++){
                diagonal += aux[x][y];
            }
            if(diagonal.contains("1111") || diagonal.contains("2222")){
                return true;
            }
        }
        
        return false;
    }

    private static int[][] transposeMatrix(int[][] matrix) {
        int[][] transposed = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

}
