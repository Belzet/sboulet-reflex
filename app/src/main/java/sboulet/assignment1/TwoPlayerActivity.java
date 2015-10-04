package sboulet.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TwoPlayerActivity extends AppCompatActivity {

    private BuzzerCountList playerCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player);

        playerCount = new BuzzerCountList(TwoPlayerActivity.this, "2player");

        //constructing Player 1 buzzer
        Button firstplayer = (Button) findViewById(R.id.player1buzzer);
        firstplayer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
               playerCount.add("Player 1");
                PopUp player1clicked = new PopUp("Player 1 Clicked First!", TwoPlayerActivity.this);
                player1clicked.show();
            }
        });

        //constructing Player 2 buzzer
        Button secondplayer = (Button) findViewById(R.id.player2buzzer);
        secondplayer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                playerCount.add("Player 2");
                PopUp player2clicked = new PopUp("Player 2 Clicked First!", TwoPlayerActivity.this);
                player2clicked.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_two_player, menu);
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
