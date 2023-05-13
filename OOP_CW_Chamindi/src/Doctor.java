import java.io.Serializable;

public class Doctor extends Person implements Comparable<Doctor>, Serializable {

    private int medical_Licence_Number;
    private String specialisation;

    public int getMedical_Licence_Number() {

        return medical_Licence_Number;
    }

    public void setMedical_Licence_Number(int medical_Licence_Number) {
        this.medical_Licence_Number = medical_Licence_Number;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    @Override
    public int compareTo(Doctor o) {
        int result = this.getSurName().compareTo(o.getSurName());
        return Integer.compare(result, 0);
    }
}
