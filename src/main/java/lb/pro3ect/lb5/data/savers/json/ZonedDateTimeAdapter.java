package lb.pro3ect.lb5.data.savers.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.ZonedDateTime;

public class ZonedDateTimeAdapter extends TypeAdapter<ZonedDateTime> {
    @Override
    public void write(JsonWriter jsonWriter, ZonedDateTime localDateTime) throws IOException {
        if (localDateTime == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(localDateTime.toString());
        }
    }

    @Override
    public ZonedDateTime read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        } else {
            return ZonedDateTime.parse(jsonReader.nextString());
        }
    }
}

