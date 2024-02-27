package lb.pro3ect.lb5.logic.commands;

import org.springframework.stereotype.Component;

@Component("empty")
public class EmptyCommand extends Command {
    @Override
    public boolean exexute() {
        getUiController().show("Введена неверная команда. Повторите попытку.");
        return false;
    }
}
