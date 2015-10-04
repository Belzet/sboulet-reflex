package sboulet.assignment1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Suzanne on 10/3/2015.
 */
public class EmailStatistics {
    private String to;
    private Context context;
    private Intent email;
    private static final String SUBJECT = "Statistics from sboulet-reflex";
    private String message = "Statistics from sboulet-reflex\n";

    public EmailStatistics (Context context) {
        this.context = context;
        email = new Intent(Intent.ACTION_SEND);
        email.setType("message/rfc822");
    }

    public void addToMessage(ReactionTimeList reactList) {
        message = message.concat("\nMinimum Reaction Times of All/10/100: "
                + reactList.getMinAll() + "/"
                + reactList.getMinAmount(10) + "/"
                + reactList.getMinAmount(100) + "\n");
        message = message.concat("\nMaximum Reaction Times of All/10/100: "
                + reactList.getMaxAll() + "/"
                + reactList.getMaxAmount(10) + "/"
                + reactList.getMaxAmount(100) + "\n");
        message = message.concat("\nAverage Reaction Times of All/10/100: "
                + reactList.getAvgAll() + "/"
                + reactList.getAvgAmount(10) + "/"
                + reactList.getAvgAmount(100) + "\n");
        message = message.concat("\nMedian Reaction Times of All/10/100: "
                + reactList.getMedAll() + "/"
                + reactList.getMedAmount(10) + "/"
                + reactList.getMedAmount(100) + "\n");
    }

    public void addToMessage(BuzzerCountList buzzerList) {
        if (buzzerList.getMode().compareTo("2player") == 0) {
            message = message.concat("\nTwo Player Mode\nPlayer 1 Count: "
            + buzzerList.playerOneCount() + "\nPlayer 2 Count: "
            + buzzerList.playerTwoCount() + "\n");
        }
        if (buzzerList.getMode().compareTo("3player") == 0) {
            message = message.concat("\nThree Player Mode\nPlayer 1 Count: "
                    + buzzerList.playerOneCount() + "\nPlayer 2 Count: "
                    + buzzerList.playerTwoCount() + "\nPlayer 3 Count: "
                    + buzzerList.playerThreeCount() + "\n");
        }
        if (buzzerList.getMode().compareTo("4player") == 0) {
            message = message.concat("\nFour Player Mode\nPlayer 1 Count: "
                    + buzzerList.playerOneCount() + "\nPlayer 2 Count: "
                    + buzzerList.playerTwoCount() + "\nPlayer 3 Count: "
                    + buzzerList.playerThreeCount() + "\nPlayer 4 Count: "
                    + buzzerList.playerFourCount() + "\n");
        }
    }

    public void send() {
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
        email.putExtra(Intent.EXTRA_SUBJECT, SUBJECT);
        email.putExtra(Intent.EXTRA_TEXT, message);
        try {
            context.startActivity(Intent.createChooser(email, "Send mail..."));
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
