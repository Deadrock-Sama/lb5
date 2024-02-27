package lb.pro3ect.lb5.logic.commands;

import org.springframework.stereotype.Component;

@Component("remove_key")
public class RemoveKey extends DataManageCommand {

    @Override
    public boolean exexute() {
        int key = getUiController().readInteger("Введите клюс: ");
        getWorkersRepository().remove(key);

        return true;
    }
}
