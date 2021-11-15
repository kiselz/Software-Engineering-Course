import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Room {
    public String name;
    public boolean lighting;
    public ArrayList<Room> neighbours;

    public Room(String name, boolean lighting) {
        this.name = name;
        this.lighting = lighting;
        this.neighbours = new ArrayList<>();
    }

    public void addNeighbours(Room... neighbours) {
        for (Room neighbour : neighbours) {
            if (!this.neighbours.contains(neighbour)) {
                this.neighbours.add(neighbour);
            }
            if (!neighbour.neighbours.contains(this)) {
                neighbour.neighbours.add(this);
            }
        }
    }

    public void enter() {
        while (true) {
            this.printFeatures();
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    this.switchLight();
//                    StackTraceElement[] elements = Thread.currentThread().getStackTrace();
//                    for (int i = 1; i < elements.length; i++) {
//                        StackTraceElement s = elements[i];
//                        System.out.println("\tat " + s.getClassName() + "." + s.getMethodName() + "(" + s.getFileName() + ":" + s.getLineNumber() + ")");
//                    }
                    break;
                case 2:
                    return;
                case 3:
                    this.printNeighbours();
                    int room = sc.nextInt() - 1;
                    this.neighbours.get(room).enter();
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }

    public void printFeatures() {
        System.out.println("You are in the " + this.name);
        System.out.println("1) Switch light");
        System.out.println("2) Leave room");
        System.out.println("3) Enter neighbouring room");
    }

    public void checkFeatures() {
        if (this.lighting) {
            System.out.println("Warning: Lightning in the " + name + " is still switched on");
        }
    }

    public void printNeighbours() {
        for (int i = 0; i < this.neighbours.size(); i++) {
            System.out.println((i + 1) + ") " + this.neighbours.get(i).name);
        }
    }

    public void printSwitch(String name, boolean parameter) {
        if (parameter) {
            System.out.println("Switched off " + name);
        } else {
            System.out.println("Switched on " + name);
        }
    }

    public void switchLight() {
        this.printSwitch("light", this.lighting);
        this.lighting = !this.lighting;
    }

    public String toString() {
        return this.name;
    }
}