public class Player {
	
	String name;
	double height;
	int num_of_points;
	
	public Player (String name, double height, int num_of_points) {
		this.name = name;
		this.height = height;
		this.num_of_points = num_of_points;
	}

	public String getName() {
		return name;
	}

	public double getHeight() {
		return height;
	}

	public int getNum_of_points() {
		return num_of_points;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setNum_of_points(int num_of_points) {
		this.num_of_points = num_of_points;
	}
	
	public String toString() {
		return this.name + " is " + this.height + " centemeters tall, and scored " + this.num_of_points + " Points this season.";
	}
	
}
