/*Group AG 0908
Makar Utochkin 108019266937
Aleksandr Kiselev 108020240073
Duong Viet Anh 108020258416
*/

package house;

//Kitchen is a child class of a Room.java
public class Kitchen extends Room {
    //field
    public boolean stove;
    //constructor
    public Kitchen(String name, boolean lighting) {
        super(name, lighting);
        this.stove = false;
    }

    public Kitchen(String name, boolean lighting, boolean stove) {
        super(name, lighting);
        this.stove = stove;
    }
    //switches stove
    public void switchStove() {
        super.printSwitch("stove", this.stove);
        this.stove = !this.stove;
    }
    //overrided method for Kitchen
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
