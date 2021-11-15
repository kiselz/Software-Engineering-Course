package house;

import java.util.Scanner;

public class Bathroom extends Room {
    public boolean shower;

    public Bathroom(String name, boolean lighting) {
        super(name, lighting);
        this.shower = false;
    }

    public Bathroom(String name, boolean lighting, boolean shower) {
        super(name, lighting);
        this.shower = shower;
    }

    public void switchShower() {
        super.printSwitch("shower", this.shower);
        this.shower = !this.shower;
    }

    @Override
    public void printFeatures() {
        super.printFeatures();
        System.out.println("4) Switch the shower");
    }

    @Override
    public void checkFeatures() {
        super.checkFeatures();
        if (shower) {
            System.out.println("Warning: Shower in the " + name + " is still switched on");
        }
    }
    @Override
    public void enter() {
        while (true) {
            this.printFeatures();
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    this.switchLight();
                    break;
                case 2:
                    return;
                case 3:
                    this.printNeighbours();
                    int room = sc.nextInt() - 1;
                    this.neighbours.get(room).enter();
                    break;
                case 4:
                    this.switchShower();
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }
}
