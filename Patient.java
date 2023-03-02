public class Patient {
    String name,age,gender,user,pass;
    Patient(String name, String age, String gender, String user, String pass){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.user = user;
        this.pass = pass;
    }

    String getName(){
        return name;
    }

    String getAge(){
        return age;
    }

    String getGender(){
        return gender;
    }

    String getUser(){
        return user;
    }

    String getPass(){
        return pass;
    }
}
