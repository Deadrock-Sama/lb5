package lb.pro3ect.lb5.logic.commands;

import org.springframework.stereotype.Component;

@Component("clear")
public class Clear extends DataManageCommand {

    @Override
    public boolean exexute() {
        getWorkersRepository().clear();
        return true;
    }
}
