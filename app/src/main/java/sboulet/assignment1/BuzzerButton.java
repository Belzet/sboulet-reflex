package sboulet.assignment1;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ToggleButton;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

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
public class BuzzerButton {

    //button used in Singleplayer mode

    private ToggleButton buzzer;
    private ReactionTimeList reactList;
    private ReactionTime react;

    public BuzzerButton(ToggleButton toggle, Context context) {
        buzzer = toggle;
        buzzer.setText(null);
        buzzer.setTextOff(null);
        buzzer.setTextOn(null);
        react = new ReactionTime();
        reactList = new ReactionTimeList(context);
    }

    //set to default state
    public void setGrey(Context context) {
        buzzer.setBackground(ContextCompat.getDrawable(context, R.drawable.unselected_state));
    }

    //set to clickable state
    public void setRed(Context context) {
        buzzer.setBackground(ContextCompat.getDrawable(context, R.drawable.selected_state));
    }

    //set what happens if user clicks while still grey
    public void clickTooEarly(final Context context) {
        buzzer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                PopUp tooFast = new PopUp("Too early! Wait until the buzzer turns red!", "OK", context);
                tooFast.show();
            }
        });
    }

    //set what happens when the user clicks during red, clickable state
    public void clickOnTime(final Context context) {
        buzzer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //get time at click
                react.setReactionTime(System.currentTimeMillis());
                //add endTime - startTime to reactList
                reactList.addTime(react.getReactionTime());
                //confirm to user that they clicked and display time
                PopUp success = new PopUp(react.getReactionTime(), "OK", context);
                success.show();
            }
        });
    }

    public void makeClickable(final Context context, final BuzzerButton button) {
        //after a random time between 10 and 2000 ms
        //allow user to click on the button
        Handler handler = new Handler() {
            @Override
            public void close() {

            }

            @Override
            public void flush() {

            }

            @Override
            public void publish(LogRecord record) {

            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //signal to user to click as fast as they can
                button.setRed(context);
                react.setStartTime();
                button.clickOnTime(context);
            }
        };
        buzzer.postDelayed(runnable, react.getRandomTime());
    }
}
