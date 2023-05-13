import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface SkinConsultationManager {

    ArrayList<Doctor> List_Doctor = new ArrayList<>();

    void addNewDoctor();
    void deleteADoctor();
    void printDoctors();
    void saveToFile() throws IOException;


}

