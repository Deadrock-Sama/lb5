package lb.pro3ect.lb5.logic.commands;

import org.springframework.stereotype.Component;

@Component("remove_greater_key")
public class RemoveGreaterKey extends DataManageCommand {

    @Override
    public boolean exexute() {
        int key = getUiController().readInteger("Введите клюс: ");
        getWorkersRepository().removeWorkersWithGreaterKey(key);
        return true;
    }

}
