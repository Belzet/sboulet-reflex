package sboulet.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MinimumReactionActivity extends AppCompatActivity {

    private ReactionTimeList reactTimes;

    private TextView minall;
    private TextView min10;
    private TextView min100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minimum_reaction);

        //initializing the TextViews
        minall = (TextView) findViewById(R.id.minall);
        min10 = (TextView) findViewById(R.id.min10);
        min100 = (TextView) findViewById(R.id.min100);

        reactTimes = new ReactionTimeList(MinimumReactionActivity.this);

        //display minimum of all reaction times
        minall.setText((getString(R.string.minall) + " " + reactTimes.getMinAll()),
                    TextView.BufferType.NORMAL);

        //display minimum of last 10 reaction times
        min10.setText((getString(R.string.min10) + " " + reactTimes.getMinAmount(10)),
                TextView.BufferType.NORMAL);

        //display maximum of 100 reaction times
        min100.setText((getString(R.string.min100) + " " + reactTimes.getMinAmount(100)),
                TextView.BufferType.NORMAL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_minimum_reaction, menu);
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
