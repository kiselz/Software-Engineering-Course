/*Group AG 0908
Makar Utochkin 108019266937
Aleksandr Kiselev 108020240073
Duong Viet Anh 108020258416
*/

package house;


//class bathroom is a child-class of Room
public class Bathroom extends Room {
    //fields
    public boolean shower;
    //constructor
    public Bathroom(String name, boolean lighting) {
        super(name, lighting);
        this.shower = false;
    }

    public Bathroom(String name, boolean lighting, boolean shower) {
        super(name, lighting);
        this.shower = shower;
    }
    //shower swithcer
    public void switchShower() {
        super.printSwitch("shower", this.shower);
        this.shower = !this.shower;
    }
    //overrrided methods
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
