package app.models;

import java.util.List;

public class User {

    private long id;
    private String firstname;
    private String lastname;
    private Gender gender;

    private List<Address> addresses;

    public User() {}

    public User(long id, String firstname, String lastname, String gender) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = Gender.findGender(gender);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
