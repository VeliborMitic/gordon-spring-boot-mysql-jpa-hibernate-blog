package gordon.models.one_to_many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gordon on 2015/8/15.
 */
@Entity
@Table(name = "people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @NotNull
    private String name;

//    @NotNull
    private int age;

    public Person(String name, int age, List<Address> addresses) {
        this.name = name;
        this.age = age;
        this.addresses = addresses;
    }

    public Person(long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Address> addresses;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        if (address == null) return;
        if (this.addresses == null) {
            addresses = new ArrayList<>();
        }
        address.setPerson(this);
        addresses.add(address);
    }

    public Person() {
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
