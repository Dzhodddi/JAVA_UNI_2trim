public class MagicSquareMain {
    public static void main(String[] args) {
        int rows = DataInput.getNotNegativeInt("rows: ");
        int cols = DataInput.getNotNegativeInt("cols: ");
        testMagicSquare(DataInput.readDoubleMatrix(rows, cols));
    }

    public static void testMagicSquare(double [][] square) {
        MagicSquare magicSquare = new MagicSquare(square);
        System.out.println(magicSquare.checkMagicSquare());
        DataInput.printDoubleMatrix(magicSquare.matrix);
    }

    /*
    1.0 14.0 15.0 4.0
    12.0 7.0 6.0 9.0
    8.0 11.0 10.0 5.0
    13.0 2.0 3.0 16.0

    4 9 2
    3 5 7
    8 1 6

     */
}
