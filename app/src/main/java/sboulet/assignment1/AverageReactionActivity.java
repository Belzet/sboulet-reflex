package sboulet.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AverageReactionActivity extends AppCompatActivity {

    private ReactionTimeList reactTimes;

    private TextView avgall;
    private TextView avg10;
    private TextView avg100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_reaction);

        //initializing the TextViews
        avgall = (TextView) findViewById(R.id.avgall);
        avg10 = (TextView) findViewById(R.id.avg10);
        avg100 = (TextView) findViewById(R.id.avg100);

        reactTimes = new ReactionTimeList(AverageReactionActivity.this);

        if (reactTimes.size() == 0) {
            PopUp nodata = new PopUp(
                    "There are no reaction times to display. Play Singleplayer Mode and come back later.",
                    AverageReactionActivity.this);
            nodata.show();
        }
        else {
            //display average of all reaction times
            avgall.setText((getString(R.string.avgall) + " " + reactTimes.getAvgAll()),
                    TextView.BufferType.NORMAL);

            //display average of last 10 reaction times
            avg10.setText((getString(R.string.avg10) + " " + reactTimes.getAvgAmount(10)),
                    TextView.BufferType.NORMAL);

            //display average of 100 reaction times
            avg100.setText((getString(R.string.avg100) + " " + reactTimes.getAvgAmount(100)),
                    TextView.BufferType.NORMAL);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_average_reaction, menu);
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
