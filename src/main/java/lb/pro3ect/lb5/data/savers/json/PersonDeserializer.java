package lb.pro3ect.lb5.data.savers.json;

import com.google.gson.*;
import lb.pro3ect.lb5.data.entities.Coordinates;
import lb.pro3ect.lb5.data.entities.Location;
import lb.pro3ect.lb5.data.entities.Person;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;

public class PersonDeserializer implements JsonDeserializer<Person> {
    @Override
    public Person deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        ZonedDateTime birthday = ZonedDateTime.parse(jsonObject.get("birthday").getAsString());
        double height = jsonObject.get("height").getAsDouble();
        Location location = jsonDeserializationContext.deserialize(jsonObject.get("location"), Location.class);
        String passportID = jsonObject.get("passportID").getAsString();


        try {
            return new Person(birthday, height, location, passportID);
        }
        catch (Exception e) {
            System.out.println("Некорректные данные в сохранении. " + e.getMessage());
            System.exit(1);
        }
        return null;

    }
}
