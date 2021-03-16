package controllers;


import commons.ReadWriteFile;
import commons.Validation;
import models.Villa;

import java.util.*;

public class VillaController {
    Scanner scanner = new Scanner(System.in);
    private final String VILLA_PATH = "D:\\FuramaResort\\src\\data\\Villa.csv";

    public void addNewVilla() {
        Villa villa = new Villa();
        do {
            System.out.println("Service Code :");
            String code = scanner.nextLine();
            if (Validation.validateVillaCode(code)) {
                villa.setServiceCode(code);
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Service Name :");
            String name = scanner.nextLine();
            if (Validation.validateName(name)) {
                villa.setServiceName(name);
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Usable area :");
            String area = scanner.nextLine();
            if (Validation.validateArea(area)) {
                villa.setUsableArea(Double.parseDouble(area));
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Rental Cost :");
            String cost = scanner.nextLine();
            if (Validation.validateRentCost(cost)) {
                villa.setRentalCost(Double.parseDouble(cost));
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Amount People :");
            String amount = scanner.nextLine();
            if (Validation.validateAmountPeople(amount)) {
                villa.setMaxAmountPeople(Integer.parseInt(amount));
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Rental Type");
            String rentalType = scanner.nextLine();
            if (Validation.validateRentalType(rentalType)) {
                villa.setRentalType(rentalType);
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Room standard :");
            String standard = scanner.nextLine();
            if (Validation.validateName(standard)) {
                villa.setRoomStandard(standard);
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Convenient :");
            String convenient = scanner.nextLine();
            if (Validation.validateName(convenient)) {
                villa.setOtherConvenient(convenient);
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Pool area :");
            String poolArea = scanner.nextLine();
            if (Validation.validateArea(poolArea)) {
                villa.setPoolArea(Double.parseDouble(poolArea));
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Floors :");
            String floors = scanner.nextLine();
            if (Validation.validateFloor(floors)) {
                villa.setNumberOfFloors(Integer.parseInt(floors));
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);
        writeVillaCsv(villa);
        System.out.println("----------------------");
    }

    public void showVillaList() {
        List<Villa> villaList = new ArrayList<>(readVillaCsv());
        for (Villa villa : villaList) {
            villa.showInfor();
        }
    }

    public void showVillaListNotDuplicate(){
        Set<Villa> villaSet = new TreeSet<>(readVillaCsv());
        for(Villa villa : villaSet){
            villa.showInfor();
        }
    }

    private void writeVillaCsv(Villa villa) {
        ReadWriteFile write = new ReadWriteFile();
        write.write(villa, VILLA_PATH, true);
    }

    private List<Villa> readVillaCsv() {
        ReadWriteFile read = new ReadWriteFile();
        List<String[]> list = new ArrayList<>(read.read(VILLA_PATH));
        List<Villa> villaList = new ArrayList<>();
        for (String[] strings : list) {
            Villa villa = new Villa(strings);
            villaList.add(villa);
        }
        return villaList;
    }

}
