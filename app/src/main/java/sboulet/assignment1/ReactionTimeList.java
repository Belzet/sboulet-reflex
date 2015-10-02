package sboulet.assignment1;

import java.util.ArrayList;

/**
 * Created by Suzanne on 9/30/2015.
 */
public class ReactionTimeList {
    private ArrayList<Long> reactionTimes;

    public ReactionTimeList() {
        reactionTimes = new ArrayList<>();
    }


    public void addTime(Long time) {
        reactionTimes.add(time);
    }
}
