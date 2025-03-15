package org.example;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Point{
	private final double x;
	private final double y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	private double averageDouble(double a, double b) {
		return (a + b) / 2;
	}

	public Point centreBetweenPoints(Point point) {
		return new Point(averageDouble(x, point.x), averageDouble(y, point.y));
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}

class Shape {
	private int edges;
	protected double rightAngel;
	private String name;
	protected double [] angles;
	protected Point[] vertexes;
	Shape(String name, int edges, double [] angles, Point [] vertexes) {
		this.name = name;
		this.edges = edges;
		this.angles = angles;
		this.vertexes = vertexes;
		this.rightAngel = setRightAngel();
	}
	
	private double setRightAngel() {
		if (edges == 0)
			return 360;
		if (edges == 1)
			return 0;
		return sumOfAngles() / edges;
	}

	protected double sumOfAngles() {
		return 180 * (edges - 2);
	}
	
	public boolean isRightShaped() {
		for (int i = 0; i < angles.length; i++) {
			if (angles[i] != rightAngel)
				return false;			
		}
		return true;
	}	

	public void drawFigure() {
		System.out.println("We can not draw a general figure");
	}

	public void centreOfShape() { System.out.print("Can't find exact centre of the shape. " +
			"Will return avg of the first and last points");
		System.out.println(vertexes[0].centreBetweenPoints(vertexes[vertexes.length - 1]));
	}

	public void typeOfShape() {
		System.out.println("Can't outline the figure");
	}

}

class Triangle extends Shape {
	Triangle(double [] angles, Point [] vertexes) {
		super("Triangle", 3, angles, vertexes);

	}

	public void drawShapeFigure() {
		for (int i = 0; i < vertexes.length; i++) {
			System.out.println("Point: "  + vertexes[i]);
		}
	}

	private double averageBetweenThree(double x, double y, double z) {
		return (x + y + z) / 3;
	}

	public void centreOfShape() {
		System.out.print("The centre of triangle: ");
		System.out.println(new Point(averageBetweenThree(vertexes[0].getX(), vertexes[1].getX(), vertexes[2].getX()),
				averageBetweenThree(vertexes[0].getY(), vertexes[1].getY(), vertexes[2].getY())));
	}

	public void typeOfShape() {
		if (angles[0] == 90 || angles[1] == 90 || angles[2] == 90)
			System.out.println("This is right triangle");
		if (this.isRightShaped())
			System.out.println("This is equilateral triangle");
	}

}

class Circle extends Shape {
	double radius;

	Circle(double radius, double [] angles, Point [] vertexes) {
		super("Circle", 0, angles, vertexes);
		this.radius = radius;
	}

	public void drawShapeFigure() {
		System.out.println("Circle with centre: " + vertexes[0] + " and radius: " + radius);
	}

	public void centreOfShape() {
		System.out.print("The centre of circle: ");
		System.out.println(vertexes[0]);
	}


}

class Quadrangle extends Shape {

	Quadrangle(double [] angles, Point [] vertexes) {
		super("Rectangle", 4, angles, vertexes);
	}

	public void drawShapeFigure() {
		for (Point point: vertexes) {
			System.out.println("Point: "  + point);
		}
	}

	public void centreOfShape() {
		System.out.print("The centre of Rectangle: ");
		System.out.println(vertexes[0].centreBetweenPoints(vertexes[3]));
	}

	public void typeOfShape() {
		if (this.isRightShaped())
			System.out.println("This is right quadrangle");
		else
			System.out.println("This is simple quadrangle");
	}
}

class Rectangle extends Quadrangle {

	Rectangle(double [] angles, Point [] vertexes) {
		super(angles, vertexes);
	}

}


public class Main {
	public static void main(String[] args) {
		System.out.println("Create circle: ");
		Circle circle = createCircle();
		circle.drawShapeFigure();
		circle.typeOfShape();
		circle.centreOfShape();

		System.out.println("Create triangle: ");
		Triangle triangle = createTriangle();
		triangle.drawShapeFigure();
		triangle.typeOfShape();
		triangle.centreOfShape();

		System.out.println("Create quadrangle: ");
		Quadrangle quadrangle = createQuadrangle();
		quadrangle.drawShapeFigure();
		quadrangle.typeOfShape();
		quadrangle.centreOfShape();

		System.out.println("Create rectangle: ");
		Rectangle rectangle = createRectangle();
		rectangle.drawShapeFigure();
		rectangle.typeOfShape();
		rectangle.centreOfShape();

	}
	public static Triangle createTriangle() {
		double [] angles = new double[3];
		Point [] vertexes = new Point[3];
		for (int i = 0; i < 3; i++)
			angles[i] = DataInput.getDouble("Input angle: ");
		for (int i = 0; i < 3; i++) {
			double x = DataInput.getDouble("Input x: ");
			double y = DataInput.getDouble("Input y: ");
			vertexes[i] = createPoint(x, y);
		}
		if (!validateTriangle(vertexes, angles)) {
			System.out.println("Invalid triangle");
			return createTriangle();
		}
		return new Triangle(angles, vertexes);
	}

	public static Circle createCircle() {
		Point [] vertexes = new Point[1];
		double radius = DataInput.getDouble("Input radius: ");
		double x = DataInput.getDouble("Input x: ");
		double y = DataInput.getDouble("Input y: ");
		vertexes[0] = createPoint(x, y);
		return new Circle(radius, null, vertexes);
	}

	public static Quadrangle createQuadrangle() {
		double [] angles = new double[4];
		Point [] vertexes = new Point[4];
		for (int i = 0; i < 4; i++)
			angles[i] = DataInput.getDouble("Input angle: ");
		for (int i = 0; i < 4; i++) {
			double x = DataInput.getDouble("Input x: ");
			double y = DataInput.getDouble("Input y: ");
			vertexes[i] = createPoint(x, y);
		}
		if (!validateQuadrangle(vertexes, angles)) {
			System.out.println("Invalid quadrangle");
			return createQuadrangle();
		}
		return new Quadrangle(angles, vertexes);
	}

	public static Rectangle createRectangle() {
		double [] angles = new double[4];
		Point [] vertexes = new Point[4];
		for (int i = 0; i < 4; i++)
			angles[i] = DataInput.getDouble("Input angle: ");
		for (int i = 0; i < 4; i++) {
			double x = DataInput.getDouble("Input x: ");
			double y = DataInput.getDouble("Input y: ");
			vertexes[i] = createPoint(x, y);
		}
		if (!validateRectangle(vertexes, angles)) {
			System.out.println("Invalid rectangle");
			return createRectangle();
		}
		return new Rectangle(angles, vertexes);
	}

	private static Point createPoint(double x, double y) {
		return new Point(x, y);
	}

	private static boolean validateTriangle(Point[] points, double[] angles) {
		if (angles.length != 3)
			return false;
		if (points.length != 3)
			return false;
		if (sumOfAngles(angles) != 180)
			return false;
		return true;
	}

	private static double sumOfAngles(double [] angles) {
		double sum = 0;
		for (double angle: angles)
			sum += angle;
		return sum;
	}

	private	static boolean validateQuadrangle(Point [] points, double [] angles) {
		if (angles.length != 4)
			return false;
		if (points.length != 4)
			return false;
		if (sumOfAngles(angles) != 360)
			return false;
		return true;
	}

	private	static boolean validateRectangle(Point [] points, double [] angles) {
		if (angles.length != 4)
			return false;
		if (points.length != 4)
			return false;
		if (sumOfAngles(angles) != 360)
			return false;
		for (int i = 0; i < 4;i++) {
			if (angles[i] != 90)
				return false;
		}
		return true;
	}




}