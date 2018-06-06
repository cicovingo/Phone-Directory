import javax.swing.*;
import java.util.Date;

public class TakingInformations {
    int select;
    int recordId = 1;
    boolean temp;
    public void phoneList(PhoneDirectory phoneDirectory,String name,String surname,char gender,int phoneNumber,long birthdate){
        while (true) {
            select = Integer.parseInt(JOptionPane.showInputDialog("Enter Selection,for adding 1,for deleting 2,for printList 3,for printing information 4,for exit 5:", null));
            if (select == 1) {
                name = JOptionPane.showInputDialog("Enter Name for new people on record :", null);
                surname = JOptionPane.showInputDialog("Enter Surname for new people on record :", null);
                birthdate = Date.parse(JOptionPane.showInputDialog("Enter birthdate for new people on record, for example 23/10/1991 :", null));
                phoneNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter Phone Number, for example 02124566565 :", null));
                gender = JOptionPane.showInputDialog("Enter m or f for gender, for example m :", null).charAt(0);
                People people = new People(name, surname, birthdate, phoneNumber,gender);
                temp = phoneDirectory.addRecord(people, recordId);
                if (temp == false) {
                    JOptionPane.showMessageDialog(null, "This Number Already Exist", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "This People added Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    System.out.print(name +" ");
                    System.out.print(surname +" ");
                    System.out.print(birthdate + " ");
                    System.out.print(phoneNumber + " ");
                    System.out.print(gender);
                    System.out.println(" added");
                    recordId++;
                }
            } else if (select == 2) {
                phoneNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter Phone Number For deleting, for example 02124566565 :", null));
                temp = phoneDirectory.deleteRecordWithPhoneNumber(phoneNumber);
                if (temp == false) {
                    JOptionPane.showMessageDialog(null, "This People is not found", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "This People deleted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    System.out.print(phoneNumber);
                    System.out.println(" phone deleted");
                }
            } else if (select == 3){
                phoneDirectory.printList();
            } else if (select == 4){
                phoneNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter Phone Number For printing information, for example 02124566565 :", null));
                phoneDirectory.printList(phoneNumber);
            } else if(select == 5){
                System.exit(0);
            }else {
                JOptionPane.showMessageDialog(null, "Not Valid Selection", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
