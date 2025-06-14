package mywebsite_2.util;

public class Helper {
    //Validating all the string fields
    public static boolean isNullOrEmpty(String str) {
        if(str == null || str.isEmpty()){
            return true;
        }
        return false;
    }


}
