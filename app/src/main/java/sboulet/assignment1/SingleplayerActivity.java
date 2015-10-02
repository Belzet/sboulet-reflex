package sboulet.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ToggleButton;

public class SingleplayerActivity extends AppCompatActivity {

    public static Boolean initial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);

        //creates an alert with instructions
        initial = false;
        PopUp entry = new PopUp("Press the button when it turns red. Act fast!", "OK", SingleplayerActivity.this);
        entry.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_singleplayer, menu);
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

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onResume() {    //resets buzzer after initial instructions and result dialog
        super.onResume();

        //create buzzer
        final ToggleButton toggle = (ToggleButton) findViewById(R.id.greybuzzer);
        BuzzerButton buzzer = new BuzzerButton(toggle);

        //refresh to default state
        buzzer.setGrey(SingleplayerActivity.this);

        //set what happens if the buzzer is clicked early
        buzzer.clickTooEarly(SingleplayerActivity.this);

        //while entry PopUp hasn't been dealt with, refresh intent
        if (initial) {
            buzzer.makeClickable(SingleplayerActivity.this, buzzer);
        } else {
            Intent intent = new Intent(this, SingleplayerActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        }
    }
}
