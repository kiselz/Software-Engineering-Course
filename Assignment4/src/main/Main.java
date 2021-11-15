/*Group AG 0908
Makar Utochkin 108019266937
Aleksandr Kiselev 108020240073
Duong Viet Anh 108020258416
*/

package main;

import house.Apartment;
import house.Bathroom;
import house.Kitchen;
import house.Room;

public class Main {
    public static void main(String[] args) {
        //init rooms
        Room hallway = new Room("Hallway", false);
        Room workroom = new Room("Workroom", false);
        Room bedroom = new Room("Bedroom", false);
        Room kitchen = new Kitchen("Kitchen", false);
        Room bathroom = new Bathroom("Bathroom", false);
        //adding neighbours
        hallway.addNeighbours(workroom, bedroom, kitchen, bathroom);
        workroom.addNeighbours(bedroom);
        //init apartments
        Apartment apartment = new Apartment(hallway);
        apartment.extension(workroom, bedroom, kitchen, bathroom);


        apartment.enter();
    }
}
