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
                return false;

            case 6:
                return cardHolderCheck(txt);



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
    private static boolean cityCheck(String txt){
        Pattern pattern = Pattern.compile("([a-zA-Z]$|[a-zA-Z]$\\s[a-zA-Z]$)",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }
    private static boolean phoneCheck(String txt){
        if(txt.length() > 10){
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]{5,10}\\b$",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }
    private static boolean cardHolderCheck(String txt){
        if(txt.contains(" ")) {
            String[] tmp = txt.split(" ");
            return  nameCheck(tmp[0]) && nameCheck(tmp[1]);
        }else{
            return false;
        }
    }
}
