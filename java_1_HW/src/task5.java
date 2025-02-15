public class task5 {
    public static void main(String[] args) {
        int rows = DataInput.getNotNegativeInt("rows: ");
        double[][] matrix = DataInput.readDoubleMatrix(rows, rows);
        if (matrix.length == 0 || matrix == null)
            return;
        double sumMin = 0.0;
        double sumMax = 0.0;

        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                sumMin += DataInput.minOfDoubleArray(matrix[i]);
            } else{
                sumMax += DataInput.maxOfDoubleArray(matrix[i]);
            }
        }
        System.out.println("Sum of minimum elements in rows: " + sumMin);
        System.out.println("Sum of maximum elements in rows: " + sumMax);
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = sort(matrix[i]);
        }
        System.out.println("Sorted matrix: ");
        DataInput.printDoubleMatrix(matrix);
    }

    private static double[] sort(double[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    double temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
