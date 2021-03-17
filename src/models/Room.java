package models;

public class Room extends Service implements Comparable<Room> {
    private String freeService;

    public Room(String serviceCode, String serviceName, double usableArea, double rentalCost, int maxAmountPeople, String rentalType, String freeService) {
        super(serviceCode, serviceName, usableArea, rentalCost, maxAmountPeople, rentalType);
        this.freeService = freeService;
    }

    public Room() {
    }

    public Room(String[] strings){
        super(strings);
        this.freeService = strings[6];
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return super.toString() + "," + freeService;
    }

    @Override
    public String showInfor() {
        return  "Room {service code ='" + getServiceCode() + "'" +
                ", serviceName='" + getServiceName() + "'" +
                ", usable area='" + getUsableArea() + "'" +
                ", rental cost='" + getRentalCost() + "'" +
                ", maxAmountOfPeople='" + getMaxAmountPeople() + "'" +
                ", rental type='" + getRentalType() + "'" +
                ", free service included='" + freeService + "'}";
    }

    @Override
    public int compareTo(Room o) {
        return getServiceName().compareTo(o.getServiceName());
    }
}
