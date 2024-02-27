package lb.pro3ect.lb5.logic.commands;

import org.springframework.stereotype.Component;

@Component("show")
public class Show extends DataManageCommand {

    @Override
    public boolean exexute() {
        getUiController().show(getWorkersRepository().selectAll().toString());
        return true;
    }
}
