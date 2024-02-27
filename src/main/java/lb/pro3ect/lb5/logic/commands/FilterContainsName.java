package lb.pro3ect.lb5.logic.commands;

import lb.pro3ect.lb5.data.entities.Worker;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("filter_contains_name")
public class FilterContainsName extends DataManageCommand {

    @Override
    public boolean exexute() {

        String substring = getUiController().readString("Введите подстроку: ");
        List<Worker> workerList = getWorkersRepository().selectWorkersWithSubstringInName(substring);
        getUiController().show(workerList.toString());

        return true;
    }
}
