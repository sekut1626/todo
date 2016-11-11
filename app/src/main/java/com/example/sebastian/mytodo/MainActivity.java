package com.example.sebastian.mytodo;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sebastian.mytodo.db.CursorDb;
import com.example.sebastian.mytodo.db.TaskDbHelper;

import java.security.PublicKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TaskDbHelper dbHelper;
    private ListView mTaskListView;
    private ArrayAdapter<String> mAdapter;
    private EditText taskNameEditText;
    private CheckBox checkBoxStar;
    private Spinner spinner;
    private int stateOfStar = 0;
    private int stateOfPriority = 0;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initControls();
        initDB();
        updateListView();
        listapriorytetow();
    }

    public void listapriorytetow() {

        ArrayList<ItemData> list = new ArrayList<>();
        list.add(new ItemData("normalny", R.drawable.jeden));
        list.add(new ItemData("ważny", R.drawable.dwa));
        list.add(new ItemData("pilny", R.drawable.trzy));

        SpinnerAdapter adapter = new CustomAdapterSpinner(this, R.layout.spinner_layout, R.id.txt, list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        stateOfPriority = 0;
                        Toast.makeText(parent.getContext(), "zadanie NORMALNE", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        stateOfPriority = 1;
                        Toast.makeText(parent.getContext(), "zadanie WAŻNE", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        stateOfPriority = 2;
                        Toast.makeText(parent.getContext(), "zadanie PILNE", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initControls() {

        checkBoxStar = (CheckBox) findViewById(R.id.checkBox1);
        mTaskListView = (ListView) findViewById(R.id.list_todo);
        taskNameEditText = (EditText) findViewById(R.id.taketask);
        spinner = (Spinner) findViewById(R.id.spinner);
    }

    private void initDB() {

        dbHelper = new TaskDbHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        }
        return true;
    }

    private void setUpAlertDialogForMenu() {

        final EditText taskEditText = new EditText(this);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Add a new task")
                .setMessage("What do you want to do next?")
                .setView(taskEditText)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String task = String.valueOf(taskEditText.getText());
                        dbHelper.addTask(task);
                        updateListView();
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
    }

    public void addData(View view) {

        String task = String.valueOf(taskNameEditText.getText());
        int stateOfStar = this.stateOfStar;
        dbHelper.addTaskWithStar(task, stateOfStar);

        taskNameEditText.getText().clear();
        updateListView();

    }

    public void deleteTask(View view) {
        View parent = (View) view.getParent();
        TextView taskTextView = (TextView) parent.findViewById(R.id.task_title);
        String taskName = String.valueOf(taskTextView.getText());
        dbHelper.deleteTask(taskName);
        updateListView();
    }

    private void updateListView() {

        Cursor cursor = dbHelper.getDataForListView();
        CursorDb cursorAdapter = new CursorDb(this, cursor, 0);

        mTaskListView.setAdapter(cursorAdapter);
    }

    public void setCheckBoxStar(View view) {

        if (checkBoxStar.isChecked()) {
            Toast.makeText(getBaseContext(), " YES", Toast.LENGTH_LONG).show();
            stateOfStar = 1;
        } else {
            Toast.makeText(getBaseContext(), " kurwa", Toast.LENGTH_LONG).show();
            stateOfStar = 0;
        }
    }

}
