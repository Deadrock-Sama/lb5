package lb.pro3ect.lb5.data.savers.json;

import com.google.gson.*;
import lb.pro3ect.lb5.data.entities.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class WorkerDeserializer implements JsonDeserializer<Worker> {
    @Override
    public Worker deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String name = jsonObject.get("name").getAsString();
        Coordinates coordinates = jsonDeserializationContext.deserialize(jsonObject.get("coordinates"), Coordinates.class);
        Long salary = jsonObject.get("salary").getAsLong();
        Position position = Position.valueOf(jsonObject.get("position").getAsString());
        Person person = jsonDeserializationContext.deserialize(jsonObject.get("person"), Person.class);
        Status status = Status.valueOf(jsonObject.get("status").getAsString());
        int id = jsonObject.get("id").getAsInt();
        LocalDateTime creationDate = LocalDateTime.parse(jsonObject.get("creationDate").getAsString());

        try {
            return new Worker(name, coordinates, salary, position, person, status, id, creationDate);
        }
        catch (Exception e) {
            System.out.println("Некорректные данные в сохранении. " + e.getMessage());
            System.exit(1);

        }
        return null;
    }
}
