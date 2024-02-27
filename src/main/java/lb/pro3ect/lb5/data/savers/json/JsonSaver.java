package lb.pro3ect.lb5.data.savers.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import lb.pro3ect.lb5.data.IWorkersRepository;
import lb.pro3ect.lb5.data.WorkersHashtable;
import lb.pro3ect.lb5.data.savers.ISaver;
import lb.pro3ect.lb5.ui.UIController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${jsonKeeper.path}")
    private String jsonPath;

    @Autowired
    private UIController uiController;
    private Gson gson = new GsonBuilder()
            .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeAdapter())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
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
        try {
            scan = new Scanner(new File(jsonPath));
        } catch (IOException e) {
            System.out.println("error");
        }
        scan.useDelimiter("\\Z");

        if (!scan.hasNext())
            return new WorkersHashtable();

        String content = scan.next();
        if (content.isEmpty())
            return new WorkersHashtable();
        try {
            IWorkersRepository repository = gson.fromJson(content, WorkersHashtable.class);
            return repository;
        }
        catch (JsonSyntaxException e) {
            uiController.show("Не удалось загрузить сохранение:");
            uiController.show(e.getMessage());
            return new WorkersHashtable();
        }

    }
}
