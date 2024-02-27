package lb.pro3ect.lb5.logic.commands;

import org.springframework.stereotype.Component;

@Component("print_descending")
public class PrintDescending extends DataManageCommand {

    @Override
    public boolean exexute() {

        getUiController().show(getWorkersRepository().sorted().toString());
        return true;
    }

}
