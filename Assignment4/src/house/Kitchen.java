package house;

import java.util.Scanner;

public class Kitchen extends Room {
    public boolean stove;

    public Kitchen(String name, boolean lighting) {
        super(name, lighting);
        this.stove = false;
    }

    public Kitchen(String name, boolean lighting, boolean stove) {
        super(name, lighting);
        this.stove = stove;
    }

    public void switchStove() {
        super.printSwitch("stove", this.stove);
        this.stove = !this.stove;
    }

    @Override
    public void printFeatures() {
        super.printFeatures();
        System.out.println("4) Switch stove");
    }

    @Override public void checkFeatures() {
        super.checkFeatures();
        if (stove) {
            System.out.println("Warning: Stove in the " + name + " is still switched on");
        }
    }
}
