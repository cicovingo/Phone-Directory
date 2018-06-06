import javax.swing.*;

public class Main {
    public static void main(String args[]) {
        String phoneDirectoryName = JOptionPane.showInputDialog("Enter Phone Directory Name, for example myPhoneDirectory :", null);
        PhoneDirectory phoneDirectory = new PhoneDirectory(phoneDirectoryName);
        String name = null, surname = null;
        char gender = 0;
        long birthdate = 0;
        int phoneNumber = 0;
        TakingInformations takingInformations = new TakingInformations();
        takingInformations.phoneList(phoneDirectory,name,surname,gender,phoneNumber,birthdate);
    }
}
