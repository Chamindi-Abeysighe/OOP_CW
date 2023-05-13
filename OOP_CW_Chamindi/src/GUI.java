import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.*;
import java.util.Timer;

import static java.lang.Integer.parseInt;
import static java.sql.Time.valueOf;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GUI extends WestminsterSkinConsultationManager implements ActionListener { //to define what should be done when an user performs certain operation

     public static ArrayList<Consultation> consultations = new ArrayList<>();

    public GUI(){
        JFrame user= new JFrame();
        JPanel panel = new JPanel();
        JLabel beau = new JLabel("Beauty");
        JLabel perfection = new JLabel("Perfection");
        JLabel con = new JLabel("Confidence");
        JLabel text = new JLabel("Looks amazing with ");
        JLabel text2 = new JLabel("our wide range of treatments");

        Font font2 =new Font("Arial", Font.BOLD,15);
        JLabel label = new JLabel("LOGIN");
        JLabel name = new JLabel("User Name ");
        JLabel pass= new JLabel("Password");
        JLabel nortification = new JLabel("");



        Font font1 =new Font("Arial", Font.BOLD,20);
        Font font3 =new Font("Forte", Font.BOLD,30);
        Font font4 =new Font("Brush Script MT", Font.BOLD,20);
        Font font5 =new Font("Britannic Bold", Font.BOLD,40);


        JTextArea text1 = new JTextArea();
        JButton login= new JButton("LOGIN");
        JLabel displayField = new JLabel();
        displayField.setSize(440,380);
        Image image = new ImageIcon("skinCare.jpg").getImage();
        Image imageScale = image.getScaledInstance(displayField.getWidth(), displayField.getHeight(), Image.SCALE_SMOOTH);
        displayField.setIcon(new ImageIcon(imageScale));
        displayField.add(beau);
        displayField.add(perfection);
        displayField.add(con);
        displayField.add(text);
        displayField.add(text2);

        panel.add(displayField);




        JPasswordField password = new JPasswordField();

        JFrame frame1 = new JFrame();
        JPanel panel1 = new JPanel();


        JLabel welcome = new JLabel("Welcome to the Skin Consultation Center");
        panel1.add(welcome);



        JButton dList = new JButton("View doctors list");
        JButton sList = new JButton("Sort the Doctors List");
        JButton consult = new JButton("Consultation");
        





        user.setTitle("Skin Consultation Center");
        user.setSize(700,400);
        user.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        user.setVisible(true);
        user.setResizable(false);
        user.setLocationRelativeTo(null);
        user.setLayout(null);

        JMenuBar menu =new JMenuBar();
        JMenu menu1 = new JMenu("User");
        JMenu menu2 = new JMenu("Home");


        JMenuItem menuItem2 = new JMenuItem("My Appointment");

        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                JFrame newFrame = new JFrame();
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Doctor ");
                model.addColumn(" Name");
                model.addColumn("Sur Name");
                model.addColumn("Date of birth");
                model.addColumn("Phone");
                model.addColumn("NIC No");
                model.addColumn("Gender");
                model.addColumn("Date");
                model.addColumn("Start Time");
                model.addColumn("Duration");
                model.addColumn("Cost ");
                model.addColumn("Note ");



                JTable table = new JTable(model);

                JScrollPane scrollPane = new JScrollPane(table);
                table.setEnabled(false);
                //newFrame.add(scrollPane, BorderLayout.CENTER);
                newFrame.setSize(1000, 720);
                newFrame.setVisible(true);
                newFrame.setResizable(false);






                table.setSize(1000,800);
                newFrame.add(scrollPane, BorderLayout.CENTER);
                newFrame.setSize(1000, 720);
                newFrame.setVisible(true);

               // newFrame.add(scrollPane);
                JLabel labell = new JLabel();
                newFrame.add(labell);

                labell.setSize(500,200);



                    File file = new File("Appointment.txt");         // read the data from the file

                try {
                    Scanner data=new Scanner(file);
                    String[] arr=new String[15];
                    int count=0;
                    while(data.hasNextLine()){
                        String line=data.nextLine();

                        if(!line.isEmpty()){
                             arr[count]=line;
                             count++;
                        }else{
                            model.addRow(arr);
                            arr=new String[15];
                            count=0;
                        }
                    }

                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

//


            }
        });




        user.add(panel);
        user.add(login);
        user.add(name);
        user.add(pass);
        user.add(password);
        user.add(text1);
        user.add(label);
        user.add(nortification);



        panel.setSize(250,400);
        panel.setVisible(true);
        panel.setBackground(Color.GREEN);
        panel.setLayout(null);








        label.setBounds(350,0,200,120);
        label.setFont(font5);
        label.setForeground(Color.BLUE);

        nortification.setBounds(350,80,300,120);
        nortification.setForeground(Color.green);
        nortification.setSize(400,50);
        nortification.setFont(font1);


        text.setSize(200,20);
        text.setFont(font2);
        text.setLocation(20,260);
        text.setFont(font4);

        text2.setSize(300,20);
        text2.setFont(font2);
        text2.setLocation(15,290);
        text2.setFont(font4);

        beau.setSize(300,100);
        beau.setFont(font2);
        beau.setLocation(50,50);
        beau.setHorizontalTextPosition(JLabel.CENTER);
        beau.setFont(font3);

        perfection.setSize(300,100);
        perfection.setFont(font3);
        perfection.setLocation(50,100);
        perfection.setHorizontalTextPosition(JLabel.CENTER);

        con.setSize(300,100);
        con.setFont(font3);
        con.setLocation(50,150);
        con.setHorizontalTextPosition(JLabel.CENTER);



        name.setSize(200,20);
        name.setFont(font2);
        name.setLocation(270,150);

        text1.setSize(200,20);
        text1.setLocation(400,150);

        pass.setSize(200,20);
        pass.setFont(font2);
        pass.setLocation(270,210);

        password.getPassword();
        password.setSize(200,20);
        password.setLocation(400,210);



        frame1.setTitle("Skin Consultation Center");
        frame1.setSize(500,600);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setVisible(false);
        frame1.setResizable(false);
        frame1.setLocationRelativeTo(null);
        frame1.setLayout(null);

        frame1.add(dList);
        frame1.add(panel1);
        frame1.add(consult);
        frame1.add(sList);
        frame1.setJMenuBar(menu);
        menu.add(menu2);
        menu.add(menu1);
        menu1.add(menuItem2);




        panel1.setSize(500,100);
        panel1.setVisible(true);
        panel1.setBackground(Color.pink);


        welcome.setLocation(70,35);
        welcome.setFont(font1);

        consult.setSize(200,25);
        consult.setLocation(120,300);
        consult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(true);
                NewConsultation();
            }
        });





        login.setSize(100,25);
        login.setLocation(450,260);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                String use = text1.getText();
                String pas = password.getText();

                if (use.equals("Chamindi")&&pas.equals("chamindi")){                          //set the password into the login frame
                    frame1.setVisible(true);
                    user.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid user name or password");
                }




            }
        });

        dList.setSize(200,25);
        dList.setLocation(120,200);
        dList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewDoctorList();
            }
        });

        sList.setSize(200,25);
        sList.setLocation(120,250);
        sList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                sortList();
            }
        });




    }


    private void sortList() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("First Name");
        model.addColumn("Sur Name");
        model.addColumn("Specialisation");
        model.addColumn("Date of Birth");
        model.addColumn("Mobile Number");
        model.addColumn("Medical License Number");

        Collections.sort(List_Doctor, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor o1, Doctor o2) {
                return o1.getName().compareTo(o2.getName());                         // compare doctor names
            }
        });
        for (Doctor doctor : List_Doctor) {
            model.addRow(new Object[]{doctor.getName(), doctor.getSurName(), doctor.getDateOfBirth(), doctor.getContactNumber(), doctor.getSpecialisation(), doctor.getMedical_Licence_Number()});}

        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);


        JFrame LFrame = new JFrame("Doctor List");
        //newF1.add(table);

        table.setEnabled(false);
        LFrame.add(scrollPane, BorderLayout.CENTER);
        LFrame.setSize(1000, 720);
        LFrame.setVisible(true);


    }


    public void NewConsultation() {


        JPanel panel = new JPanel();



        JFrame frame2 = new JFrame("Add Consultation");
        frame2.setSize(700,200);
        frame2.add(panel);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);




        JComboBox<String> comboBox = new JComboBox<>();

        for (Doctor doctor : List_Doctor) {
            comboBox.addItem(doctor.getName()+" "+doctor.getSurName());       // add doctors to the combobox
        }
        JButton consult = new JButton("Consult");

