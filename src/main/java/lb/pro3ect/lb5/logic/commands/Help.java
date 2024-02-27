package lb.pro3ect.lb5.logic.commands;

import lb.pro3ect.lb5.ui.UIController;
import org.springframework.stereotype.Component;

@Component("help")
public class Help extends Command {
    @Override
    public boolean exexute() {

        UIController controller = getUiController();

        controller.show("help : вывести справку по доступным командам");
        controller.show("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        controller.show("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        controller.show("insert null {element} : добавить новый элемент с заданным ключом");
        controller.show("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
        controller.show("remove_key null : удалить элемент из коллекции по его ключу");
        controller.show("clear : очистить коллекцию");
        controller.show("save : сохранить коллекцию в файл");
        controller.show("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        controller.show("exit : завершить программу (без сохранения в файл)");
        controller.show("remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный");
        controller.show("replace_if_greater null {element} : заменить значение по ключу, если новое значение больше старого");
        controller.show("remove_greater_key null : удалить из коллекции все элементы, ключ которых превышает заданный");
        controller.show("count_less_than_person person : вывести количество элементов, значение поля person которых меньше заданного");
        controller.show("filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку");
        controller.show("print_descending : вывести элементы коллекции в порядке убывания");

        return true;
    }
}
