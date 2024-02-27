package lb.pro3ect.lb5.logic.commands;

import org.springframework.stereotype.Component;

@Component("execute_script")
public class ExecuteScript extends Command {

    @Override
    public boolean exexute() {

        String filePath = getUiController().readString("Введите путь к файлу: ").replace("\\", "\\\\");
        getUiController().setFileToRead(filePath);

        return true;

    }
}
