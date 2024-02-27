package lb.pro3ect.lb5.data.entities;

import java.util.Objects;
import java.util.UUID;

public class Person implements Comparable<Person> {

    public Person(java.time.ZonedDateTime birthday, Double height, Location location, String passportID) {

        this.birthday = Objects.requireNonNull(birthday, "birthday must not be null");
        this.height = Objects.requireNonNull(height, "height must not be null");
        this.location = Objects.requireNonNull(location, "location must not be null");
        this.passportID = Objects.requireNonNull(passportID, "passportID must not be null");

        if (height.compareTo(0.0) <= 0)
            throw new IllegalArgumentException("height can't be <= 0");

        if (passportID.length() > 46)
            throw new IllegalArgumentException("passportID length can't be >46");

        this.passportID = UUID.randomUUID().toString();
    }


    @Override
    public int compareTo(Person o) {
        return birthday.compareTo(o.birthday);
    }

    @Override
    public String toString() {
        return "Person{" +
                "birthday=" + birthday +
                ", height=" + height +
                ", passportID='" + passportID + '\'' +
                ", location=" + location +
                '}';
    }

    private java.time.ZonedDateTime birthday;
    private Double height;
    private String passportID;
    private Location location;


}