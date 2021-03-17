package models;

public class House extends Service implements Comparable<House> {
    private String roomStandard;
    private String otherConvenient;
    private int numberOfFloors;

    public House(String serviceCode, String serviceName, double usableArea, double rentalCost, int maxAmountPeople, String rentalType, String roomStandard, String otherConvenient, int numberOfFloors) {
        super(serviceCode, serviceName, usableArea, rentalCost, maxAmountPeople, rentalType);
        this.roomStandard = roomStandard;
        this.otherConvenient = otherConvenient;
        this.numberOfFloors = numberOfFloors;
    }

    public House(){
    }

    public House(String[] strings){
        super(strings);
        this.roomStandard = strings[6];
        this.otherConvenient = strings[7];
        this.numberOfFloors = Integer.parseInt(strings[8]);
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getOtherConvenient() {
        return otherConvenient;
    }

    public void setOtherConvenient(String otherConvenient) {
        this.otherConvenient = otherConvenient;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return super.toString() + "," + roomStandard + "," + otherConvenient + "," + numberOfFloors;
    }

    @Override
    public String showInfor() {
        return  "House {service code='" + getServiceCode() + "'" +
                ", serviceName='" + getServiceName() + "'" +
                ", usable area='" + getUsableArea() + "'" +
                ", rental cost='" + getRentalCost() + "'" +
                ", maxAmountOfPeople='" + getMaxAmountPeople() + "'" +
                ", rental type='" + getRentalType() + "'" +
                ", room standard='" + roomStandard + "'" +
                ", other convenient='" + otherConvenient + "'" +
                ", number of floors='" + numberOfFloors + "'}";
    }



    @Override
    public int compareTo(House o) {
        return getServiceName().compareTo(o.getServiceName());
    }
}

