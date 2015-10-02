package sboulet.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class FourPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_player);

        //constructing Player 1 buzzer
        Button firstplayer = (Button) findViewById(R.id.player1buzzer);
        final PlayerButton player1 = new PlayerButton(firstplayer, "Player 1", "4player", FourPlayerActivity.this);
        firstplayer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                player1.onClick();
            }
        });

        //constructing Player 2 buzzer
        Button secondplayer = (Button) findViewById(R.id.player2buzzer);
        final PlayerButton player2 = new PlayerButton(secondplayer, "Player 2", "4player", FourPlayerActivity.this);
        secondplayer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                player2.onClick();
            }
        });

        //constructing Player 3 buzzer
        Button thirdplayer = (Button) findViewById(R.id.player3buzzer);
        final PlayerButton player3 = new PlayerButton(secondplayer, "Player 3", "4player", FourPlayerActivity.this);
        thirdplayer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                player3.onClick();
            }
        });

        //constructing Player 4 buzzer
        Button fourthplayer = (Button) findViewById(R.id.player4buzzer);
        final PlayerButton player4 = new PlayerButton(secondplayer, "Player 4", "4player", FourPlayerActivity.this);
        fourthplayer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                player4.onClick();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_four_player, menu);
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
