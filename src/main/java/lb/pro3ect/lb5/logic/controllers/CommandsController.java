package lb.pro3ect.lb5.logic.controllers;

import lb.pro3ect.lb5.logic.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CommandsController {

    public Command getCommand(String input) {
        Command empty = commands.get("empty");
        if (input != null)
            return commands.getOrDefault(input.toLowerCase(), empty);

        return empty;
    }

    @Autowired
    private Map<String, Command> commands;

}
