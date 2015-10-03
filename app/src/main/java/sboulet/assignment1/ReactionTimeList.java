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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by Suzanne on 9/30/2015.
 */
public class ReactionTimeList implements Comparator<Long> {
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

    @Override
    public int compare(Long lhs, Long rhs) {
        return Long.compare(lhs, rhs);
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
        int min = 1000000;
        int nextInt = 0;
        while (it.hasNext()) {
            nextInt = (it.next()).intValue();
            if (min > nextInt) {
                min = nextInt;
            }
        }
        return min;
    }

    public int getMinAmount(int num) {
        it = reactionTimes.iterator();
        return 5;
    }

    public int getMaxAll() {
      it = reactionTimes.iterator();
        int max = 0;
        int nextInt = 0;
        while (it.hasNext()) {
            nextInt = (it.next()).intValue();
            if (max < nextInt) {
                max = nextInt;
            }
        }
        return max;
    }

    public int getMaxAmount(int num) {
        it = reactionTimes.iterator();
        return 5;
    }

    public int getAvgAll() {
        it = reactionTimes.iterator();
        int total = 0;
        int nextInt = 0;
        while (it.hasNext()) {
            nextInt = (it.next()).intValue();
            total += nextInt;
        }
        return (total / (reactionTimes.size()));
    }

    public int getAvgAmount(int num) {
        it = reactionTimes.iterator();
        return 5;
    }

    public int getMedAll() {
        int med = 0;
        int middle = reactionTimes.size() / 2;
        ArrayList<Long> sortedReactionTimes = reactionTimes;
        Collections.sort(sortedReactionTimes);
        if ((sortedReactionTimes.size() % 2) == 0) {
            //if size is even, get two values and average
            int medA = sortedReactionTimes.get(middle).intValue();
            int medB = sortedReactionTimes.get(middle-1).intValue();
            med = (medA + medB) / 2;
        }
        else {
            med = sortedReactionTimes.get(middle+1).intValue();
        }
        return med;
    }

    public int getMedAmount(int num) {
        it = reactionTimes.iterator();
        return 5;
    }
}
