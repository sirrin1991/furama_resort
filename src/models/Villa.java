package models;

import java.util.Collections;

public class Villa extends Service implements Comparable<Villa>  {
    private String roomStandard;
    private String otherConvenient;
    private double poolArea;
    private int numberOfFloors;

    public Villa(String serviceCode, String serviceName, double usableArea, double rentalCost, int maxAmountPeople, String rentalType, String roomStandard, String otherConvenient, double poolArea, int numberOfFloors) {
        super(serviceCode, serviceName, usableArea, rentalCost, maxAmountPeople, rentalType);
        this.roomStandard = roomStandard;
        this.otherConvenient = otherConvenient;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(){

    }

    public Villa(String[] strings) {
        super(strings);
        this.roomStandard = strings[6];
        this.otherConvenient = strings[7];
        this.poolArea = Double.parseDouble(strings[8]);
        this.numberOfFloors = Integer.parseInt(strings[9]);
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

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return super.toString() + "," + roomStandard + "," + otherConvenient + "," + poolArea + "," + numberOfFloors;
    }

    @Override
    public void showInfor() {
        System.out.println("Villa {service code ='" + getServiceCode() + "'" +
                ", serviceName='" + getServiceName() + "'" +
                ", usable area='" + getUsableArea() + "'" +
                ", rental cost='" + getRentalCost() + "'" +
                ", maxAmountOfPeople='" + getMaxAmountPeople() + "'" +
                ", rental type='" + getRentalType() + "'" +
                ", room standard='" + roomStandard + "'" +
                ", other convenient='" + otherConvenient + "'" +
                ", pool area='" + poolArea + "'" +
                ", number of floors='" + numberOfFloors + "'}");
    }

    @Override
    public int compareTo(Villa villa) {
        return getServiceName().compareTo(villa.getServiceName());
    }

}
