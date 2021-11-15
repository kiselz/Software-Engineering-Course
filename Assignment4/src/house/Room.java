package house;

import java.util.ArrayList;
/*Group AG 0908
Makar Utochkin 108019266937
Aleksandr Kiselev 108020240073
Duong Viet Anh 108020258416
*/

import java.util.Scanner;

//Room is a parent-class for all other classes, except Apartment.java
public class Room {
    //fields
    public String name;
    public boolean lighting;
    public ArrayList<Room> neighbours;
    //constructor
    public Room(String name, boolean lighting) {
        this.name = name;
        this.lighting = lighting;
        this.neighbours = new ArrayList<>();
    }
    //method addNeighbours adds a neighbour of a current room
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
    //enter method is an endless cycle, which is a guide
    public void enter() {
        while (true) {
            //starts with all possible actions in a room
            this.printFeatures();
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            //checks the choice of a user
            switch (choice) {
                case 1:
                    this.switchLight();
                    break;
                case 2:
                    // If we are leaving from the apartment's entrance then it should be not printed
                    if (Thread.currentThread().getStackTrace().length > 4) {
                        System.out.println("Returning to previous room.\n");
                    }
                    return;
                case 3:
                    this.printNeighbours();
                    int room = sc.nextInt() - 1;
                    this.neighbours.get(room).enter();
                    break;
                case 4:
                    if (this.name.equals("Kitchen")){
                        Kitchen kitchen = (Kitchen)this;
                        kitchen.switchStove();
                    }
                    else if (this.name.equals("Bathroom")){
                        Bathroom bathroom = (Bathroom)this;
                        bathroom.switchShower();
                    }
                    break;

                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }
    //prints all possible actions in the current room for the user
    public void printFeatures() {
        System.out.println("You are in the " + this.name);
        System.out.println("1) Switch light");
        System.out.println("2) Leave room");
        System.out.println("3) Enter neighbouring room");
    }
    //warnings
    public void checkFeatures() {
        if (this.lighting) {
            System.out.println("Warning: Lightning in the " + name + " is still switched on");
        }
    }
    //prints neighbours of a current room
    public void printNeighbours() {
        for (int i = 0; i < this.neighbours.size(); i++) {
            System.out.println((i + 1) + ") " + this.neighbours.get(i).name);
        }
    }
    //light/shower/stove switcher
    public void printSwitch(String name, boolean parameter) {
        if (parameter) {
            System.out.println("Switched off " + name);
        } else {
            System.out.println("Switched on " + name);
        }
    }
    //switches light in a room
    public void switchLight() {
        this.printSwitch("light", this.lighting);
        this.lighting = !this.lighting;
    }
    //toString method returns string
    public String toString() {
        return this.name;
    }
}
