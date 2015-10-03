package sboulet.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class TwoPlayerPressActivity extends AppCompatActivity {

    private BuzzerCountList buzzerCount;

    private TextView twoplayerp1;
    private TextView twoplayerp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player_press);

        twoplayerp1 = (TextView) findViewById(R.id.twoplayerp1);
        twoplayerp2 = (TextView) findViewById(R.id.twoplayerp2);

        buzzerCount = new BuzzerCountList(TwoPlayerPressActivity.this, "2player");

        //display count of player 1 presses in two player mode
        twoplayerp1.setText((getString(R.string.p1press) + " " + buzzerCount.playerOneCount()),
                TextView.BufferType.NORMAL);

        //display count of player 2 presses in two player mode
        twoplayerp2.setText((getString(R.string.p2press) + " " + buzzerCount.playerTwoCount()),
                TextView.BufferType.NORMAL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_two_player_press, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
