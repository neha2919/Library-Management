import java.util.List;
import java.util.ArrayList;

public class Register {

    private final String admin = "Ashar581";
    private final String pass = "library";
    List<Patient> patients = new ArrayList<>();

    Patient loggedInPatient;

    public List<Patient> getPatients(){
        return patients;
    }

    void addPatient(Patient patient){
        this.patients.add(patient);
    }

    boolean logIn(String user, String password){
        for(Patient patient : patients){
            if(user.equalsIgnoreCase(patient.getUser()) && password.equals(patient.getPass())){
                loggedInPatient = patient;
                return true;
            }
        }
        return false;
    }

    boolean adminLogIn(String user,String pass){
        if(user.equalsIgnoreCase(admin) && pass.equals(this.pass) ){
            return true;
        }
        return false;
    }

    String loggedName(){
        return loggedInPatient.getName();
    }

    String loggedUserID(){
        return loggedInPatient.getUser();
    }

}
