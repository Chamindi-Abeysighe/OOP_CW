import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    public static void main(String[] args) throws IOException {
        WestminsterSkinConsultationManager object = new WestminsterSkinConsultationManager();
        boolean user_option = true;
        while (user_option) {
            try {
                System.out.println();
                System.out.println("-----Welcome to the Consultation System !-----");
                System.out.println();
                System.out.println("\n\nPlease enter the relevant number below as per your requirement\n");
                System.out.println("1: Add a New Doctor");
                System.out.println("2: Delete a Doctor ");
                System.out.println("3: Print the list of doctors");
                System.out.println("4: Save the doctor details in a File");
                System.out.println("5: Open the System Graphical User Interface");
                System.out.println("6: Exit the System\n");
                System.out.println();

                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter your choice: ");
                int selectedOption = scanner.nextInt();
                switch (selectedOption) {
                    case 1 -> object.addNewDoctor();
                    case 2 -> object.deleteADoctor();
                    case 3 -> object.printDoctors();
                    case 4 -> object.saveToFile();
                    case 5 -> new GUI();
                    case 6 -> user_option = false ;
                    default -> System.out.println("Invalid Choice, Please try again");

                }
            } catch (Exception e) {
                System.out.println("Please enter a valid input");
            }
        }
    }

    @Override
    public void addNewDoctor() {
        System.out.println("---------------------------------------------------");
        boolean userOption = true;
        while (userOption) {
            if (List_Doctor.size() <= 10) {
                Doctor doctor = new Doctor();
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Please enter the Doctor's First Name: ");
                String FirstName = scan1.nextLine();
                doctor.setName(FirstName);
                System.out.println("Please enter Doctor's Sur Name: ");
                String SurName = scan1.nextLine();
                doctor.setSurName(SurName);
                System.out.println("Please enter Doctor's Date of Birth: ");
                String DateOfBirth = scan1.nextLine();
                doctor.setDateOfBirth(DateOfBirth);
                System.out.println("Please enter Doctor's Mobile Number: ");
                int ContactNumber = scan1.nextInt();
                doctor.setContactNumber(ContactNumber);
                System.out.println("Please enter Doctor's Specialisation: ");
                scan1.nextLine();
                String specialisation = scan1.nextLine();
                doctor.setSpecialisation(specialisation);
                System.out.println("Please enter Doctor's Medical Licence Number: ");
                int MLicenceNumber = scan1.nextInt();
                doctor.setMedical_Licence_Number(MLicenceNumber);
                System.out.println("\nPlease confirm below Doctor details to add :\n ");
                System.out.println("First Name: " + FirstName);
                System.out.println("Surname: " + SurName);
                System.out.println("Date of Birth:"+ DateOfBirth);
                System.out.println("Mobile Number: " + ContactNumber);
                System.out.println("Specialisation: " + specialisation);
                System.out.println("Medical License Number: " + MLicenceNumber);
                System.out.println();
                System.out.println("\nPlease enter Yes to confirm and No to re-enter the details");
                scan1.nextLine();
                String confirm = scan1.nextLine();
                if (confirm.equalsIgnoreCase("Yes")) {
                    List_Doctor.add(doctor);
                    System.out.println("Doctor has been added to the System successfully");
                } else if (confirm.equalsIgnoreCase("No")) {
                    continue;
                }
                Scanner s3 = new Scanner(System.in);
                System.out.print("\nDo you want to add another Doctor ? ( Yes / No ): ");
                String userInput = s3.nextLine();
                if (userInput.equalsIgnoreCase("Yes")) {
                    userOption = true;
                } else if (userInput.equalsIgnoreCase("No")) {
                    userOption = false;
                } else {
                    System.out.println("Invalid Choice");
                    break;
                }
            }
            else {
                System.out.println("The doctor list if full.");
                break;
            }

        }
    }

    @Override
    public void deleteADoctor() {
        System.out.println("---------------------------------------------------");
        System.out.println("Please enter the Doctor's Medical License Number: ");
        Scanner scan4 = new Scanner(System.in);
        int MLicenseNumber;
        MLicenseNumber = scan4.nextInt();
        for (int a = 0; a <= List_Doctor.size(); a++) {
            if (List_Doctor.get(a).getMedical_Licence_Number() == MLicenseNumber) {
                String nameOfRemoval = List_Doctor.get(a).getName();
                System.out.println("Do you want to delete doctor " + nameOfRemoval + " from the List ? (Yes/No)");
                scan4.nextLine();
                String confirmation = scan4.nextLine();
                if (confirmation.equalsIgnoreCase("yes")) {
                    System.out.println("Below doctor is removed from the list: ");
                    System.out.println("Doctor's Name: " + List_Doctor.get(a).getName());
                    System.out.println("Doctor's Last Name: " + List_Doctor.get(a).getSurName());
                    System.out.println("Doctor's Date of Birth: " + List_Doctor.get(a).getDateOfBirth());
                    System.out.println("Doctor's Mobile Number: " + List_Doctor.get(a).getContactNumber());
                    System.out.println("Doctor's Specialisation: " + List_Doctor.get(a).getSpecialisation());
                    System.out.println("Doctor's Medical License Number: " + List_Doctor.get(a).getMedical_Licence_Number());
                    List_Doctor.remove(a);
                    System.out.println();
                    System.out.println("\nDoctor deleted successfully");
                    System.out.println("Total Number of Doctors in the Centre: " + List_Doctor.size());
                    break;
                } else if (confirmation.equalsIgnoreCase("no")) {
                    break;
                } else {
                    System.out.println("Please enter a valid input");
                }
            } else {
                System.out.println("Unable to find a doctor with the mentioned Medical License Number in the List");
                break;
            }
        }

    }

    @Override
    public void printDoctors() {
        System.out.println("---------------------------------------------------");
        if (List_Doctor.isEmpty()){
            System.out.println("Doctor list is empty");
            System.out.println();
        }
        else {
            for (int i=0;i<10;i++){
                Doctor doctor = List_Doctor.get(i);
                System.out.println("Doctor's name :  "+List_Doctor.get(i).getName());
                System.out.println("Doctor's Surname :  "+List_Doctor.get(i).getSurName());
                System.out.println("Doctor's Date of Birth :  "+List_Doctor.get(i).getDateOfBirth());
                System.out.println("Doctor's Contact number : " +List_Doctor.get(i).getContactNumber());
                System.out.println("Doctor's Specialisation : "+List_Doctor.get(i).getSpecialisation());
                System.out.println("Doctor's Medical License Number : "+List_Doctor.get(i).getMedical_Licence_Number());
                System.out.println("-------------------------------------------------------------------------------");

            }
        }



    }

    @Override
    public void saveToFile() throws IOException {
        System.out.println("---------------------------------------------------");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("System.txt"))) {
            for (Doctor doctor : List_Doctor) {
                out.writeObject(doctor);
                System.out.println("You have successfully saved the Doctors file");
                System.out.println("You can see the saved details below");

                System.out.println( "Name : "+doctor.getName()+"\n"+"Last name : "+
                        doctor.getSurName()+"\n"+"Date of birth : "+doctor.getDateOfBirth()+"\n"+"Contact Number : "+doctor.getContactNumber()+
                        "\n"+"Specialisation : "+doctor.getSpecialisation()+"\n"+"Medical Licence Number : "+doctor.getMedical_Licence_Number()+"\n"+
                        "\n\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}