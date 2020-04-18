import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Point {
	
	private float x, y, z;

	public Point(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z +")";
	}

	public void Translate(Point translation) {
		x+=translation.x;
		y+=translation.y;
		z+=translation.z;
	}
}

abstract class Polygon {
	abstract float CalculateArea();
}

class Triangle extends Polygon {
	
	private Point p1, p2, p3;

	public Triangle(Point p1, Point p2, Point p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	@Override
	public String toString() {
		return "This is a triangle, with area: " + CalculateArea();
	}

	@Override
	public float CalculateArea() {
		return 0.0f;
	}
}

class Quad extends Polygon {
	
	private Point p1, p2, p3, p4;

	public Quad(Point p1, Point p2, Point p3, Point p4) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
	}

	@Override
	public String toString() {
		return "This is a quad, with area: " + CalculateArea();
	}	

	@Override
	public float CalculateArea() {
		return 0.0f;
	}
}

public class Polygons {
	// Triangle example: 3.14,8.51,-2.35:4.31,-2.31,-1.0:4.0,3.0,-2.0
	// We will assume correct input
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		List<Polygon> listOfPolys = new ArrayList<Polygon>();
		while(!s.isEmpty()) {
			String[] stringPoints = s.split(":");
			Point[] points = new Point[stringPoints.length];
			for(int i = 0; i < points.length; ++i) {
				for(String stringPoint : stringPoints) {
					// we can assume three components
					String[] coords = stringPoint.split(",");
					float x = Float.parseFloat(coords[0]);
					float y = Float.parseFloat(coords[1]);
					float z = Float.parseFloat(coords[2]);
					points[i] = new Point(x, y, z);
				}
			}
			Polygon newPoly = null;
			if(points.length == 3) {
				newPoly = new Triangle(points[0], points[1], points[2]);
			}
			else if(points.length == 4) {
				newPoly = new Quad(points[0], points[1], points[2], points[3]);
			}
			listOfPolys.add(newPoly);
			s = in.nextLine();
		}
		printListOfPolys(listOfPolys);	
	}

	public static void printListOfPolys(List<Polygon> list) {
		System.out.println("These are the polys in the list:");
		for(Polygon p : list) {
			System.out.println("   " + p.toString());
		}
	}
	
}
