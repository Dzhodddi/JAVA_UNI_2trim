import org.example.Parallelepiped;
import org.example.Point;
import org.example.DataInput;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        while (true) {
            int end = DataInput.getInt("Input -1 to stop: ");
            if (end == -1) {
                break;
            }
            int constructor = DataInput.getInt("Input 1 to use constructor with 3 points or 2 to use constructor with 1 point and length of the sides: ");
            if (constructor == 2) {
                double x = DataInput.getDouble("Input x of the point: ");
                double y = DataInput.getDouble("Input y of the point: ");
                double z = DataInput.getDouble("Input z of the point: ");
                Point A = new Point(x, y, z);
                double sideAB = DataInput.getDouble("Input AB: ");
                double sideAD = DataInput.getDouble("Input AD: ");
                double angleBAD = DataInput.getDouble("Input angleBAD: ");
                double sideAA1 = DataInput.getDouble("Input sideAA1: ");
                double angleA1AB = DataInput.getDouble("Input angleA1AB: ");
                Parallelepiped parallelepiped = new Parallelepiped(A, sideAB, sideAD, angleBAD, sideAA1, angleA1AB);
                System.out.println("Area of surface: " + parallelepiped.surfaceArea());
                System.out.println("Height: " + parallelepiped.findHeight());
                System.out.println("Extent: " + parallelepiped.findExtent());
            }
            else {
                double Ax = DataInput.getDouble("Input Ax of the point: ");
                double Ay = DataInput.getDouble("Input Ay of the point: ");
                double Az = DataInput.getDouble("Input Az of the point: ");
                Point A = new Point(Ax, Ay, Az);

                double Bx = DataInput.getDouble("Input Bx of the point: ");
                double By = DataInput.getDouble("Input By of the point: ");
                double Bz = DataInput.getDouble("Input Bz of the point: ");
                Point B = new Point(Bx, By, Bz);

                double Cx = DataInput.getDouble("Input Cx of the point: ");
                double Cy = DataInput.getDouble("Input Cy of the point: ");
                double Cz = DataInput.getDouble("Input Cz of the point: ");
                Point C = new Point(Cx, Cy, Cz);

                double sideAA1 = DataInput.getDouble("Input sideAA1: ");
                double angleA1AB = DataInput.getDouble("Input angleA1AB: ");
                Parallelepiped parallelepiped = new Parallelepiped(A, B, C, sideAA1, angleA1AB);
                System.out.println("Area of surface: " + parallelepiped.surfaceArea());
                System.out.println("Height: " + parallelepiped.findHeight());
                System.out.println("Extent: " + parallelepiped.findExtent());
            }
        }
    }
}
