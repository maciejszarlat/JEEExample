package controller.warsztat.validation;

public class EmailValidation {

    public static boolean isEmail(String email){
        if (email == null) {
            return false;
        }
        String emailPattern = "^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})";
        return email.matches(emailPattern);
    }
}
