package Final_For_Bagrut.Tests;
import Final_For_Bagrut.Node.Node;

public class Test4 {

}

class Volunteer{
    String id;
    String name;
    int level;
    String current;
    Node<String> prev;
    int[] a;

    public Volunteer (String id, String name){
        this.id = id;
        this.name = name;
        this.level = 10;
        this.current = "None";
        this.prev = new Node<>();
        this.a = new int[3];
    }

    public void addPlace(String place){
        if (!this.current.equals("None"))
            this.prev = new Node<>(current, this.prev);
        this.current = place;
    }

    public void addHours(int h){
        this.a[this.level % 10] += h;
    }

    public String isElligible(){
        String base_string = "Total hours: " + this.a[0] + this.a[1] + this.a[2] + ". Current place is: " + this.current;
        if(this.level == 12){
            if(this.a[0] >= 60 && this.a[1] >= 30 && this.a[2] >= 30){
                base_string += this.prev.toString();
                return base_string;
            }
        }
        return "NOPE";
    }
}
