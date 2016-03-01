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




            default: return false;
        }
    }

    private static boolean nameCheck(String txt){
        Pattern pattern = Pattern.compile("^[A-Za-zs]{1,}[.]{0,1}[A-Za-zs]{0,}$",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }
    private static boolean adressCheck(String txt){
        Pattern pattern = Pattern.compile("[^¤/()=?^£:;_<>|¦&%$#@!~]$",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }

    private static boolean zipCheck(String txt){
        Pattern pattern = Pattern.compile("\\d{5}",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }
}
