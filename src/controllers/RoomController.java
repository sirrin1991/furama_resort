package controllers;

import commons.ReadWriteFile;
import commons.Validation;
import models.Room;

import java.util.*;

public class RoomController {
    private final String ROOM_PATH = "D:\\FuramaResort\\src\\data\\Room.csv";

    public void addNewRoom() {
        Scanner scanner = new Scanner(System.in);
        Room room = new Room();
        do {
            System.out.println("Service Code :");
            String code = scanner.nextLine();
            if (Validation.validateRoomCode(code)) {
                room.setServiceCode(code);
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Service Name :");
            String name = scanner.nextLine();
            if (Validation.validateName(name)) {
                room.setServiceName(name);
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Usable area :");
            String area = scanner.nextLine();
            if (Validation.validateArea(area)) {
                room.setUsableArea(Double.parseDouble(area));
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Rental Cost :");
            String cost = scanner.nextLine();
            if (Validation.validateRentCost(cost)) {
                room.setRentalCost(Double.parseDouble(cost));
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Amount People :");
            String amount = scanner.nextLine();
            if (Validation.validateAmountPeople(amount)) {
                room.setMaxAmountPeople(Integer.parseInt(amount));
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Rental Type");
            String rentalType = scanner.nextLine();
            if (Validation.validateRentalType(rentalType)) {
                room.setRentalType(rentalType);
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);

        do {
            System.out.println("Free Services :");
            String freeService = scanner.nextLine();
            if (Validation.validateName(freeService)) {
                room.setFreeService(freeService);
                break;
            }
            System.out.println("---Input false, try again---");
        } while (true);
        writeRoomCsv(room);
    }

    public List<Room> showRoomList() {
        List<Room> roomList = new ArrayList<>(readRoomCsv());
        int size = roomList.size();
        if (size ==0){
            System.out.println("Room's list is empty");
            System.out.println("---------------------");
        }
        for (int i = 0; i < roomList.size(); i++) {
            System.out.println((i + 1) + ". " + roomList.get(i).showInfor());
        }
        return roomList;
    }

    public void showRoomListNotDuplicate() {
        Set<Room> roomSet = new TreeSet<>(readRoomCsv());
        int size = roomSet.size();
        if (size ==0){
            System.out.println("Room's list is empty");
            System.out.println("---------------------");
        }
        for (Room room : roomSet) {
            System.out.println(room.showInfor());
        }
    }

    private void writeRoomCsv(Room room) {
        ReadWriteFile write = new ReadWriteFile();
        write.write(room, ROOM_PATH, true);
    }

    private List<Room> readRoomCsv() {
        ReadWriteFile read = new ReadWriteFile();
        List<String[]> list = new ArrayList<>(read.read(ROOM_PATH));
        List<Room> roomList = new ArrayList<>();
        for (String[] strings : list) {
            Room room = new Room(strings);
            roomList.add(room);
        }
        return roomList;
    }
}

