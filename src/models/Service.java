package models;

public abstract class Service {
    private String serviceCode;
    private String serviceName;
    private double usableArea;
    private double rentalCost;
    private int maxAmountPeople;
    private String rentalType;

    public Service(String serviceCode, String serviceName, double usableArea, double rentalCost, int maxAmountPeople, String rentalType) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCost = rentalCost;
        this.maxAmountPeople = maxAmountPeople;
        this.rentalType = rentalType;
    }

    public Service(String[] strings){
        this.serviceCode = strings[0];
        this.serviceName = strings[1];
        this.usableArea = Double.parseDouble(strings[2]);
        this.rentalCost = Double.parseDouble(strings[3]);
        this.maxAmountPeople = Integer.parseInt(strings[4]);
        this.rentalType = strings[5];
    }


    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public Service() {
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaxAmountPeople() {
        return maxAmountPeople;
    }

    public void setMaxAmountPeople(int maxAmountPeople) {
        this.maxAmountPeople = maxAmountPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return serviceCode + "," + serviceName + "," + usableArea + "," + rentalCost + "," + maxAmountPeople + "," + rentalType;
    }

    public abstract String showInfor();

}
