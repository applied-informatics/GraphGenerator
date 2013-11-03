package generator.misc;

import java.io.Console;
import java.util.Random;

public class GeometricalRandomGraph extends GraphMLGraph {
	
	public class Point {
		private double x;
		private double y;
		
		private Random rand = new Random();
		public Point() {
			this.x = rand.nextDouble();
			this.y = rand.nextDouble();
		}
		
		public String toString() {
			String aa = "(" + x + ", " + y +")";
			return aa;
		}
		
		public double distanceTo(Point p) {
			double distX = this.getX()-p.getX();
			double distY = this.getY()-p.getY();
			return Math.sqrt(distX*distX+distY*distY);
		}

		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}

		public double getY() {
			return y;
		}

		public void setY(double y) {
			this.y = y;
		}
	}
	
	public GeometricalRandomGraph(int n, double p) {
		N = n;
		matrix = new int[N][N];
		Point[] points = new Point[N];
		for (int i=0;i<N;i++) {
			points[i] = new Point();
		}
		for (int i=0; i<N;i++) {
			for (int j=i+1;j<N;j++) {
				double dist = points[i].distanceTo(points[j]);
				if (p-dist>0.000001) {
					matrix[i][j] = 1;
					matrix[j][i] = 1;
				}
			}
		}
	}

}
