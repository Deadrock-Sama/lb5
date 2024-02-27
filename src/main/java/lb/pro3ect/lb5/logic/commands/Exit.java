package lb.pro3ect.lb5.logic.commands;

import org.springframework.stereotype.Component;

@Component("exit")
public class Exit extends Command {
    @Override
    public boolean exexute() {
        System.exit(0);
        return false;
    }
}
