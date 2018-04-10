package OLD;

public class Line {
	Point a;
	Point b;
	
	public Line(Point a, Point b) {
		this.a = a;
		this.b = b;
	}

	public Point getA() {
		return this.a;
	}
	public Point getB() {
		return this.a;
	}

	public void setA(Point a) {
		this.a = a;
	}	
	public void setB(Point b) {
		this.a = b;
	}
	
	public String toString() {
		return "The first point is " + a.toString() + ", and the second is " + b.toString();
	}

	//Misc. functions
	public double length() {
		return Math.sqrt(Math.pow(a.getY()-b.getY(), 2)+Math.pow(a.getX()-b.getX(), 2));
	}
	
	public boolean isVertical() {
		if(a.getX() == b.getX())
			return true;
		return false;
	}
	public boolean isHorizontal() {
		if(a.getY() == b.getY())
			return true;
		return false;
	}
}
