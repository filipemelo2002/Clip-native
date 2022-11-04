package com.clip.Clip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.clip.Clip.domain.Group;
import com.clip.Clip.service.GlobalContext;


public class MainActivity extends AppCompatActivity {

    Spinner typeSpinner;

    EditText descriptionField;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        typeSpinner = findViewById(R.id.type_spinner);
        ArrayAdapter<CharSequence> typeSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.types_array, android.R.layout.simple_spinner_item);
        typeSpinner.setAdapter(typeSpinnerAdapter);

        descriptionField = findViewById(R.id.group_description);
    }

    public void createGroup(View view) {
        String description = descriptionField.getText().toString();
        String type = typeSpinner.getSelectedItem().toString();
        if (description.length() == 0) {
            toast = Toast.makeText(getApplicationContext(),  getResources().getString(R.string.non_empty_field), Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if (type.length() == 0) {
            toast = Toast.makeText(getApplicationContext(),  getResources().getString(R.string.non_empty_field), Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        GlobalContext.getInstance().addGroup(new Group(description, type));

        Intent intent = new Intent(MainActivity.this, GroupList.class);

        startActivity(intent);

        descriptionField.getText().clear();
        typeSpinner.setSelection(0);
    }

}