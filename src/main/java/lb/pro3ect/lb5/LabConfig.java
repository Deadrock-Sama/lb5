package lb.pro3ect.lb5;

import lb.pro3ect.lb5.ui.UIController;
import lb.pro3ect.lb5.data.IWorkersRepository;
import lb.pro3ect.lb5.data.savers.ISaver;
import lb.pro3ect.lb5.data.savers.json.JsonSaver;
import lb.pro3ect.lb5.ui.ConsoleController;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@PropertySource("application.properties")
public class LabConfig {

    @Bean("CurrentKeeper")
    public ISaver getJsonKeeper() {
        keeper = new JsonSaver();
        return keeper;
    }

    @Bean("WorkersHashTable")
    @DependsOn("CurrentKeeper")
    public IWorkersRepository getWorkersRepository() {
        return keeper.load();
    }

    @Bean("ConsoleController")
    public UIController getConsoleController() {
        return new ConsoleController();
    }

    private ISaver keeper;
}
