package ucl.ac.uk.model;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;


public class note {
    private String title;
    private String summary;
    private String content;
    private String time;

    public note(String title, String summary, String content, String time)
    {
        this.title = title;
        this.content = content;
        this.time = time;
        this.summary = summary;
    }

    public void newNote(){
        String title2 = this.title.replaceAll("\\s","");

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("Title", this.title);
        jsonObject.put("Summary", this.summary);
        jsonObject.put("Content", this.content );
        jsonObject.put("Time", this.time);


        try {
            FileWriter file = new FileWriter("notes/"+title2+".json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println("JSON file created: "+jsonObject);

    }

    public String getTitle(){
        return this.title;
    }

    public String getTime(){
        return this.time;
    }
    public String getSummary(){
        return this.summary;
    }
    public String getContent(){
        return this.content;
    }


    public void deleteNote(){
        String name = this.title.replaceAll("json","");
        Path path = FileSystems.getDefault().getPath("notes/"+name+".json");
        try {
            Files.delete(path);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    public void editNote(String a) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        String name = a.replaceAll("\\s","");
        Reader reader = new FileReader("notes/"+name+".json");
        JSONObject obj = (JSONObject) parser.parse(reader);
        obj.put("Title", "Updated title");
        try {
            FileWriter file = new FileWriter("notes/"+name+".json");
            file.write(obj.toJSONString());
            file.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println("JSON file updated: "+obj);
    }


}
