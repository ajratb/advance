package ru.wts.dates;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomLocalDateTimeDeserializer
        extends JsonDeserializer<LocalDateTime> {


    @SuppressWarnings("CommentedOutCode")
    @Override
    public LocalDateTime deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext) throws IOException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String string = jsonparser.getText();

        // questionable workaround
//        if(string.length() > 20) {
//            ZonedDateTime zonedDateTime = ZonedDateTime.parse(string);
//            return zonedDateTime.toLocalDateTime();
//        }

        return LocalDateTime.parse(string, formatter);
    }
}