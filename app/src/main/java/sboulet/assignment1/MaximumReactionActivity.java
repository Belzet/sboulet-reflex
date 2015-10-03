package sboulet.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MaximumReactionActivity extends AppCompatActivity {

    private ReactionTimeList reactTimes;

    private TextView maxall;
    private TextView max10;
    private TextView max100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maximum_reaction);

        //initializing the TextViews
        maxall = (TextView) findViewById(R.id.maxall);
        max10 = (TextView) findViewById(R.id.max10);
        max100 = (TextView) findViewById(R.id.max100);

        reactTimes = new ReactionTimeList(MaximumReactionActivity.this);

        //display maximum of all reaction times
        maxall.setText((getString(R.string.maxall) + " " + reactTimes.getMaxAll()),
                TextView.BufferType.NORMAL);

        //display maximum of last 10 reaction times
        max10.setText((getString(R.string.max10) + " " + reactTimes.getMaxAmount(10)),
                TextView.BufferType.NORMAL);

        //display maximum of 100 reaction times
        max100.setText((getString(R.string.max100) + " " + reactTimes.getMaxAmount(100)),
                TextView.BufferType.NORMAL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_maximum_reaction, menu);
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
