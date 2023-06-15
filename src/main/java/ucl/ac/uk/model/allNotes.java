package ucl.ac.uk.model;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class allNotes {

    public static ArrayList<note> notesList() {
        ArrayList<note> notes = new ArrayList<>();

        File dir = new File("notes/");

        String[] fileList = dir.list();

        assert fileList != null;
        for (String name : fileList) {
            String title = name.replaceAll(".json", "");
            note Note = noteFactory.viewNote(title);
            notes.add(Note);
        }
        return notes;
    }


    public static List<String> viewIndex(int choice) {

        List<String> titles = new ArrayList<>();
        //alphabetical order
        if (choice == 1) {
            ArrayList<note> allnotes = allNotes.notesList();
            for (note Note : allnotes) {
                String name = Note.getTitle();


                titles.add(name);
            }

            titles.sort(String.CASE_INSENSITIVE_ORDER);


        }
        //old->new
        else {


            List<Timestamp> timeArraylist = new ArrayList<>();

            ArrayList<note> allnotes = allNotes.notesList();

            for (note Note : allnotes) {
                String timeString = Note.getTime();
                Timestamp time = Timestamp.valueOf(timeString);
                timeArraylist.add(time);
                //At this point not sorted yet.

            }


            Collections.sort(timeArraylist);
            int i = 0;
            for (note x : allnotes) {

                for (note Note : allnotes) {
                    String timeString = Note.getTime();
                    Timestamp time = Timestamp.valueOf(timeString);


                    if (time.equals(timeArraylist.get(i))) {
                        titles.add(Note.getTitle());

                        break;
                    }

                }
                i++;
            }


        }
        return titles;
    }


}


