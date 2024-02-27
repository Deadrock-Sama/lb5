package lb.pro3ect.lb5.data.builders;

import lb.pro3ect.lb5.ui.UIController;
import lb.pro3ect.lb5.data.entities.Coordinates;

public class CoordinatesBuilder extends Builder {

    public CoordinatesBuilder(UIController controller) {
        super(controller);
    }

    public CoordinatesBuilder setRequiredFields() {

        setX();
        setY();

        validateBuilder();

        return this;

    }

    public Coordinates build() {

        if (isValid())
            return new Coordinates(x, y);

        controller.show("Недопустимые значения: " + this);
        return null;

    }

    @Override
    public String toString() {

        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';

    }

    private void validateBuilder() {

        if (controller.isFileMode())
            return;

        while (true) {
            controller.show("Создастся объект со значениями: " + this);
            String needToChange = controller.readString("Хотите отредактировать[Y/N]? ");
            if (needToChange.toUpperCase().equals("Y")) {
                String fieldToFix = controller.readString("Напишите поле, которое хотите исправить[x, y]: ");
                switch (fieldToFix.toLowerCase()) {
                    case "x":
                        setX();
                        break;
                    case "y":
                        setY();
                        break;
                    default:
                        controller.show("Такого поля нет");
                }

            } else
                break;
        }

    }

    private CoordinatesBuilder setX() {

        x = -700;
        while (x <= -678) {
            controller.show("Значение x должно быть больше -678");
            x = controller.readDouble("Введите x: ");
        }
        return this;

    }

    private CoordinatesBuilder setY() {

        y = null;
        while (y == null) {
            controller.show("Значение y не должно быть null");
            y = controller.readLong("Введите y: ");
        }
        return this;

    }

    private boolean isValid() {
        return (x > -678 && y != null);
    }

    private double x = (-700);
    private Long y;


}
