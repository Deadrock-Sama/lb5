package lb.pro3ect.lb5.logic.commands;

import lb.pro3ect.lb5.data.builders.WorkerBuilder;
import lb.pro3ect.lb5.data.entities.Worker;
import org.springframework.stereotype.Component;

@Component("replace_if_greater")
public class ReplaceIfGreater extends DataManageCommand {

    @Override
    public boolean exexute() {

        int key = getUiController().readInteger("Введите ключ: ");
        Worker worker = new WorkerBuilder(getUiController()).setRequiredFields().build();

        getWorkersRepository().replaceWithGreaterWorker(key, worker);

        return true;
    }
}
