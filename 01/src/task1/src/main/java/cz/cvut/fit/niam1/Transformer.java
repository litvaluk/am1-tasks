package cz.cvut.fit.niam1;

import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.util.Arrays;

public class Transformer  {

    public Transformer() {
    }

    public String transform(String input) {
        String id = "", location = "", name = "", surname = "";

        // split into usable lines
        String data = input.split("===")[1];
        String[] lines = data.split("\n");

        // map data into variables
        for (String line : lines) {
            if (line.startsWith("Tour id")) {
                id = line.split("\"")[1];
            } else if (line.startsWith("Location")) {
                location = line.split("\"")[1];
            } else if (line.startsWith("Person")) {
                String[] splitted = line.split("\"")[1].split(" ");
                name = splitted[0];
                surname = splitted[1];
            }
        }

        // return constructed json
        return constructJson(id, location, name, surname).toString(2);
    }

    private JSONObject constructJson(String id, String location, String name, String surname) {
        // create root node
        JSONObject root = new JSONObject();

        // create person node
        JSONObject person = new JSONObject();
        person.put("name", name);
        person.put("surname", surname);

        // put everything into root
        root.put("person", person);
        root.put("location", location);
        root.put("id", id);
        return root;
    }

}
