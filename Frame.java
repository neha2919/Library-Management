import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class Frame {

    Register register = new Register();

    JFrame jf;

    String n,a,g,u,p;

    void setJf(String JFrame, int len, int breadth){

        jf = new JFrame(JFrame);
        jf.setSize(len,breadth);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);

    }

    Frame(){

        homepage();
    }

    private void homepage(){
        setJf("Welcome To The Portal",550,550);

        JButton admin,signup,login,exit;


        JLabel home = new JLabel("Home Page");
        home.setFont(new Font("Arial",Font.BOLD,30));
        home.setBounds(200,10,350,80);

        admin = new JButton("Admin Login");
        admin.setBounds(130,90,90,20);
        jf.add(admin);

        signup = new JButton("Sign Up");
        signup.setBounds(230,90,90,20);
        jf.add(signup);

        login = new JButton("Log In");
        login.setBounds(330,90,90,20);
        jf.add(login);


        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==signup){
                    jf.dispose();
                    registerPage();
                }
            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==login){
                    jf.dispose();
                    logInPage();
                }
            }
        });

        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ){
                jf.dispose();
                adminLogInPage();
            }
        });

        exit = new JButton("Exit");
        exit.setBounds(240,200,70,20);
        jf.add(exit);

        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==exit){
                    System.exit(0);
                }
            }
        });

        jf.add(home);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    Patient addDetails(){
           Patient patient = new Patient(n,a,g,u,p);
            if(n.isEmpty()){
                return null;
            }
           return patient;
    }

    private void registerPage(){
        setJf("Registration Portal",400,400);

        JButton b,back;

        JTextField t1,t2,t3,t4;
        JPasswordField passwordField;

        JLabel name,age,gender,user,pass;

        name=new JLabel("Name: ");
        name.setBounds(30,70,100,20);
        t1 = new JTextField();
        t1.setBounds(100,70,150,20);
        jf.add(name);
        jf.add(t1);

        age = new JLabel("Age: ");
        age.setBounds(30,100,100,20);
        t2 = new JTextField();
        t2.setBounds(100,100,150,20);
        jf.add(age);
        jf.add(t2);

        gender = new JLabel("Gender: ");
        gender.setBounds(30,130,100,20);
        t3 = new JTextField();
        t3.setBounds(100,130,150,20);
        jf.add(gender);
        jf.add(t3);

        user = new JLabel("User ID: ");
        user.setBounds(30,160,100,20);
        t4 = new JTextField();
        t4.setBounds(100,160,150,20);
        jf.add(user);
        jf.add(t4);

        pass = new JLabel("Password: ");
        pass.setBounds(30,190,100,20);
        passwordField = new JPasswordField();
        passwordField.setBounds(100,190,150,20);
        jf.add(pass);
        jf.add(passwordField);


        b = new JButton("Submit");
        b.setBounds(135,220,70,20);
        jf.add(b);

        back = new JButton("Back");
        back.setBounds(135,250,70,20);
        jf.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==back){
                    jf.dispose();
                    homepage();
                }
            }
        });

        jf.setVisible(true);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!checkUserID(t4.getText())){

                if (e.getSource() == b && (!t1.getText().isEmpty()) && (!t2.getText().isEmpty()) && (!t4.getText().isEmpty()) && (!passwordField.getText().isEmpty())) {
                    n = t1.getText();
                    a = t2.getText();
                    g = t3.getText();
                    u = t4.getText();
                    p = passwordField.getText();
                    register.addPatient(addDetails());
                    jf.dispose();
                    homepage();
                    JOptionPane.showMessageDialog(null, "Registration Completed!");
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields!");
                }
            }else{
                    JOptionPane.showMessageDialog(null,"User ID Already Taken! Please try again!");
                }
        }
        });
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    boolean checkUserID(String userID){
        for(Patient patient : register.getPatients()){
            if(patient.getUser().equalsIgnoreCase(userID)){
                return true;
            }
        }
        return false;
    }

    private void logInPage(){

        setJf("Log In",300,300);

        JLabel user,pass;
        JButton button,back;

        user = new JLabel("User ID: ");
        user.setBounds(15,80,70,20);
        jf.add(user);

        pass = new JLabel("Password: ");
        pass.setBounds(15,120,70,20);
        jf.add(pass);

        JTextField t1 = new JTextField();
        t1.setBounds(80,80,130,20);
        jf.add(t1);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(80,120,130,20);
        jf.add(passwordField);

        button = new JButton("Log In");
        button.setBounds(120,150,50,20);
        jf.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button){
                    if(register.logIn(t1.getText(), passwordField.getText())){
                        jf.dispose();
                        openLoggedIn();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Please Enter Correct ID/Password!");
                    }
                }
            }
        });


        back = new JButton("Back");
        back.setBounds(120,180,50,20);
        jf.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==back){
                    jf.dispose();
                    homepage();
                }
            }
        });

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void openLoggedIn(){

        setJf("Welcome "+register.loggedInPatient.getName()+" !",600,600);

        JLabel jLabel = new JLabel("Welcome to your Profile! ");
        jLabel.setBounds(120,20,400,50);
        jLabel.setFont(new Font("Times New Roman",Font.PLAIN,30));
        jf.add(jLabel);


        JLabel name = new JLabel("Name: "+register.loggedName());
        name.setBounds(20,70,200,20);
        jf.add(name);

        JLabel id = new JLabel("User ID: "+register.loggedUserID());
        id.setBounds(20,100,200,20);
        jf.add(id);

        JLabel status = new JLabel("Status:");
        status.setBounds(20,130,120,20);
        jf.add(status);

        JLabel online = new JLabel("Online");
        online.setBounds(65,130,120,20);
        online.setForeground(Color.green.darker());
        jf.add(online);

        JButton signout = new JButton("Sign Out");
        signout.setBounds(250,450,80,15);
        jf.add(signout);


        signout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==signout){
                    jf.dispose();
                    homepage();
                    JOptionPane.showMessageDialog(null,"You have been signed out");
                }
            }
        });

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    private void adminLogInPage(){

        setJf("Log In",300,300);

        JLabel user,pass;
        JButton button,back;

        user = new JLabel("User ID: ");
        user.setBounds(15,80,70,20);
        jf.add(user);

        pass = new JLabel("Password: ");
        pass.setBounds(15,120,70,20);
        jf.add(pass);

        JTextField t1 = new JTextField();
        t1.setBounds(80,80,130,20);
        jf.add(t1);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(80,120,130,20);
        jf.add(passwordField);

        button = new JButton("Log In");
        button.setBounds(120,150,50,20);
        jf.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button){
                    if(register.adminLogIn(t1.getText(), passwordField.getText())){
                        jf.dispose();
                        adminPage();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Please Enter Correct ID/Password!");
                    }
                }
            }
        });


        back = new JButton("Back");
        back.setBounds(120,180,50,20);
        jf.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==back){
                    jf.dispose();
                    homepage();
                }
            }
        });

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void adminPage(){
        setJf("Admin Access Page",600,600);

        JButton signout = new JButton("Sign Out");
        signout.setBounds(250,450,80,15);
        jf.add(signout);

        signout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==signout){
                    jf.dispose();
                    homepage();
                    JOptionPane.showMessageDialog(null,"Your Have Signed Out Successfully!");
                }
            }
        });

        JLabel label = new JLabel("Welcome To Admin Panel!");
        label.setBounds(110,10,400,50);
        label.setFont(new Font("Arial",Font.BOLD,30));
        jf.add(label);

        JButton check = new JButton("Register List");
        check.setBounds(40,80,100,20);
        jf.add(check);

        JPanel jp = new JPanel();
        jp.setLayout(null);

//        JButton clear = new JButton("Clear");
//        clear.setBounds(120,280,45,15);
//        jp.add(clear);
//        check.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                if(e.getSource()==check){
//                    jf.remove(jp);
//                }
//            }
//        });

        check.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed( ActionEvent e ) {
                if( e.getSource()==check){

                    JScrollPane sp;

                    JTable listTableModel;

                    String data[][]=new String[register.getPatients().size()][3];
                    String column[]={"Name","User ID","Gender"};
                    listTableModel = new JTable(data,column);

                    for(int i=0;i<register.getPatients().size();i++){
                        data[i][0]=register.getPatients().get(i).getName();
                        data[i][1]=register.getPatients().get(i).getUser();
                        data[i][2]=register.getPatients().get(i).getGender();
                    }
                    listTableModel = new JTable(data,column);


                    sp = new JScrollPane(listTableModel);
                    sp.setBounds(10,20,280,250);
                    jp.add(sp);

                }
            }
        });


        jp.setBounds(140,120,300,300);
        jp.setBackground(Color.DARK_GRAY.brighter());
        jf.add(jp);


        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
