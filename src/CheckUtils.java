import java.util.Calendar;
import java.util.regex.*;
import javafx.scene.image.Image;

public class CheckUtils {

    private String cardType = "";
    private Image cardImage;

    public boolean check(int checkType, String txt){
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
    private boolean nameCheck(String txt){
        Pattern pattern = Pattern.compile("^[A-Za-zs]{1,}[.]{0,1}[A-Za-zs]{0,}$",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }

    /**
     * Checks string so it doesn't contain special characters
     * @param txt
     * @return
     */
    private boolean adressCheck(String txt){
        Pattern pattern = Pattern.compile("[^¤/()=?^£:;_<>|¦&%$#@!~]$",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }

    /**
     * Checks string to only be digits and 5 chars long
     * @param txt
     * @return
     */
    private boolean zipCheck(String txt){
        Pattern pattern = Pattern.compile("\\d{5}",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }

    /**
     * Checks string to only contain alphabetic characters
     * @param txt
     * @return
     */
    private boolean cityCheck(String txt){
        Pattern pattern = Pattern.compile("([a-zA-Z]$|[a-zA-Z]$\\s[a-zA-Z]$)",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }

    /**
     * checks string to only contain digits and be 10 chars long
     * @param txt
     * @return
     */
    private  boolean phoneCheck(String txt){
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
    private boolean cardHolderCheck(String txt){
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
    private boolean monthCheck(String txt){
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
    private boolean yearCheck(String txt){
        if(txt.length() != 2) {
            return false;
        }else {
            Pattern pattern = Pattern.compile("[0-9]$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(txt);

            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            int txtMonth = 2000 + Integer.parseInt(txt);

            return matcher.find() && (txtMonth - currentYear >= 0);
        }
    }

    /**
     * Checks ccv to only contains digits and 3 characters.
     * @param txt
     * @return
     */
    private boolean ccvCheck(String txt){
        if(txt.length() != 3){
            return false;
        }else{
            Pattern pattern = Pattern.compile("[0-9]$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(txt);
            return matcher.find();

        }

    }

    private boolean cardNumberCheck(String txt){

        //Visa card
        Pattern pattern = Pattern.compile("^4(\\d{3})(?!\\1{3})([\\ \\-]?)(?!(\\d)\\3{3})(\\d{4})\\2(?!\\4|(\\d)\\5{3}|1234|2345|3456|5678|7890)(\\d{4})\\2(?!\\6|(\\d)\\7{3}|1234|3456)\\d{4}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        if(matcher.find()){
            cardType = "Visa";
            cardImage = new Image("img/visa.png");
            return true;
        }
        //Mastercard
        pattern = Pattern.compile("\\b(?<!\\-|\\.)5([1-5]\\d{2})(?!\\1{3})([\\ \\-]?)(?<!\\d\\ \\d{4}\\ )(?!(\\d)\\3{3})(\\d{4})\\2(?!\\4|(\\d)\\5{3}|1234|2345|3456|5678|7890)(\\d{4})(?!\\ \\d{4}\\ \\d)\\2(?!\\6|(\\d)\\7{3}|1234|3456)\\d{4}(?!\\-)(?!\\.\\d)\\b", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(txt);
        if(matcher.find()){
            cardType = "Mastercard";
            cardImage = new Image("img/mastercard.png");
            return true;
        }else {
            cardType = "Ogiltligt kort";
            cardImage = null;
            return false;
        }
    }
    public String getCardType(){
        return cardType;
    }
    public Image getCardImage(){
        return cardImage;
    }
}
