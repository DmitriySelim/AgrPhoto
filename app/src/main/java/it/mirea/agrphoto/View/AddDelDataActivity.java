package it.mirea.agrphoto.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import it.mirea.agrphoto.R;

public class AddDelDataActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE =
            "it.mirea.agrphoto.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTIONS =
            "it.mirea.agrphoto.EXTRA_DESCRIPTIONS";
    public static final String EXTRA_DATE =
            "it.mirea.agrphoto.EXTRA_DATE";
    public static final String EXTRA_PRIORITY =
            "it.mirea.agrphoto.EXTRA_PRIORITY";

    private EditText editTitle;
    private EditText editDescription;
    private EditText editDate;
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_del_data);

        editTitle = findViewById(R.id.editTitle);
        editDescription = findViewById(R.id.editDescription);
        editDate = findViewById(R.id.editDate);
        numberPicker = findViewById(R.id.number_picker_priority);

        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(15);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Добавить объявление");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.save_note_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveNote() {
        String title = editTitle.getText().toString();
        String descriptions = editDescription.getText().toString();
        String date = editDate.getText().toString();
        int priority = numberPicker.getValue();

        if(title.trim().isEmpty() || descriptions.trim().isEmpty() || date.trim().isEmpty())
        {
            Toast.makeText(this,"Пожалуйста введите все необходимые данные",Toast.LENGTH_LONG).show();
        }

        Intent usesData = new Intent();
        usesData.putExtra(EXTRA_TITLE,title);
        usesData.putExtra(EXTRA_DESCRIPTIONS,descriptions);
        usesData.putExtra(EXTRA_DATE,date);
        usesData.putExtra(EXTRA_PRIORITY,priority);

        setResult(RESULT_OK, usesData);
        finish();


    }
}
