package lb.pro3ect.lb5.logic.commands;

import lb.pro3ect.lb5.data.IWorkersRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class DataManageCommand extends Command {

    protected IWorkersRepository getWorkersRepository() {
        return workersRepository;
    }

    @Autowired
    private IWorkersRepository workersRepository;
}