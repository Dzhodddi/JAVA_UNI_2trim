package org.example;

class Rectangle {
//  Point (x1, y1) - lower left point, Point(x2, y2) - upper right point
    private int x1, y1, x2, y2;


    Rectangle(int x1, int y1, int x2, int y2) {
//        if (x1 == x2 || y1 == y2)
//            throw new IllegalArgumentException("x or y are the same. Must be different!!");
        if (x1 > x2) {
            int temp = x1;
            x1 = x2;
            x2 = temp;
        }
        if (y1 > y2) {
            int temp = y1;
            y1 = y2;
            y2 = temp;
        }

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public String toString() {
        return "Rectangle with (" + x1 + "," + y1 + "," + x2 + "," + y2 + ") coordinates";
    }


    private void changeX(int dx) {
        x1 = x1 + dx;
        x2 = x2 + dx;
    }
    private void changeY(int dy) {
        y1 = y1 + dy;
        y2 = y2 + dy;
    }

    public void move(int dx, int dy) {
        changeX(dx);
        changeY(dy);
    }

    public boolean checkIfPointInRectangle(int x, int y) {
        if (x >= x1 && x <= x2 && y >= y1 && y <= y2)
            return true;
        return false;
    }

    public void joinOfTwoRectangles(Rectangle r1) {
        if (r1.y1 > y2 || r1.y2 < y1 || r1.x1 > x2 || r1.x2 < x1 ) {
            System.out.println("No joins");
            return;
        }

        if (r1.x1 < x1 && r1.x2 > x2 && r1.y1 < y1 && r1.y2 > y2) {
            System.out.println("No joins");
            return;
        }
        if (r1.x1 > x1 && r1.x2 < x2 && r1.y1 > y1 && r1.y2 < y2) {
            System.out.println("No joins");
            return;
        }

        int x1join = Math.max(r1.x1, x1);
        int y1join = Math.max(r1.y1, y1);
        int x2join = Math.min(r1.x2, x2);
        int y2join = Math.min(r1.y2, y2);

        System.out.println("Rectangle joins with (" + x1join + "," + y1join + "), (" + x2join + "," + y2join + ")");

    }

    public void joinedRectangle(Rectangle r1) {
        int x1join = Math.min(r1.x1, x1);
        int y1join = Math.min(r1.y1, y1);
        int x2join = Math.max(r1.x2, x2);
        int y2join = Math.max(r1.y2, y2);
        System.out.println("Joined rectangle with coordinates: " + "("  + x1join + "," + y1join + ")"  +  "," +  "("  + x2join + "," + y2join + ")");
    }
}


public class Main {
    public static void main(String[] args) {
        while (true) {
            int cont = DataInput.getInt("Input -1 to continue: ");
            if (cont == -1) {
                break;
            }
            int x1 = DataInput.getInt("Input x of left lower point: ");
            int y1 = DataInput.getInt("Input y of left lower point: ");
            int x2 = DataInput.getInt("Input x of right upper point: ");
            int y2 = DataInput.getInt("Input y of right upper point: ");
            Rectangle r1 = new Rectangle(x1, y1, x2, y2);
            while (true) {
                int action = DataInput.getInt("Input action or -1 to stop: ");
                if (action == -1) {
                    break;
                }
                switch (action) {
                    case 1:
                        int dx = DataInput.getInt("Input dx: ");
                        int dy = DataInput.getInt("Input dy: ");
                        r1.move(dx, dy);
                        System.out.println(r1);
                        break;
                    case 2:
                    {
                        int x11 = DataInput.getInt("Input x: ");
                        int y11 = DataInput.getInt("Input y: ");
                        System.out.println("Inside rectangle: " +  r1.checkIfPointInRectangle(x11, y11));
                    }
                    break;
                    case 3:
                    {
                        int x11 = DataInput.getInt("Input x of left lower point: ");
                        int y11 = DataInput.getInt("Input y of left lower point: ");
                        int x21 = DataInput.getInt("Input x of right upper point: ");
                        int y21 = DataInput.getInt("Input y of right upper point: ");
                        r1.joinOfTwoRectangles(new Rectangle(x11, y11, x21, y21));
                    }

                    break;
                    case 4:
                    {
                        int x11 = DataInput.getInt("Input x of left lower point: ");
                        int y11 = DataInput.getInt("Input y of left lower point: ");
                        int x21 = DataInput.getInt("Input x of right upper point: ");
                        int y21 = DataInput.getInt("Input y of right upper point: ");
                        r1.joinedRectangle(new Rectangle(x11, y11, x21, y21));
                    }
                    break;
                    default:
                        System.out.println("Invalid action");
                        break;
            }

            }

        }

    }
}