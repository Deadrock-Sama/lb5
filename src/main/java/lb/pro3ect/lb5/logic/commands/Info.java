package lb.pro3ect.lb5.logic.commands;

import org.springframework.stereotype.Component;

@Component("info")
public class Info extends DataManageCommand {

    @Override
    public boolean exexute() {
        getUiController().show(getWorkersRepository().info());
        return true;
    }
}
