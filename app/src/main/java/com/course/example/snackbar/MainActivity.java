package com.course.example.snackbar;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button simpleSnackbar = findViewById(R.id.buttonSimple);
        Button actionButtonSnackbar = findViewById(R.id.buttonAction);
        Button customViewSnackbar = findViewById(R.id.buttonCustomView);

        // Simple Snackbar code snippet
        simpleSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                // Make and display Snackbar
                Snackbar.make(getView(), "Android Snackbar Example", Snackbar.LENGTH_SHORT)
                        .show();
            }
        });

        actionButtonSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                // Make and display Snackbar
                Snackbar snackbar = Snackbar.make(getView(), "Message is deleted", Snackbar.LENGTH_LONG);
                // Set action text color
                snackbar.setActionTextColor(
                        //  ContextCompat.getColor(getBaseContext(), R.color.actionTextColor)
                        getResources().getColor(R.color.actionTextColor, null)
                );
                // ADD Action Click Retry Listener
                snackbar.setAction("Undo", new UndoListener());
                // show the Snackbar
                snackbar.show();
            }
        });

        customViewSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                // Make and display Snackbar
                Snackbar snackbar = Snackbar.make(getView(), "Style Text, Font and Action Color",
                        Snackbar.LENGTH_SHORT);

                // Set action text color
                snackbar.setActionTextColor(
                      //  ContextCompat.getColor(getBaseContext(), R.color.actionTextColor)
                        getResources().getColor(R.color.actionTextColor, null)
                );
                snackbar.setAction("Undo", new UndoListener());

                View snackbarView = snackbar.getView();
                TextView textView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
                // set no of text line
                textView.setMaxLines(2);
                //set text color
                textView.setTextColor(getResources().getColor(R.color.teal_700, null));
                //set text size
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                //Set Snackbar background color
                snackbarView.setBackgroundColor(getResources().getColor(R.color.colorBg, null));
                snackbar.show();
            }
        });
    }
 
    // Define the click listener
    private class UndoListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            // Code to undo the user's last action
            View contextView = findViewById(android.R.id.content);
            // Make and display Snackbar
            Snackbar.make(contextView, "Message restore", Snackbar.LENGTH_SHORT)
                    .show();
        }
    }

    /**
     * Return the instance of View
     *
     * @return CoordinatorLayout
     */
    public View getView() {
        return findViewById(android.R.id.content);
    }
}