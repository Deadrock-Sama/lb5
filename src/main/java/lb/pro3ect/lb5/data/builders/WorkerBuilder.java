package lb.pro3ect.lb5.data.builders;

import lb.pro3ect.lb5.ui.UIController;
import lb.pro3ect.lb5.data.entities.*;

import java.util.Arrays;

public class WorkerBuilder extends Builder {

    public WorkerBuilder(UIController controller) {
        super(controller);
    }

    public WorkerBuilder setRequiredFields() {

        setName();
        setPerson();
        setSalary();
        setCoordinates();
        setPosition();

        setStatus();
        return this;

    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", salary=" + salary +
                ", position=" + position +
                ", status=" + status +
                ", person=" + person +
                '}';
    }


    public Worker build() {

        if (isValid())
            return new Worker(name, coordinates, salary, position, person, status);

        controller.show("Значения " + this + " недопустимы");
        return null;

    }


    private WorkerBuilder setStatus() {
        try {
            status = Status.valueOf(controller.readString("Введите статус: " + Arrays.toString(Status.values()) + ": ").toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            controller.show("Данного значения не существует!");
        }

        return this;
    }

    private WorkerBuilder setName() {

        name = null;
        while (name == null) {
            controller.show("Значение name не должно быть null", false);
            name = controller.readString("Введите имя: ");
        }

        return this;

    }

    private WorkerBuilder setCoordinates() {

        coordinates = null;
        while (coordinates == null) {
            controller.show("Значение coordinates не должно быть null", false);
            coordinates = new CoordinatesBuilder(controller).setRequiredFields().build();
        }
        return this;

    }

    private WorkerBuilder setSalary() {

        salary = null;
        while (salary == null || salary <= 0) {
            controller.show("Значение salary не должно быть null и меньше нуля", false);
            salary = controller.readLong("Введите зарплату: ");
        }
        return this;

    }

    private WorkerBuilder setPosition() {

        position = null;
        while (position == null) {
            controller.show("Значение position не должно быть null. Доступные значения: " + Arrays.toString(Position.values()) + ": ", false);

            try {
                position = Position.valueOf(controller.readString("Введите позицию: ").toUpperCase().trim());
            } catch (IllegalArgumentException e) {
                controller.show("Данного значения не существует!");
            }


        }
        return this;

    }


    public WorkerBuilder setPerson() {

        person = null;
        while (person == null) {
            controller.show("Значение person не должно быть null", false);
            person = new PersonBuilder(controller)
                    .setRequiredFields()
                    .build();

        }
        return this;

    }


    private boolean isValid() {
        return (name != null && coordinates != null && salary > 0 && person != null);
    }

    private String name;
    private Coordinates coordinates;
    private Long salary;
    private Position position;
    private Status status;
    private Person person;

}
