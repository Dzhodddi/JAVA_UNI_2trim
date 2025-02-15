public class MagicSquare {
    public final double [][] matrix;
    public MagicSquare(double[][] matrix) {
        this.matrix = matrix;
    }
    
    public boolean checkMagicSquare() {
        if (this.matrix.length == 0 || this.matrix[0].length == 0 || this.matrix == null) {
            return false;
        }
        if (this.matrix.length != this.matrix[0].length)
            return false;
        double sumInRow = 0;
        double sumInCol = 0;
        double sumInMainDiagonal = 0;
        double sumInNotMainDiagonal = 0;
        for (int i = 0; i < this.matrix.length; i++)
            sumInRow += this.matrix[i][0];

        for (int i = 1; i < this.matrix.length; i++) {
            double sum = 0.0;
            for (int j = 0; j < this.matrix[0].length; j++) {
                sum += this.matrix[i][j];
            }
            if (sum != sumInRow)
                return false;
        }


        for (int i = 0; i < this.matrix[0].length; i++)
            sumInCol += this.matrix[0][i];

        for (int i = 1; i < this.matrix[0].length; i++) {
            double sum = 0.0;
            for (int j = 0; j < this.matrix.length; j++) {
                sum += this.matrix[j][i];
            }
            if (sum != sumInCol)
                return false;
        }

        for (int i = 0; i < this.matrix.length; i++) {
            sumInMainDiagonal += this.matrix[i][i];
        }

        for (int i = 0; i < this.matrix.length; i++) {
            sumInNotMainDiagonal += this.matrix[i][this.matrix.length - 1 - i];
        }

        return sumInMainDiagonal == sumInNotMainDiagonal;
    }

}

