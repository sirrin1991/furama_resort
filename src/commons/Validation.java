package commons;


import java.util.regex.Pattern;

public class Validation  {
    private static final String REGEX_VILLA_CODE = "^(SVVL-)\\d{4}$";
    private static final String REGEX_HOUSE_CODE = "^(SVHO-)\\d{4}$";
    private static final String REGEX_ROOM_CODE = "^(SVRO-)\\d{4}$";
    private static final String NAME = "^[A-Z][a-z]*(\\ [A-Z][a-z]*)*$";
    private static final String AREA = "^[3-9]+[0-9]\\.[0-9]+$";
    private static final String RENTCOST = "^[1-9][0-9]+(\\.[0-9]+)*$";
    private static final String AMOUNT_PEOPLE ="^([0][1-9]|[1][0-9])$";
    private static final String INCLUSION_SERVICES = "^(massage|karaoke|food|drink|car)$";
    private static final String FLOOR ="^[1-9]$";
    private static final String BIRTH_DAY = "^(((0[1-9]|[12]\\d|3[01])/((0[13578])|(1[02])))|((0[1-9]|[12]\\d|30)/((0[2469])|11)))/((19[4-9]\\d)|200[0-3])$";
    private static final String EMAIL ="^[a-z]+([\\_\\.]?[a-z\\d]+)*@[a-z]{3,7}\\.[a-z]{3}$";
    private static final String GENDER = "^([Mm][Aa][lL][Ee]|[Ff][Ee][Mm][Aa][Ll][Ee]|[Uu][Nn][Kk][Nn][Oo][Ww][Nn])$";
    private static final String ID_CARD="^\\d{9}$";
    private static final String RENTAL_TYPE ="^(Year|Month|Day|Hour)$";
    private static final String PHONE_NUMBER="^\\d{10,11}$";


    public static boolean validateVillaCode(String string){
        return Pattern.matches(REGEX_VILLA_CODE,string);
    }

    public static boolean validateHouseCode(String string){
        return Pattern.matches(REGEX_HOUSE_CODE,string);
    }

    public static boolean validateRoomCode(String string){
        return Pattern.matches(REGEX_ROOM_CODE,string);
    }

    public static boolean validateName(String string) {
        return Pattern.matches(NAME, string);
    }

    public static boolean validateArea(String string){
        return Pattern.matches(AREA,string);
    }

    public static boolean validateRentCost(String string){
        return Pattern.matches(RENTCOST,string);
    }

    public static boolean validateAmountPeople(String string){
        return Pattern.matches(AMOUNT_PEOPLE,string);
    }

    public static boolean validateInclusionServices(String string){
        return Pattern.matches(INCLUSION_SERVICES,string);
    }

    public static boolean validateFloor(String string){
        return Pattern.matches(FLOOR,string);
    }

    public static boolean validateCustomerName(String string) throws NameException{
        if(Pattern.matches(NAME,string)){
            return true;
        }else {
            throw new NameException("Invalid format (Ex: Abc Abc)");
        }
    }
    public static boolean validateBirthDay(String string) throws BirthdayException{
       if(Pattern.matches(BIRTH_DAY,string)){
           return true;
       }else {
           throw new BirthdayException("The age can not less than 18 and more than 80 with format dd/mm/yyyy");
       }

    }

    public static boolean validateEmail(String string) throws EmailException{
        if(Pattern.matches(EMAIL,string)){
            return true;
        }else {
            throw new EmailException("Invalid format (ex : abc@abc.abc)");
        }
    }

    public static boolean validateGender(String string) throws  GenderException{
        if(Pattern.matches(GENDER,string)){
            return true;
        }else {
            throw new GenderException("Invalid format (choice one of three : male , female , unknown");
        }
    }

    public static boolean validateIDCard(String string) throws IdCardException{
        if (Pattern.matches(ID_CARD,string)){
            return true;
        }else {
            throw new IdCardException("Invalid format. The format of ID card is XXXXXXXXX with X is a number 0-9");
        }
    }

    public static boolean validatePhoneNumber(String string)throws PhoneNumberException{
        if (Pattern.matches(PHONE_NUMBER,string)){
            return true;
        }else {
            throw new PhoneNumberException("Invalid format, phone number has 10 or 11 numbers.");
        }
    }

    public static boolean validateRentalType(String string){
        return Pattern.matches(RENTAL_TYPE,string);
    }
}





