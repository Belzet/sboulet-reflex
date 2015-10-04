package sboulet.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ClearActivity extends AppCompatActivity {

    private BuzzerCountList twoplayer;
    private BuzzerCountList threeplayer;
    private BuzzerCountList fourplayer;

    private ReactionTimeList reactTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear);

        twoplayer = new BuzzerCountList(ClearActivity.this, "2player");
        threeplayer = new BuzzerCountList(ClearActivity.this, "3player");
        fourplayer = new BuzzerCountList(ClearActivity.this, "4player");

        reactTimes = new ReactionTimeList(ClearActivity.this);

        Button clear = (Button) findViewById(R.id.yes_clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twoplayer.clear();
                threeplayer.clear();
                fourplayer.clear();
                reactTimes.clear();
                PopUp cleared = new PopUp("Cleared reaction times!", ClearActivity.this);
                cleared.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_clear, menu);
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
