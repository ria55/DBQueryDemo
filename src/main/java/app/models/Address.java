package app.models;

public class Address {

    private long id;
    private User user;
    private int zip;
    private String country;
    private String city;
    private String address;

    public Address() {}

    public Address(int zip, String country, String city, String address) {
        this.zip = zip;
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public Address(User user, int zip, String country, String city, String address) {
        this.user = user;
        this.zip = zip;
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
