/*Group AG 0908
Makar Utochkin 108019266937
Aleksandr Kiselev 108020240073
Duong Viet Anh 108020258416
*/
package house;

/*import*/
import java.util.HashMap;

public class Apartment {
    //fields
    public Room entrance;
    public HashMap<String, Room> rooms;
    //constructor
    public Apartment(Room entrance) {
        this.rooms = new HashMap<>();
        this.entrance = entrance;
        this.extension(entrance);
    }
    //entering the apartments
    public void enter() {
        entrance.enter();
        for (String key: rooms.keySet()) {
            Room room = rooms.get(key);
            room.checkFeatures();

        }
        System.out.println("Leaving apartment");
    }
    //extending apartments with other rooms
    public void extension(Room... newRooms) {
        for (Room newRoom: newRooms) {
            rooms.put(newRoom.name, newRoom);
        }
    }
}
