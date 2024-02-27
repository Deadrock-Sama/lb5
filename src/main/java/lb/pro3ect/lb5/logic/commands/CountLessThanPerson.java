package lb.pro3ect.lb5.logic.commands;

import lb.pro3ect.lb5.data.builders.PersonBuilder;
import lb.pro3ect.lb5.data.entities.Person;
import org.springframework.stereotype.Component;

@Component("count_less_than_person")
public class CountLessThanPerson extends DataManageCommand {

    @Override
    public boolean exexute() {

        Person person = new PersonBuilder(getUiController())
                .setRequiredFields()
                .build();

        int count = getWorkersRepository().getCountOfWorkersWithLessPerson(person);
        getUiController().show("Количество работников с меньшей персоной: " + count);

        return true;
    }
}
