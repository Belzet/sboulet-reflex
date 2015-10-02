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
    private String mode;
    private Context context;

    public PlayerButton(Button button, String player, String mode, Context context) {
        this.button = button;
        this.player = player;
        this.context = context;
        this.mode = mode;
        countList = new BuzzerCountList(context, mode);
    }

    public void onClick() {
        PopUp clicked = new PopUp((player + " clicked first"), context);
        clicked.show();
        countList.add(player);
    }
}
