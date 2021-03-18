package controllers;

import commons.ReadWriteFile;
import commons.Validation;
import models.House;


import java.util.*;

public class HouseController {
    private static final String HOUSE_PATH = "D:\\FuramaResort\\src\\data\\House.csv";

    public void addNewHouse() {
        Scanner scanner = new Scanner(System.in);
        House house = new House();
        do {
            System.out.println("Service Code :");
            String code = scanner.nextLine();
            if (Validation.validateHouseCode(code)) {
                house.setServiceCode(code);
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Service Name :");
            String name = scanner.nextLine();
            if (Validation.validateName(name)) {
                house.setServiceName(name);
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Usable area :");
            String area = scanner.nextLine();
            if (Validation.validateArea(area)) {
                house.setUsableArea(Double.parseDouble(area));
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Rental Cost :");
            String cost = scanner.nextLine();
            if (Validation.validateRentCost(cost)) {
                house.setRentalCost(Double.parseDouble(cost));
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Amount People :");
            String amount = scanner.nextLine();
            if (Validation.validateAmountPeople(amount)) {
                house.setMaxAmountPeople(Integer.parseInt(amount));
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Rental Type");
            String rentalType = scanner.nextLine();
            if (Validation.validateRentalType(rentalType)) {
                house.setRentalType(rentalType);
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Room standard :");
            String standard = scanner.nextLine();
            if (Validation.validateName(standard)) {
                house.setRoomStandard(standard);
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Convenient :");
            String convenient = scanner.nextLine();
            if (Validation.validateName(convenient)) {
                house.setOtherConvenient(convenient);
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Floors :");
            String floors = scanner.nextLine();
            if (Validation.validateFloor(floors)) {
                house.setNumberOfFloors(Integer.parseInt(floors));
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);
        writeHouseCsv(house);
    }

    public List<House> showHouseList() {
        List<House> houseList = new ArrayList<>(readHouseCsv());
        int size = houseList.size();
        if (size ==0){
            System.out.println("House's list is empty");
            System.out.println("------------------------");
        }
        System.out.println("------------------------");
        for (int i = 0; i < houseList.size(); i++) {
            System.out.println((i + 1) + ". " + houseList.get(i).showInfor());
        }
        System.out.println("------------------------");
        return houseList;
    }

    public void showHouseListNotDuplicate() {
        Set<House> houseSet = new TreeSet<>(readHouseCsv());
        int size = houseSet.size();
        if (size ==0){
            System.out.println("House's list is empty");
            System.out.println("------------------------");
        }

        for (House house : houseSet) {
            System.out.println(house.showInfor());
        }

    }

    private void writeHouseCsv(House house) {
        ReadWriteFile write = new ReadWriteFile();
        write.write(house, HOUSE_PATH, true);
    }

    private List<House> readHouseCsv() {
        ReadWriteFile read = new ReadWriteFile();
        List<String[]> list = new ArrayList<>(read.read(HOUSE_PATH));
        List<House> houseList = new ArrayList<>();
        for (String[] strings : list) {
            House house = new House(strings);
            houseList.add(house);
        }
        return houseList;
    }
}


