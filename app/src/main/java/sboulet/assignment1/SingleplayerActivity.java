package sboulet.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ToggleButton;

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
        ToggleButton toggle = (ToggleButton) findViewById(R.id.greybuzzer);
        BuzzerButton buzzer = new BuzzerButton(toggle, SingleplayerActivity.this);

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
