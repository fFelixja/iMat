import java.util.Calendar;
import java.util.regex.*;

public final class CheckUtils {

    public static boolean check(int checkType, String txt){
        switch (checkType){
            case 0:
                return nameCheck(txt);
            case 1:
                return adressCheck(txt);
            case 2:
                return zipCheck(txt);
            case 3:
                return cityCheck(txt);
            case 4:
                return phoneCheck(txt);

            case 5:
                return cardNumberCheck(txt);

            case 6:
                return cardHolderCheck(txt);
            case 7:
                return monthCheck(txt);
            case 8:
                return yearCheck(txt);
            case 9:
                return ccvCheck(txt);



            default: return false;
        }
    }

    /**
     * Checks string so it's only contains Alphabetic characthers
     * @param txt
     * @return
     */
    private static boolean nameCheck(String txt){
        Pattern pattern = Pattern.compile("^[A-Za-zs]{1,}[.]{0,1}[A-Za-zs]{0,}$",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }

    /**
     * Checks string so it doesn't contain special characters
     * @param txt
     * @return
     */
    private static boolean adressCheck(String txt){
        Pattern pattern = Pattern.compile("[^¤/()=?^£:;_<>|¦&%$#@!~]$",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }

    /**
     * Checks string to only be digits and 5 chars long
     * @param txt
     * @return
     */
    private static boolean zipCheck(String txt){
        Pattern pattern = Pattern.compile("\\d{5}",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }

    /**
     * Checks string to only contain alphabetic characters
     * @param txt
     * @return
     */
    private static boolean cityCheck(String txt){
        Pattern pattern = Pattern.compile("([a-zA-Z]$|[a-zA-Z]$\\s[a-zA-Z]$)",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }

    /**
     * checks string to only contain digits and be 10 chars long
     * @param txt
     * @return
     */
    private static boolean phoneCheck(String txt){
        if(txt.length() > 10){
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]{5,10}\\b$",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }

    /**
     * Checks string if it's two names and the names are valid
     * @param txt
     * @return
     */
    private static boolean cardHolderCheck(String txt){
        if(txt.contains(" ")) {
            String[] tmp = txt.split(" ");
            return  nameCheck(tmp[0]) && nameCheck(tmp[1]);
        }else{
            return false;
        }
    }

    /**
     * Checks the string so it's is an valid month and not expired
     * @param txt
     * @return
     */
    private static boolean monthCheck(String txt){
        if(txt.length() != 2) {
            return false;
        }else {
            Pattern pattern = Pattern.compile("[0-9]$",Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(txt);

            int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
            int txtMonth = Integer.parseInt(txt);

            return matcher.find() && (txtMonth - currentMonth >= 0);
        }
    }

    /**
     * Checks the string so it's is an valid year and not expired
     * @param txt
     * @return
     */
    private static boolean yearCheck(String txt){
        if(txt.length() != 2) {
            return false;
        }else {
            Pattern pattern = Pattern.compile("[0-9]$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(txt);

            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            int txtMonth = Integer.parseInt(txt);

            return matcher.find() && (txtMonth - currentYear >= 0);
        }
    }

    /**
     * Checks ccv to only contains digits and 3 characters.
     * @param txt
     * @return
     */
    private static boolean ccvCheck(String txt){
        if(txt.length() != 3){
            return false;
        }else{
            Pattern pattern = Pattern.compile("[0-9]$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(txt);
            return matcher.find();

        }

    }

    private static boolean cardNumberCheck(String txt){
        return false;
    }
}
