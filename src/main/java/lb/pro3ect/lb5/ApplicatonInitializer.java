package lb.pro3ect.lb5;

import lb.pro3ect.lb5.ui.UIController;
import lb.pro3ect.lb5.logic.controllers.CommandsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicatonInitializer {


    @EventListener({ContextRefreshedEvent.class})
    public void init() {

        while (true) {
            boolean result = commandsController.getCommand(uiController.readString("Введите команду: ")).exexute();

            if (result)
                uiController.show("Команда успешно выполнена!");

        }
    }

    @Autowired
    private CommandsController commandsController;
    @Autowired
    private UIController uiController;

}