// create the label
        JLabel label = new JLabel("Please select a Doctor: ");



        panel.add(label);
        panel.add(comboBox);
        panel.add(consult);

        consult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Font font = new Font("Arial", Font.BOLD, 20);


                JFrame newFrame = new JFrame();
                newFrame.setVisible(true);
                newFrame.setSize(1000, 900);
                JPanel jpanel = new JPanel();


                JLabel Name = new JLabel(" Patient's Name");
                JLabel SName = new JLabel("Sur Name");
                JLabel dB = new JLabel("Date of birth ");
                JLabel phone = new JLabel("Phone");
                JLabel nic = new JLabel("NIC No");
                JLabel gender = new JLabel("Gender");
                JLabel sT = new JLabel("Start Time");
                JLabel eT = new JLabel("Time Duration");

                JLabel sDate = new JLabel("Select Date ");

                JLabel notes = new JLabel("Note");
                JLabel form = new JLabel(" Appointment Form");

                JTextField fNameT = new JTextField();
                JTextField sNameT = new JTextField();
                JTextField phoneT = new JTextField();
                JTextField nicT = new JTextField();
                JTextField dBT = new JTextField();

                JTextField mfText = new JTextField();

                JButton dateg = new JButton(" select");


                jpanel.setSize(250, 400);
                jpanel.setVisible(true);
                jpanel.setLayout(null);

                Font newfont = new Font("Britannic Bold", Font.BOLD, 40);

                form.setLocation(150, 15);
                form.setSize(1000, 100);
                form.setFont(newfont);
                form.setAlignmentX(GroupLayout.Alignment.CENTER.ordinal());


                Name.setLocation(25, 115);
                Name.setSize(200, 50);


                fNameT.setLocation(125, 130);
                fNameT.setSize(225, 25);

                SName.setLocation(400, 125);
                SName.setSize(200, 30);
                sNameT.setLocation(500, 130);
                sNameT.setSize(225, 25);

                dB.setLocation(25, 420);
                dB.setSize(200, 30);

                dBT.setLocation(125, 425);
                dBT.setSize(200, 25);


                phone.setLocation(25, 173);
                phone.setSize(200, 30);


                phoneT.setLocation(125, 180);
                phoneT.setSize(225, 25);

                nic.setLocation(25, 230);
                nic.setSize(200, 30);


                nicT.setLocation(125, 230);
                nicT.setSize(225, 25);

                gender.setLocation(25, 265);
                gender.setSize(200, 30);


                mfText.setLocation(125, 265);
                mfText.setSize(225, 25);

                eT.setLocation(525, 370);
                eT.setSize(200, 30);

                JTextArea t2 = new JTextArea();
                t2.setSize(225, 23);
                t2.setLocation(625, 368);





                        sT.setLocation(25,370);
                        sT.setSize(200,30);

                        JTextArea t = new JTextArea();
                        t.setSize(225,23);
                        t.setLocation(125,368);

                        JButton time =new JButton("Select");
                        time.setLocation(380,370);
                        time.setSize(100,25);
                        time.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                DateTimeFormatter time2 =DateTimeFormatter.ofPattern("hh:mm a");
                                LocalDateTime now = LocalDateTime.now();
                                t.setText(time2.format(now));


                            }
                        });

                        sDate.setLocation(25,320);
                        sDate.setSize(200,30);


                        JTextField date = new JTextField();
                        date.setSize(225,25);
                        date.setLocation(125,320);
                        String  dateTime = date.getText();

                        dateg.setSize(100,25);
                        dateg.setText("Select");
                        dateg.setLocation(380,320);

                        dateg.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                DateTimeFormatter Date =DateTimeFormatter.ofPattern("YY-MM-DD");
                                LocalDateTime now = LocalDateTime.now();
                                date.setText(Date.format(now));




                            }
                        });




                        notes.setLocation(25,520);
                        notes.setSize(200,30);



                        JTextArea note = new JTextArea();
                        note.setLocation(120,480);
                        note.setSize(500,150);

                        String Notes = note.getText();



                        JButton submit = new JButton("Submit");
                        submit.setSize(100,30);
                        submit.setLocation(550,650);
                        submit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                int v1 = Integer.parseInt(t2.getText());
                                int j=15;
                                int m=25;
                                int s =v1*j;
                                int y=v1*m;


                                for (int i = 0; i < List_Doctor.size(); i++) {
                                    if (Objects.requireNonNull(comboBox.getSelectedItem()).toString().contains(List_Doctor.get(i).getName())) {

                                        if (consultations.isEmpty()) {
                                            Consultation c1 = new Consultation(List_Doctor.get(i));
                                            c1.setName(fNameT.getText());
                                            c1.setSurName(sNameT.getText());
                                            c1.setDateOfBirth(dBT.getText());
                                            c1.setContactNumber(parseInt(phoneT.getText()));
                                            c1.setGender(mfText.getText());
                                            c1.setCost( s);
                                            c1.setID_No(nicT.getText());
                                            consultations.add(c1);




                                        }else if (!(consultations.isEmpty())){

                                            Consultation c2 = new Consultation(List_Doctor.get(i));
                                            c2.setName(fNameT.getText());
                                            c2.setSurName(sNameT.getText());
                                            c2.setDateOfBirth(dBT.getText());
                                            c2.setContactNumber(parseInt(phoneT.getText()));
                                            c2.setGender(mfText.getText());
                                            c2.setCost( y);
                                            c2.setID_No(nicT.getText());
                                            consultations.add(c2);

                                        }
                                        try {

                                            File fr = new File("Appointment.txt");
                                            FileWriter fw = new FileWriter(fr);

                                            fw.write(comboBox.getSelectedItem().toString() + "\n");
                                            fw.write(fNameT.getText().toString() + "\n");
                                            fw.write(sNameT.getText().toString() + "\n");
                                            fw.write(dBT.getText().toString() + "\n");
                                            fw.write(phoneT.getText().toString() + "\n");
                                            fw.write(nicT.getText().toString() + "\n");
                                            fw.write(mfText.getText().toString() + "\n");
                                            fw.write(date.getText().toString() + "\n");
                                            fw.write(t.getText().toString() + "\n");
                                            fw.write(t2.getText().toString() + "\n");
                                            fw.write(s + "\n");
                                            fw.write(note.getText().toString() + "\n");
                                            fw.write("\n");


                                            fw.close();

                                            JOptionPane.showMessageDialog(null, "Consultation Added with Doctor " + List_Doctor.get(i).getName() + " " + List_Doctor.get(i).getSurName() + " on " + date.getText() + "at" + t.getText(), "Success", JOptionPane.INFORMATION_MESSAGE);

                                        } catch (IOException ex) {
                                            throw new RuntimeException(ex);
                                        }
                                        break;
                                    }
                                    else {

                                            Random random = new Random();
                                            ArrayList<Doctor> excludedDoctorList = (ArrayList<Doctor>) List_Doctor.clone();
                                            excludedDoctorList.remove(i);
                                                int index = random.nextInt(excludedDoctorList.size());
                                                Doctor newDoctor = excludedDoctorList.get(index);
                                                JOptionPane.showMessageDialog(null, "Doctor" + List_Doctor.get(i).getName() + "is not available at that time, consultation will be scheduled with Doctor " + newDoctor.getName(), "Alert", JOptionPane.INFORMATION_MESSAGE);
                                                Consultation c3 = new Consultation(newDoctor);
                                                c3.setName(fNameT.getText());
                                                c3.setSurName(sNameT.getText());
                                                c3.setDateOfBirth(dBT.getText());
                                                c3.setContactNumber(parseInt(phoneT.getText()));
                                                c3.setGender(mfText.getText());
                                                c3.setCost( y);
                                                c3.setID_No(nicT.getText());
                                                consultations.add(c3);

                                        try {

                                            File fr = new File("Appointment.txt");
                                            FileWriter fw = new FileWriter(fr);

                                            fw.write(newDoctor.getName().toString() + "\n");
                                            fw.write(fNameT.getText().toString() + "\n");
                                            fw.write(sNameT.getText().toString() + "\n");
                                            fw.write(dBT.getText().toString() + "\n");
                                            fw.write(phoneT.getText().toString() + "\n");
                                            fw.write(nicT.getText().toString() + "\n");
                                            fw.write(mfText.getText().toString() + "\n");
                                            fw.write(date.getText().toString() + "\n");
                                            fw.write(t.getText().toString() + "\n");
                                            fw.write(t2.getText().toString() + "\n");
                                            fw.write(y + "\n");
                                            fw.write(note.getText().toString() + "\n");
                                            fw.write("\n");


                                            fw.close();


                                        } catch (IOException ex) {
                                            throw new RuntimeException(ex);
                                        }


                                    }
                                    break;
                                }
                                }

                        });


                        newFrame.add(jpanel);
                        jpanel.add(form);
                        jpanel.add(Name);
                        jpanel.add( SName);
                        jpanel.add(phone);
                        jpanel.add(nic);
                        jpanel.add(gender);
                        jpanel.add(sT);
                        jpanel.add(sDate);
                        jpanel.add(notes);
                        jpanel.add(t);
                        jpanel.add(time);
                        jpanel.add(submit);

                        jpanel.add(fNameT);
                        jpanel.add(sNameT);
                        jpanel.add(phoneT);
                        jpanel.add(nicT);
                        jpanel.add(dateg);
                        jpanel.add(date);
                        jpanel.add(dBT);
                        jpanel.add(dB);
                        jpanel.add(eT);
                        jpanel.add(t2);


                        jpanel.add(mfText);
                        jpanel.add(note);


                    }
                });











    }



    public void ViewDoctorList() {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Specialisation");
        model.addColumn("Date of Birth ");
        model.addColumn("Contact Number");
        model.addColumn("Medical License Number");

        for (Doctor doctor : List_Doctor) {
           model.addRow(new Object[]{doctor.getName(), doctor.getSurName(),doctor.getDateOfBirth(), doctor.getContactNumber(), doctor.getSpecialisation() , doctor.getMedical_Licence_Number()});}

        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);


        JFrame LFrame = new JFrame("Doctor List");


        //newF1.add(table);

        table.setEnabled(false);
        LFrame.add(scrollPane, BorderLayout.CENTER);
        LFrame.setSize(1000, 720);
        LFrame.setVisible(true);


    }







    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
