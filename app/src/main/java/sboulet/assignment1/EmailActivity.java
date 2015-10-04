package sboulet.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {

    private EmailStatistics email;
    private ReactionTimeList reactList;
    private BuzzerCountList player2;
    private BuzzerCountList player3;
    private BuzzerCountList player4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        reactList = new ReactionTimeList(EmailActivity.this);
        player2 = new BuzzerCountList(EmailActivity.this, "2player");
        player3 = new BuzzerCountList(EmailActivity.this, "3player");
        player4 = new BuzzerCountList(EmailActivity.this, "4player");

        email = new EmailStatistics(EmailActivity.this);

        if (reactList.size() == 0) {
            PopUp nodata = new PopUp(
                    "There are no reaction times saved. Play Singleplayer Mode and come back later, or email now to only get statistics about player presses.",
                    EmailActivity.this
            );
            nodata.show();
            email.addToMessage(player2);
            email.addToMessage(player3);
            email.addToMessage(player4);
        }
        else {
            email.addToMessage(reactList);
            email.addToMessage(player2);
            email.addToMessage(player3);
            email.addToMessage(player4);
        }

        Button email_send = (Button) findViewById(R.id.email_send);
        email_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email.send();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_email, menu);
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
