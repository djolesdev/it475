package entity;

public class Korisnik {

    private String name, surname, JMBG;

    public Korisnik(String name, String surname, String JMBG) {
        this.name = name;
        this.surname = surname;
        this.JMBG = JMBG;
    }

//    public upisiUBlockchain()

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", JMBG='" + JMBG + '\'' +
                '}';
    }
}
