package sboulet.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MedianReactionActivity extends AppCompatActivity {

    private ReactionTimeList reactTimes;

    private TextView medall;
    private TextView med10;
    private TextView med100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_median_reaction);

        //initializing the TextViews
        medall = (TextView) findViewById(R.id.medall);
        med10 = (TextView) findViewById(R.id.med10);
        med100 = (TextView) findViewById(R.id.med100);

        reactTimes = new ReactionTimeList(MedianReactionActivity.this);

        //display median of all reaction times
        medall.setText((getString(R.string.medall) + " " + reactTimes.getMedAll()),
                TextView.BufferType.NORMAL);

        //display median of last 10 reaction times
        med10.setText((getString(R.string.med10) + " " + reactTimes.getMedAmount(10)),
                TextView.BufferType.NORMAL);

        //display median of 100 reaction times
        med100.setText((getString(R.string.med100) + " " + reactTimes.getMedAmount(100)),
                TextView.BufferType.NORMAL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_median_reaction, menu);
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
