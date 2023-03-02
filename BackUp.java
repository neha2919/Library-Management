import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackUp {

    JFrame jf = new JFrame("Register Portal");

    String n,a,g,u,p;

    JButton b;

    boolean flag = false;
    JTextField t1,t2,t3,t4;
    JPasswordField passwordField;

    JLabel name,age,gender,user,pass;

    void frame(){
        name=new JLabel("Name: ");
        name.setBounds(30,135,100,20);
        t1 = new JTextField();
        t1.setBounds(100,135,150,20);
        jf.add(name);
        jf.add(t1);

        age = new JLabel("Age: ");
        age.setBounds(30,170,100,20);
        t2 = new JTextField();
        t2.setBounds(100,170,150,20);
        jf.add(age);
        jf.add(t2);

        gender = new JLabel("Gender: ");
        gender.setBounds(30,205,100,20);
        t3 = new JTextField();
        t3.setBounds(100,205,150,20);
        jf.add(gender);
        jf.add(t3);

        user = new JLabel("User ID: ");
        user.setBounds(30,240,100,20);
        t4 = new JTextField();
        t4.setBounds(100,240,150,20);
        jf.add(user);
        jf.add(t4);

        pass = new JLabel("Password: ");
        pass.setBounds(30,275,100,20);
        passwordField = new JPasswordField();
        passwordField.setBounds(100,275,150,20);
        jf.add(pass);
        jf.add(passwordField);
    }

    void button(){
        b = new JButton("Submit");
        b.setBounds(135,310,70,20);
        jf.add(b);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==b){
                }
            }
        });
    }


}

//    int flag=0;
//    String n,a,g,u,p;
//    JFrame jf = new JFrame("Register Portal");
//
//    JButton b;
//    JTextField t1,t2,t3,t4;
//    JPasswordField passwordField;
//
//    JLabel name,age,gender,user,pass;
//
//    Frame(){
//        name=new JLabel("Name: ");
//        name.setBounds(30,135,100,20);
//        t1 = new JTextField();
//        t1.setBounds(100,135,150,20);
//        jf.add(name);
//        jf.add(t1);
//
//        age = new JLabel("Age: ");
//        age.setBounds(30,170,100,20);
//        t2 = new JTextField();
//        t2.setBounds(100,170,150,20);
//        jf.add(age);
//        jf.add(t2);
//
//        gender = new JLabel("Gender: ");
//        gender.setBounds(30,205,100,20);
//        t3 = new JTextField();
//        t3.setBounds(100,205,150,20);
//        jf.add(gender);
//        jf.add(t3);
//
//        user = new JLabel("User ID: ");
//        user.setBounds(30,240,100,20);
//        t4 = new JTextField();
//        t4.setBounds(100,240,150,20);
//        jf.add(user);
//        jf.add(t4);
//
//        pass = new JLabel("Password: ");
//        pass.setBounds(30,275,100,20);
//        passwordField = new JPasswordField();
//        passwordField.setBounds(100,275,150,20);
//        jf.add(pass);
//        jf.add(passwordField);
//
//        b = new JButton("Submit");
//        b.setBounds(135,310,70,20);
//        jf.add(b);
//
//        jf.setSize(500,500);
//        jf.setLayout(null);
//        jf.setVisible(true);
//
//        b.addActionListener(new ActionListener(){
//        public void actionPerformed(ActionEvent e){
//            if(e.getSource()==b){
//                n = t1.getText();
//                a = t2.getText();
//                g = t3.getText();
//                u = t4.getText();
//                p = t4.getText();
//                Patient patient = new Patient(n,a,g,u,p);
//                Register register = new Register();
//                register.addPatient(patient);
//                jf.dispose();
//            }
//        }
//        });
//    }
//
//}

