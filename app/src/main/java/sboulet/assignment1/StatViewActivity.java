package sboulet.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/********************************************************************
 *    Licensed to the Apache Software Foundation (ASF) under one     *
 *    or more contributor license agreements.  See the NOTICE file   *
 *    distributed with this work for additional information          *
 *    regarding copyright ownership.  The ASF licenses this file     *
 *    to you under the Apache License, Version 2.0 (the              *
 *    "License"); you may not use this file except in compliance     *
 *    with the License.  You may obtain a copy of the License at     *
 *                                                                   *
 *    http://www.apache.org/licenses/LICENSE-2.0                     *
 *                                                                   *
 *    Unless required by applicable law or agreed to in writing,     *
 *    software distributed under the License is distributed on an    *
 *    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY         *
 *    KIND, either express or implied.  See the License for the      *
 *    specific language governing permissions and limitations        *
 *    under the License.                                             *
 *******************************************************************/

public class StatViewActivity extends AppCompatActivity {

    private ReactionTimeList reactList;

    private BuzzerCountList twoplayer;
    private BuzzerCountList threeplayer;
    private BuzzerCountList fourplayer;

    private TextView min;
    private TextView max;
    private TextView avg;
    private TextView med;

    private TextView p2count;
    private TextView p3count;
    private TextView p4count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat_view);

        reactList = new ReactionTimeList(StatViewActivity.this);

        twoplayer = new BuzzerCountList(StatViewActivity.this, "2player");
        threeplayer = new BuzzerCountList(StatViewActivity.this, "3player");
        fourplayer = new BuzzerCountList(StatViewActivity.this, "4player");

        min = (TextView) findViewById(R.id.min);
        max = (TextView) findViewById(R.id.max);
        avg = (TextView) findViewById(R.id.avg);
        med = (TextView) findViewById(R.id.med);

        p2count = (TextView) findViewById(R.id.p2count);
        p3count = (TextView) findViewById(R.id.p3count);
        p4count = (TextView) findViewById(R.id.p4count);

        //if there are too few or no results to display, at least allow player counts to be displayed
        if (reactList.size() == 0 || reactList.size() == 1) {
            PopUp nodata = new PopUp(
                    "There are no reaction times to display. Play Singleplayer Mode and come back later.",
                    StatViewActivity.this);
            nodata.show();
        }
        else {
            min.setText((this.getString(R.string.min) + "\n     "
                    + reactList.getMinAll() + " / "
                    + reactList.getMinAmount(10) + " / "
                    + reactList.getMinAmount(100)), TextView.BufferType.NORMAL);

            max.setText((this.getString(R.string.max) + "\n     "
                    + reactList.getMaxAll() + " / "
                    + reactList.getMaxAmount(10) + " / "
                    + reactList.getMaxAmount(100)), TextView.BufferType.NORMAL);

            avg.setText((this.getString(R.string.avg) + "\n     "
                    + reactList.getAvgAll() + " / "
                    + reactList.getAvgAmount(10) + " / "
                    + reactList.getAvgAmount(100)), TextView.BufferType.NORMAL);

            med.setText((this.getString(R.string.med) + "\n     "
                    + reactList.getMedAll() + " / "
                    + reactList.getMedAmount(10) + " / "
                    + reactList.getMedAmount(100)), TextView.BufferType.NORMAL);
        }

        p2count.setText((this.getString(R.string.p2count) + "\n     "
                + twoplayer.playerOneCount() + " / "
                + twoplayer.playerTwoCount()), TextView.BufferType.NORMAL);

        p3count.setText((this.getString(R.string.p3count) + "\n     "
                + threeplayer.playerOneCount() + " / "
                + threeplayer.playerTwoCount() + " / "
                + threeplayer.playerThreeCount()), TextView.BufferType.NORMAL);

        p4count.setText((this.getString(R.string.p4count) + "\n     "
                + fourplayer.playerOneCount() + " / "
                + fourplayer.playerTwoCount() + " / "
                + fourplayer.playerThreeCount() + " / "
                + fourplayer.playerFourCount()), TextView.BufferType.NORMAL);

        //moves to ClearActivity when pressed
        Button clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StatViewActivity.this, ClearActivity.class);
                startActivity(intent);
            }
        });

        //moves to EmailActivity when pressed
        Button email = (Button) findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StatViewActivity.this, EmailActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stat_view, menu);
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
