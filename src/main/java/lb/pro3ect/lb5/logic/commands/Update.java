package lb.pro3ect.lb5.logic.commands;

import lb.pro3ect.lb5.data.builders.WorkerBuilder;
import lb.pro3ect.lb5.data.entities.Worker;
import org.springframework.stereotype.Component;

@Component("update")
public class Update extends DataManageCommand {

    @Override
    public boolean exexute() {
        int key = getUiController().readInteger("Введите ключ: ");
        Worker worker = new WorkerBuilder(getUiController()).setRequiredFields().build();
        getWorkersRepository().update(key, worker);
        return true;
    }
}
