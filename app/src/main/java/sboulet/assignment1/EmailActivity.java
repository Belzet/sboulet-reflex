package sboulet.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

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

        //prevent computation of data that is too small or doesn't exist, but allow player counts
        if (reactList.size() == 0 || reactList.size() == 1) {
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
