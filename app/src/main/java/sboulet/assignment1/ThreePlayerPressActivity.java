package sboulet.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ThreePlayerPressActivity extends AppCompatActivity {

    private BuzzerCountList buzzerCount;

    private TextView threeplayerp1;
    private TextView threeplayerp2;
    private TextView threeplayerp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_player_press);

        threeplayerp1 = (TextView) findViewById(R.id.threeplayerp1);
        threeplayerp2 = (TextView) findViewById(R.id.threeplayerp2);
        threeplayerp3 = (TextView) findViewById(R.id.threeplayerp3);

        buzzerCount = new BuzzerCountList(ThreePlayerPressActivity.this, "3player");

        //display count of player 1 presses in three player mode
        threeplayerp1.setText((getString(R.string.p1press) + " " + buzzerCount.playerOneCount()),
                TextView.BufferType.NORMAL);

        //display count of player 2 presses in three player mode
        threeplayerp2.setText((getString(R.string.p2press) + " " + buzzerCount.playerTwoCount()),
                TextView.BufferType.NORMAL);

        //display count of player 3 presses in three player mode
        threeplayerp3.setText((getString(R.string.p3press) + " " + buzzerCount.playerThreeCount()),
                TextView.BufferType.NORMAL);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_three_player_press, menu);
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
