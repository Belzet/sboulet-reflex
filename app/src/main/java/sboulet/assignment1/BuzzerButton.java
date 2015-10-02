package sboulet.assignment1;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ToggleButton;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by Suzanne on 9/30/2015.
 */
public class BuzzerButton {

    private ToggleButton buzzer;
    private ReactionTimeList reactList;
    private ReactionTime react;

    public BuzzerButton(ToggleButton toggle) {
        buzzer = toggle;
        buzzer.setText(null);
        buzzer.setTextOff(null);
        buzzer.setTextOn(null);
        react = new ReactionTime();
        reactList = new ReactionTimeList();
    }

    //set to default state
    public void setGrey(Context context) {
        buzzer.setBackground(ContextCompat.getDrawable(context, R.drawable.unselected_state));
    }

    //set to clickable state
    public void setRed(Context context) {
        buzzer.setBackground(ContextCompat.getDrawable(context, R.drawable.selected_state));
    }

    //set what happens if user clicks while still grey
    public void clickTooEarly(final Context context) {
        buzzer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                PopUp tooFast = new PopUp("Too early! Wait until the buzzer turns red!", "OK", context);
                tooFast.show();
            }
        });
    }

    public void clickOnTime(final Context context) {
        buzzer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                react.setReactionTime(System.currentTimeMillis());
                reactList.addTime(react.getReactionTime());
                PopUp success = new PopUp(react.getReactionTime(), "OK", context);
                success.show();
            }
        });
    }

    public void makeClickable(final Context context, final BuzzerButton button) {
        Handler handler = new Handler() {
            @Override
            public void close() {

            }

            @Override
            public void flush() {

            }

            @Override
            public void publish(LogRecord record) {

            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                button.setRed(context);
                button.clickOnTime(context);
            }
        };
        buzzer.postDelayed(runnable, react.getRandomTime());
    }
}
