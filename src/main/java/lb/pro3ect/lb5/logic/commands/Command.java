package lb.pro3ect.lb5.logic.commands;

import lb.pro3ect.lb5.ui.UIController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


abstract public class Command {

    public UIController getUiController() {
        return uiController;
    }

    public abstract boolean exexute();

    @Autowired
    @Qualifier("ConsoleController")
    private UIController uiController;

}
