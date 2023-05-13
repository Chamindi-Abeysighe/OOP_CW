import java.util.Date;

public class Consultation extends Patient {


    private int cost;
    private String notes;

    private Date Date;
    private int time;

    public Consultation(Doctor Doctor) {

        super();
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }



    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}