package lb.pro3ect.lb5.data.builders;

import lb.pro3ect.lb5.ui.UIController;
import lb.pro3ect.lb5.data.entities.Location;

public class LocationBuilder extends Builder {

    public LocationBuilder(UIController controller) {
        super(controller);
    }

    public LocationBuilder setRequiredFields() {

        setName();
        setX();
        setY();
        setZ();

        validateBuilder();

        return this;

    }

    public Location build() {

        if (isVaild())
            return new Location(x, y, z, name);

        controller.show("Значения " + this + " недопустимы");
        return null;

    }

    @Override
    public String toString() {

        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", name='" + name + '\'' +
                '}';

    }

    private void validateBuilder() {

        if (controller.isFileMode())
            return;
        while (true) {
            controller.show("Создастся объект со значениями: " + this);
            String needToChange = controller.readString("Хотите отредактировать[Y/N]? ");
            if (needToChange.toUpperCase().equals("Y")) {
                String fieldToFix = controller.readString("Напишите поле, которое хотите исправить[name/x/y/z]: ");
                switch (fieldToFix.toLowerCase()) {
                    case "x":
                        setX();
                        break;
                    case "y":
                        setY();
                        break;
                    case "z":
                        setZ();
                        break;
                    case "name":
                        setName();
                        break;
                }

            } else
                break;
        }

    }


    private LocationBuilder setX() {

        x = controller.readInteger("Введите x: ");
        return this;

    }

    private LocationBuilder setY() {

        y = null;
        while (y == null) {
            controller.show("Значение y не должно быть null");
            y = controller.readLong("Введите y: ");
        }
        return this;

    }

    private LocationBuilder setZ() {

        z = null;
        while (z == null) {
            controller.show("Значение z не должно быть null");
            z = controller.readFloat("Введите z: ");
        }
        return this;

    }


    private LocationBuilder setName() {

        name = null;
        while (name == null || name.length() > 966) {
            controller.show("Длина имени не должна быть больше 966. Имя не должно быть null.");
            name = controller.readString("Введите имя: ");
        }
        return this;

    }


    private boolean isVaild() {
        return (z != null && y != null && (name != null ? name.length() <= 966 : true));
    }

    private int x;
    private Long y;
    private Float z;
    private String name;

}
