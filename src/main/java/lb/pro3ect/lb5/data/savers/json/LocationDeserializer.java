package lb.pro3ect.lb5.data.savers.json;

import com.google.gson.*;
import lb.pro3ect.lb5.data.entities.Location;

import java.lang.reflect.Type;

public class LocationDeserializer implements JsonDeserializer<Location> {
    @Override
    public Location deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        int x = jsonObject.get("x").getAsInt();
        Long y = jsonObject.get("y").getAsLong();
        Float z = jsonObject.get("z").getAsFloat();
        String name = jsonObject.get("name").getAsString();

        try {
            Location location = new Location(x, y, z, name);
            return location;
        }
        catch (Exception e) {
            System.out.println("Некорректные данные в сохранении. " + e.getMessage());
            System.exit(1);

        }
        return null;
    }
}
