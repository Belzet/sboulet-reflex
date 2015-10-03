package sboulet.assignment1;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Suzanne on 9/30/2015.
 */
public class BuzzerCountList {
    private String FILENAME;
    private Context context;
    private ArrayList<String> buzzerCounts;

    public BuzzerCountList(Context context, String mode) {
        FILENAME = mode;
        this.context = context;
        buzzerCounts = new ArrayList<String>();
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            // Taken from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 2015-10-2
            Type listType = new TypeToken<ArrayList<String>>() {}.getType();
            buzzerCounts = gson.fromJson(in, listType);
        } catch (FileNotFoundException e) {
            buzzerCounts = new ArrayList<String>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(String player) {
        buzzerCounts.add(player);
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, 0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(buzzerCounts, writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int playerOneCount() {

        return 5;
    }

    public int playerTwoCount() {

        return 5;
    }

    public int playerThreeCount() {

        return 5;
    }

    public int playerFourCount() {

        return 5;
    }
}
