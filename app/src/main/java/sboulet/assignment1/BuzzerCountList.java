package sboulet.assignment1;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

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

public class BuzzerCountList {
    private String filename;
    private Context context;
    private ArrayList<String> buzzerCounts;
    private Iterator<String> it;

    //load ArrayList<String> from file
    public BuzzerCountList(Context context, String mode) {
        filename = mode;
        this.context = context;
        buzzerCounts = new ArrayList<String>();
        try {
            FileInputStream fis = context.openFileInput(filename);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            // Taken from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 2015-10-2
            Type listType = new TypeToken<ArrayList<String>>() {}.getType();
            buzzerCounts = gson.fromJson(in, listType);
        } catch (FileNotFoundException e) {
            buzzerCounts = new ArrayList<String>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(String player) {
        buzzerCounts.add(player);
        try {
            FileOutputStream fos = context.openFileOutput(filename, 0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(buzzerCounts, writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getMode() {
        return filename;
    }

    //open filestream and delete file
    public void clear() {
        try {
            FileOutputStream fos = context.openFileOutput(filename, 0);
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        context.deleteFile(filename);
    }

    public int playerOneCount() {
        it = buzzerCounts.iterator();
        int count = 0;
        while (it.hasNext()) {
            if (it.next().equals("Player 1")) {
                count++;
            }
        }
        return count;
    }

    public int playerTwoCount() {
        it = buzzerCounts.iterator();
        int count = 0;
        while (it.hasNext()) {
            if (it.next().equals("Player 2")) {
                count++;
            }
        }
        return count;
    }

    public int playerThreeCount() {
        it = buzzerCounts.iterator();
        int count = 0;
        while (it.hasNext()) {
            if (it.next().equals("Player 3")) {
                count++;
            }
        }
        return count;
    }

    public int playerFourCount() {
        it = buzzerCounts.iterator();
        int count = 0;
        while (it.hasNext()) {
            if (it.next().equals("Player 4")) {
                count++;
            }
        }
        return count;
    }
}
