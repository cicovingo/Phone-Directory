
public class PhoneDirectory {
    private String phoneDirectoryName;
    private Record[] recordList = new Record[150];
    private int numberOfrecord;

    public PhoneDirectory(String phoneDirectoryName) {
        this.phoneDirectoryName = phoneDirectoryName;
    }

    public PhoneDirectory(String phoneDirectoryName, Record[] recordList) {
        this.phoneDirectoryName = phoneDirectoryName;
        this.recordList = recordList;
    }

    public String getPhoneDirectoryName() {
        return phoneDirectoryName;
    }

    public void setPhoneDirectoryName(String phoneDirectoryName) {
        this.phoneDirectoryName = phoneDirectoryName;
    }

    public Record[] getRecordList() {
        return recordList;
    }

    public void setRecordList(Record[] recordList) {
        this.recordList = recordList;
    }

    public boolean addRecord(People people, int recordId) {
        boolean a = false;
        for (int i = 0; i < numberOfrecord; i++) {
            if (recordList[i].getPeople() == people) {
                a = false;
            }
        }
        if (!a) {
            Record record = new Record(recordId, people);
            recordList[numberOfrecord] = record;
            numberOfrecord++;
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteRecordWithPhoneNumber(int phoneNumber) {
        boolean a = false;
        int k = 0;
        for (int i = 0; i <= numberOfrecord; i++) {
            if (recordList[i] != null) {
                if (recordList[i].getPeople().getPhoneNumber() == phoneNumber) {
                    a = true;
                    k = i;
                }
            }
        }
        if (a == true) {
            for (int h = k; h <= numberOfrecord; h++) {
                recordList[h] = recordList[h + 1];
            }
            numberOfrecord--;
            return true;
        } else {
            return false;
        }
    }

    public void printList() {
        System.out.println("All phone list is following : ");
        for (int i = 0; i < recordList.length; i++) {
            if (recordList[i] == null)
                break;
            System.out.println(recordList[i].getPeople().getName().concat(" ").concat(recordList[i].getPeople().getSurname().concat(" ").concat(String.valueOf(recordList[i].getPeople().getPhoneNumber()))));
        }
    }

    public void printList(int phoneNumber) {
        System.out.println("Name and Surname for this phoneNumber : ");
        for (int i = 0; i < recordList.length; i++) {
            if (recordList[i] == null)
                break;
            if (recordList[i].getPeople().getPhoneNumber() == phoneNumber)
                System.out.println(recordList[i].getPeople().getName().concat(" ").concat(recordList[i].getPeople().getSurname()).concat(" ").concat(String.valueOf(recordList[i].getPeople().getPhoneNumber())));
        }
    }

    @Override
    public String toString() {
        StringBuilder result[] = new StringBuilder[150];
        for (int i = 0; i < numberOfrecord; i++) {
            if (recordList[i] == null)
                break;
            String NEW_LINE = System.getProperty("line.separator");

            result[i].append(this.getClass().getName() + " People {" + NEW_LINE);
            result[i].append(" Name: " + recordList[i].getPeople().getName() + NEW_LINE);
            result[i].append(" Surname: " + recordList[i].getPeople().getSurname() + NEW_LINE);
            result[i].append(" Gender: " + recordList[i].getPeople().getGender() + NEW_LINE);
            result[i].append(" Phone Number: " + recordList[i].getPeople().getPhoneNumber() + NEW_LINE);
            result[i].append("}");
        }
        return result.toString();

    }
}
