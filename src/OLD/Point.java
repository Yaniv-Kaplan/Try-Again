package OLD;

public class Point {
	
	double x;
	double y;
	
	public Point (double x, double y) {
		this.x  = x;
		this.y = y;
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
	
	public String toString() {
		return "X= " + x + "Y= " + y;
	}
	
	public double distance(Point b) {
		return Math.sqrt(Math.pow(this.getY()-b.getY(), 2)+Math.pow(this.getX()-b.getX(), 2));
	}
}
