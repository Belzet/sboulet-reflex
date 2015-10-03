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
import java.util.Iterator;

/**
 * Created by Suzanne on 9/30/2015.
 */
public class ReactionTimeList {
    private ArrayList<Long> reactionTimes;
    private static final String FILENAME = "reaction.sav";
    private Context context;
    private Iterator<Long> it;

    public ReactionTimeList(Context context) {
        this.context = context;
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            // Taken from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 2015-10-2
            Type listType = new TypeToken<ArrayList<Long>>() {}.getType();
            reactionTimes = gson.fromJson(in, listType);
        } catch (FileNotFoundException e) {
            reactionTimes = new ArrayList<Long>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTime(Long time) {
        reactionTimes.add(time);
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, 0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(reactionTimes, writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getMinAll() {
        it = reactionTimes.iterator();
        return 5;
    }

    public long getMinAmount(int num) {
        it = reactionTimes.iterator();
        return 5;
    }

    public long getMaxAll() {
        it = reactionTimes.iterator();
        return 5;
    }

    public long getMaxAmount(int num) {
        it = reactionTimes.iterator();
        return 5;
    }

    public long getAvgAll() {
        it = reactionTimes.iterator();
        return 5;
    }

    public long getAvgAmount(int num) {
        it = reactionTimes.iterator();
        return 5;
    }

    public long getMedAll() {
        it = reactionTimes.iterator();
        return 5;
    }

    public long getMedAmount(int num) {
        it = reactionTimes.iterator();
        return 5;
    }
}
