package ucl.ac.uk.model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Timestamp;

public class noteFactory {
    public static note getNote(String title, String summary, String content)
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String time = timestamp.toString();
        return new note(title, summary, content, time);
    }

    public static note viewNote(String a){
        JSONParser parser = new JSONParser();
        String path;
        if (a !=null ){
            String name = a.replaceAll("\\s", "");
            path = ("notes/"+name+".json");
        }
        else{
            path = ("notes/"+a+".json");
        }


        try (Reader reader = new FileReader(path)) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            String title = (String) jsonObject.get("Title");
            String summary = (String) jsonObject.get("Summary");
            String content = (String) jsonObject.get("Content");
            String time = (String) jsonObject.get("Time");

            return new note(title, summary, content, time);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return null;
    }


}
