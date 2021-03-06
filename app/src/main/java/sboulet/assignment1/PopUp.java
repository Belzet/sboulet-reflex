package sboulet.assignment1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

/*************************************************************************
 * This code is provided under Attribution ShareAlike 3.0 (CC BY-SA 3.0) *
 * Full license here : http://creativecommons.org/licenses/by-sa/3.0/    *
 * (C) 2012 Mahesh on StackOverflow.com                                  *
 * http://stackoverflow.com/posts/13511580/revisions                     *
 *************************************************************************/

public class PopUp {
    private AlertDialog.Builder builder1;
    private AlertDialog alert11;

    public PopUp(String message, String positive, final Context context) {
        builder1 = new AlertDialog.Builder(context);
        builder1.setMessage(message);
        builder1.setCancelable(false);
        builder1.setPositiveButton(positive,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        //allows SingleplayerActivity to move past instructional popup
                        SingleplayerActivity.initial = true;
                        Intent intent = new Intent(context, SingleplayerActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        context.startActivity(intent);
                    }
                });
    }

    public PopUp(long reaction, String positive, final Context context) {
        builder1 = new AlertDialog.Builder(context);
        builder1.setMessage(String.valueOf(reaction));
        builder1.setCancelable(false);
        builder1.setPositiveButton(positive,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        //call on resume() SingleplayerActivity to reset button to original state
                        Intent intent = new Intent(context, SingleplayerActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        context.startActivity(intent);
                    }
                });
    }

    public PopUp(String message, final Context context) {
        builder1 = new AlertDialog.Builder(context);
        builder1.setMessage(message);
        builder1.setCancelable(true);
    }

    public void show() {
        alert11 = builder1.create();
        alert11.show();
    }

}
