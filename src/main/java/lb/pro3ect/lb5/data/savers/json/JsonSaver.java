package lb.pro3ect.lb5.data.savers.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import lb.pro3ect.lb5.data.IWorkersRepository;
import lb.pro3ect.lb5.data.WorkersHashtable;
import lb.pro3ect.lb5.data.entities.Coordinates;
import lb.pro3ect.lb5.data.entities.Location;
import lb.pro3ect.lb5.data.entities.Person;
import lb.pro3ect.lb5.data.entities.Worker;
import lb.pro3ect.lb5.data.savers.ISaver;
import lb.pro3ect.lb5.ui.UIController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Scanner;

@Component
public class JsonSaver implements ISaver {

    private String jsonPath = System.getenv("JSON_PATH");

    @Autowired
    private UIController uiController;
    private Gson gson = new GsonBuilder()
            .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeAdapter())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .registerTypeAdapter(Location.class, new LocationDeserializer())
            .registerTypeAdapter(Worker.class, new WorkerDeserializer())
            .registerTypeAdapter(Person.class, new PersonDeserializer())
            .registerTypeAdapter(Coordinates.class, new CoordinatesDeserializer())
            .setPrettyPrinting()
            .create();


    @Override
    public void save(IWorkersRepository repository) {

        String json = gson.toJson(repository);

        try (FileOutputStream out = new FileOutputStream(jsonPath);
             BufferedOutputStream bos = new BufferedOutputStream(out)) {
            byte[] buffer = json.getBytes();
            bos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public IWorkersRepository load() {

        Scanner scan = null;
        if (jsonPath == null || jsonPath.isEmpty())
            jsonPath = "test.json";

        try {
            File jsonFile = new File(jsonPath);

            if (!jsonFile.exists())
                jsonFile.createNewFile();

            if (!jsonFile.canRead()) {
                System.out.println("Нет доступа к чтение! Чтение недоступно!");
                System.exit(1);
            }
            if (!jsonFile.canWrite()) {
                System.out.println("Нет доступа к записи! Сохранение недоступно!");
                System.exit(1);
            }
            scan = new Scanner(jsonFile);

        } catch (IOException e) {
            System.out.println("Ошибка. Неправильно указан путь в переменной окружения!");
            return new WorkersHashtable();
        }
        scan.useDelimiter("\\Z");

        if (!scan.hasNext())
            return new WorkersHashtable();

        String content = scan.next();
        if (content.isEmpty())
            return new WorkersHashtable();
        try {
            IWorkersRepository repository = gson.fromJson(content, WorkersHashtable.class);
            return repository == null ? new WorkersHashtable() : repository;
        } catch (Exception e) {
            uiController.show("Не удалось загрузить сохранение:");
            uiController.show(e.getMessage());
            System.exit(1);
            return new WorkersHashtable();
        }

    }
}
