package org.example;


public class Parallelepiped {
	private Point A;
	private Point B;
	private Point D;
	private double sideAA1;
	private double sideAB;
	private double sideAD;
	private double angleA1AB;
	private double angleBAD;
	public Parallelepiped(Point A, Point B, Point D, double sideAA1, double angleA1AB) {
		this.A = A;
		this.B = B;
		this.D = D;
		this.sideAA1 = sideAA1;
		this.angleA1AB = Math.toRadians(angleA1AB);
		this.sideAB = A.lengthBetweenPoints(B);
		this.sideAD = A.lengthBetweenPoints(D);
		this.angleBAD = findAngleBAD();
	}

	public Parallelepiped(Point A, double sideAB, double sideAD,  double angleBAD, double sideAA1,double angleA1AB) {
		this.A = A;
		this.sideAB = sideAB;
		this.sideAD = sideAD;
		this.angleBAD = Math.toRadians(angleBAD);
		this.sideAA1 = sideAA1;
		this.angleA1AB = Math.toRadians(angleA1AB);
	}

	private double findDiagonal() {
		return B.lengthBetweenPoints(D);
	}

	private double findAngleBAD() {
		double sideBD =  findDiagonal();
		double halfPerimeter =  (sideAB + sideAD + sideBD) / 2;
		double areaOfTriangle =  Math.sqrt(halfPerimeter * (halfPerimeter - sideAB) * (halfPerimeter - sideAD) * (halfPerimeter - sideBD));
		return Math.asin(2 * areaOfTriangle / (sideAD * sideAB));
	}

	public double surfaceArea() {
		return sideAB * sideAD * Math.sin(angleBAD);
	}

	public double findHeight() {
		return sideAA1 * Math.cos(angleA1AB);
	}

	public double findExtent() {
        return findHeight() * surfaceArea();
	}

}
