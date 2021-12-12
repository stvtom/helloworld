package springXml;

public class AnimalService {

    public String userName;

    private AnimalAgeService animalAgeService;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public AnimalAgeService getAnimalAgeService() {
        return animalAgeService;
    }

    public void setAnimalAgeService(AnimalAgeService animalAgeService) {
        this.animalAgeService = animalAgeService;
    }

    public String sing(String name){
        animalAgeService.sing(name);
        System.err.println("AnimalService"+ name);
        return name;
    }
}
