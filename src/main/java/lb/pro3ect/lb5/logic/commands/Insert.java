package lb.pro3ect.lb5.logic.commands;

import lb.pro3ect.lb5.data.builders.WorkerBuilder;
import lb.pro3ect.lb5.data.entities.Worker;
import org.springframework.stereotype.Component;

@Component("insert")
public class Insert extends DataManageCommand {
    @Override
    public boolean exexute() {

        int key = getUiController().readInteger("Введите ключ: ");
        Worker worker = new WorkerBuilder(getUiController())
                .setRequiredFields()
                .build();

        getWorkersRepository().insert(key, worker);
        return true;
    }
}
