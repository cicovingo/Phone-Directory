
public class Record {
    private int recordId;
    private People people;

    public Record(int recordId, People people) {
        this.recordId = recordId;
        this.people = people;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

}
