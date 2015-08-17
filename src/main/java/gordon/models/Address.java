package gordon.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by gordon on 2015/8/15.
 */
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String street;

    @NotNull
    private String country;

    @NotNull
    private String city;

    @ManyToOne
    private Person person;

    public Address(long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public Address(String country, String city, String street) {
        this.street = street;
        this.country = country;
        this.city = city;
    }

    public Address() {
    }
}
