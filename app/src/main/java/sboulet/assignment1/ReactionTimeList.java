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
        int min = reactionTimes.get((reactionTimes.size() - 1)).intValue();
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
        int size = reactionTimes.size() - 1;
        int min = reactionTimes.get(size).intValue();
        for (int i = size - 1; i > (size - num); i--) {
            try {
                if (min > ((reactionTimes.get(i)).intValue())) {
                    min = reactionTimes.get(i).intValue();
                }
            }
            //if there aren't enough results, break and display what you have so far
            catch (ArrayIndexOutOfBoundsException e){
                break;
            }
        }
        return min;
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
        int size = reactionTimes.size() - 1;
        int max = reactionTimes.get(size).intValue();
        for (int i = size - 1; i > (size - num); i--) {
            try {
                if (max < ((reactionTimes.get(i)).intValue())) {
                    max = reactionTimes.get(i).intValue();
                }
            }
            //if there aren't enough results, break and display what you have so far
            catch (ArrayIndexOutOfBoundsException e){
                break;
            }
        }
        return max;
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
        int size = reactionTimes.size() - 1;
        int avg = 0;
        int count = 0;
        for (int i = size; i > (size - num); i--) {
            try {
                avg += reactionTimes.get(i).intValue();
                count++;
            }
            //if there aren't enough results, break and display what you have so far
            catch (ArrayIndexOutOfBoundsException e){
                break;
            }
        }
        avg /= count;
        return avg;
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
        int med = 0;
        ArrayList<Integer> numLast = new ArrayList<Integer>();
        int size = reactionTimes.size() - 1;
        int count = 0;
        for (int i = size; i > (size - num); i--) {
            try {
                numLast.add(reactionTimes.get(i).intValue());
                count++;
            }
            //if there aren't enough results, break and display what you have so far
            catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
        Collections.sort(numLast);
        if ((numLast.size() % 2) == 0) {
            //if size is even, get two values and average
            int medA = numLast.get(count / 2);
            int medB = numLast.get((count / 2) - 1);
            med = (medA + medB) / 2;
        }
        else {
            med = numLast.get((count / 2) + 1);
        }
        return med;
    }
}
