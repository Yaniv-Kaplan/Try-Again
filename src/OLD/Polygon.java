package OLD;

import java.util.*;
public class Polygon {
	public static Scanner reader = new Scanner(System.in);
	
	Point[] vertices;
	int numOfVertices;
	public static int sexyTime = 69;
	
	
	public Polygon (int numOfVertices) {
		this.numOfVertices = numOfVertices;
		
		Point[] vertices = new Point[numOfVertices];
		for(int i=0; i < numOfVertices; i++) {
			System.out.println("Please input X of Vertex");
			int x = reader.nextInt();

			System.out.println("Please input Y of Vertex");
			int y = reader.nextInt();
			
			Point p = new Point(x,y);
			vertices[i] = p;
		}
		this.vertices = vertices;
	}
	
	public Polygon (Point[] vertices) {
		this.vertices = vertices;
	}
	
	
	public Point[] getVerticesArray() {
		return this.vertices;
	}
	public int getNumOfVertices() {
		return this.numOfVertices;
	}

	public void add(Point vertex) {
		Point[] vertices = new Point[this.vertices.length + 1];
		for(int i = 0; i < this.vertices.length; i++) {
			vertices[i] = this.vertices[i];
		}
		vertices[vertices.length-1] = vertex;
		
		this.vertices = vertices;
		this.numOfVertices += 1;
	}

	public double shortest() {
		double shortest = this.vertices[0].distance(this.vertices[this.vertices.length-1]); //shortest will be bigger than 0
		for(int i=0; i < this.vertices.length-1; i++) {
			if(this.vertices[i].distance(this.vertices[i+1]) <= shortest) {
				shortest = this.vertices[i].distance(this.vertices[i+1]);
			}
		}
		return shortest;
	}

	public double parimiter() {
		double p = this.vertices[0].distance(this.vertices[this.vertices.length-1]);
		for(int i=0; i < this.vertices.length-1; i++) {
			p += this.vertices[i].distance(this.vertices[i+1]);
		}
		return p;
	}
}
