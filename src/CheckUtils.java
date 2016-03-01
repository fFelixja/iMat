import java.util.regex.*;

public final class CheckUtils {

    public static boolean nameCheck(String txt){
        Pattern pattern = Pattern.compile("^[A-Za-zs]{1,}[.]{0,1}[A-Za-zs]{0,}$",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }

}
