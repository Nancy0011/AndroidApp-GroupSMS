package au.edu.tafesa.itstudies.groupsms.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import au.edu.tafesa.itstudies.groupsms.R;
import android.util.Log;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EditMessage extends Activity {

    public static final String CLASS_TAG = "EditMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(CLASS_TAG, "onCreate ...");
        setContentView(R.layout.activity_edit_message);
        // Get the intent for this activity. Every activity has an intent and
        // set the EditText contents to the string in the extra info that comes with
        // the intent
        Intent editIntent;
        EditText etMessage;
        editIntent = this.getIntent();
        String theMessage;
        theMessage = editIntent.getStringExtra("CURRENT_MESSAGE");
        etMessage = (EditText) this.findViewById(R.id.editText1);
        etMessage.setText(theMessage);

        // Get an event handler going for the Done button so that we can return the
        // new message
        Button btnDone = (Button) this.findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new ButtonDoneOnClickHandler());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_message, menu);

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
    /**
     * Handles the Button Done onClick event by creating a resulting Intent and
     * finishing
     *
     * @author sruiz
     *
     */
    private class ButtonDoneOnClickHandler implements OnClickListener {

        public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra("NEW_MESSAGE", ((EditText) findViewById(R.id.editText1)).getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }

    }

}
