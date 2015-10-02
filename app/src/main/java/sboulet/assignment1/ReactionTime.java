package sboulet.assignment1;

import java.util.Date;

/**
 * Created by Suzanne on 9/30/2015.
 */

public class ReactionTime {
    private long startTime;
    private long endTime;
    private long reactionTime;

    public ReactionTime() {
        startTime = System.currentTimeMillis();
        endTime = System.currentTimeMillis();
    }

    public int getRandomTime() {
        int random_time = (10 + (int)(Math.random() * ((2000 - 10) + 1)));
        return random_time;
    }

    public void setStartTime() {
        startTime = System.currentTimeMillis();
    }

    public void setReactionTime(long reactionTime) {
        endTime = reactionTime;
        this.reactionTime = (endTime - startTime);
    }

    public long getReactionTime() {
        return reactionTime;
    }
}
