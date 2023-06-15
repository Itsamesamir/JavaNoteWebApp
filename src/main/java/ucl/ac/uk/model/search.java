package ucl.ac.uk.model;

import java.util.ArrayList;

public class search
{
        public static ArrayList<note> searchNote(String input)
        {

            ArrayList<note> result = new ArrayList<>();
            ArrayList<note> allnotes = allNotes.notesList();




                for (note Note : allnotes)
                {
                    String name = Note.getTitle();


                    if (name.contains(input))
                    {
                        result.add(Note);
                    }
                }



            return result;
        }



}
