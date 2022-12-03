package cuatroenlinea.Model;

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
        System.out.print("\033[H\033[2J");

        for (int y = 0; y <= pointMatrix.length - 4; y++) {
            String diagonal = "";
            for (int x = 0; x < pointMatrix[0].length; x++) {
                if (x + y > 6)
                    continue;
                diagonal += pointMatrix[x + y][x];
            }
            if (diagonal.contains("1111") || diagonal.contains("2222")) {
                return true;
            }
        }

        for (int y = 0; y <= pointMatrix.length - 4; y++) {
            String diagonal = "";
            for (int x = pointMatrix.length - 1; x >= 0; x--) {
                int i = pointMatrix.length - 1 - x;
                if (x - y < 0)
                    continue;
                if (i < 0 || i == 6)
                    continue;
                diagonal += pointMatrix[x - y][i];
            }
            if (diagonal.contains("1111") || diagonal.contains("2222")) {
                return true;
            }
        }

        String diagonal = "";
        for (int i = 0; i < 4; i++) {
            int x = 3 + i;
            int y = 5 - i;
            diagonal += pointMatrix[x][y];
            if (diagonal.contains("1111") || diagonal.contains("2222")) {
                return true;
            }
        }
        diagonal = "";
        for (int i = 0; i < 5; i++) {
            int x = i;
            int y = 1 + i;
            diagonal += pointMatrix[x][y];
            if (diagonal.contains("1111") || diagonal.contains("2222")) {
                return true;
            }
        }
        for (int i = 0; i < 4; i++) {
            int x = i + 1;
            int y = i + 2;
            diagonal += pointMatrix[x][y];
            if (diagonal.contains("1111") || diagonal.contains("2222")) {
                return true;
            }
        }
        diagonal = "";
        for (int i = 0; i < 5; i++) {
            int x = 2 + i;
            int y = 5 - i;
            diagonal += pointMatrix[x][y];
            if (diagonal.contains("1111") || diagonal.contains("2222")) {
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
