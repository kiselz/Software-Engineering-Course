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


//        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
//        for (int i = 1; i < elements.length; i++) {
//            StackTraceElement s = elements[i];
//            System.out.println("\tat " + s.getClassName() + "." + s.getMethodName() + "(" + s.getFileName() + ":" + s.getLineNumber() + ")");
//        }
        apartment.enter();
    }
}
