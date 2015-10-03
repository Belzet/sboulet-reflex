package sboulet.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class FourPlayerPressActivity extends AppCompatActivity {

    private BuzzerCountList buzzerCount;

    private TextView fourplayerp1;
    private TextView fourplayerp2;
    private TextView fourplayerp3;
    private TextView fourplayerp4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_player_press);

        fourplayerp1 = (TextView) findViewById(R.id.fourplayerp1);
        fourplayerp2 = (TextView) findViewById(R.id.fourplayerp2);
        fourplayerp3 = (TextView) findViewById(R.id.fourplayerp3);
        fourplayerp4 = (TextView) findViewById(R.id.fourplayerp4);

        buzzerCount = new BuzzerCountList(FourPlayerPressActivity.this, "4player");

        //display count of player 1 presses in four player mode
        fourplayerp1.setText((getString(R.string.p1press) + " " + buzzerCount.playerOneCount()),
                TextView.BufferType.NORMAL);

        //display count of player 2 presses in four player mode
        fourplayerp2.setText((getString(R.string.p2press) + " " + buzzerCount.playerTwoCount()),
                TextView.BufferType.NORMAL);

        //display count of player 3 presses in four player mode
        fourplayerp3.setText((getString(R.string.p3press) + " " + buzzerCount.playerThreeCount()),
                TextView.BufferType.NORMAL);

        //display count of player 4 presses in four player mode
        fourplayerp4.setText((getString(R.string.p4press) + " " + buzzerCount.playerFourCount()),
                TextView.BufferType.NORMAL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_four_player_press, menu);
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
