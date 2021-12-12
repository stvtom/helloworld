package springXml;

public class AnimalAgeService {

    public String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public  String sing(String name){
        System.err.println("AnimalAgeService"+name);
        return name;
    }
}
