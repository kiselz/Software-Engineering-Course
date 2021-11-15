package house;

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
}
