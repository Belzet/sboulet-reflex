package sboulet.assignment1;

import android.content.Context;
import android.view.View;
import android.widget.Button;

/**
 * Created by Suzanne on 10/2/2015.
 */
public class PlayerButton {
    private Button button;
    private String player;
    private BuzzerCountList countList;

    public PlayerButton(Button button, String player, Context context) {
        this.button = button;
        this.player = player;
        countList = new BuzzerCountList(context);
    }

    public void onClick(final Context context) {
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                PopUp clicked = new PopUp((player + "clicked first"), "OK", context);
                clicked.show();
                countList.add(player);
            }
        });
    }
}
