
package house;

/*import*/
import java.util.HashMap;

public class Apartment {
    public Room entrance;
    public HashMap<String, Room> rooms;

    public Apartment(Room entrance) {
        this.rooms = new HashMap<>();
        this.entrance = entrance;
        this.extension(entrance);
    }

    public void enter() {
        entrance.enter();
        for (String key: rooms.keySet()) {
            Room room = rooms.get(key);
            room.checkFeatures();

        }
    }
    public void extension(Room... newRooms) {
        for (Room newRoom: newRooms) {
            rooms.put(newRoom.name, newRoom);
        }
    }
}
