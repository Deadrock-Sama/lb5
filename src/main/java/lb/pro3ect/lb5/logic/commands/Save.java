package lb.pro3ect.lb5.logic.commands;

import lb.pro3ect.lb5.data.savers.ISaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("save")
public class Save extends DataManageCommand {

    @Override
    public boolean exexute() {
        keeper.save(getWorkersRepository());
        return true;
    }

    @Autowired
    @Qualifier("CurrentKeeper")
    private ISaver keeper;
}
