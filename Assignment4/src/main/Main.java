package main;

import house.Apartment;
import house.Bathroom;
import house.Kitchen;
import house.Room;

public class Main {
    public static void main(String[] args) {
        Room hallway = new Room("Hallway", false);
        Room workroom = new Room("Workroom", false);
        Room bedroom = new Room("Bedroom", false);
        Room kitchen = new Kitchen("Kitchen", false);
        Room bathroom = new Bathroom("Bathroom", false);

        hallway.addNeighbours(workroom, bedroom, kitchen, bathroom);
        workroom.addNeighbours(bedroom);

        Apartment apartment = new Apartment(hallway);
        apartment.extension(workroom, bedroom, kitchen, bathroom);


        apartment.enter();
    }
}
