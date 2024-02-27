package lb.pro3ect.lb5.logic.commands;

import lb.pro3ect.lb5.data.builders.WorkerBuilder;
import lb.pro3ect.lb5.data.entities.Worker;
import org.springframework.stereotype.Component;

@Component("remove_lower")
public class RemoveLower extends DataManageCommand {


    @Override
    public boolean exexute() {

        Worker worker = new WorkerBuilder(getUiController())
                .setRequiredFields()
                .build();

        getWorkersRepository().removeLowerWorkers(worker);
        return true;
    }
}
