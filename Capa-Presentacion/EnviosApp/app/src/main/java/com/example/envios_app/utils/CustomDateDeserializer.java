package com.example.envios_app.utils;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CustomDateDeserializer implements JsonDeserializer<Date> {

    private final SimpleDateFormat dateFormat;

    public CustomDateDeserializer() {
        dateFormat = new SimpleDateFormat("MMM dd, yyyy, h:mm:ss a", Locale.ENGLISH);
    }

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String dateString = json.getAsString();
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new JsonParseException("Failed to parse date: " + dateString, e);
        }
    }
}
