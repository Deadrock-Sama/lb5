package lb.pro3ect.lb5.data.entities;

import java.util.Objects;

public class Location {

    public Location(int x, Long y, Float z, String name) {
        this.x = x;
        this.y = Objects.requireNonNull(y, "y must not be null");
        this.z = Objects.requireNonNull(z, "z must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");

        if (name.length() >= 966)
            throw new IllegalArgumentException("Name can't be longer than 966 chars");


    }

    private int x;
    private Long y;
    private Float z;
    private String name;

}