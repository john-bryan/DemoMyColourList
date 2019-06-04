package sg.edu.rp.c346.demomycolourlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etColour;
    EditText etPos;
    Button btnAddColour;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etColour = findViewById(R.id.editTextColour);
        btnAddColour = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        etPos = findViewById(R.id.editTextPosition);

        alColours = new ArrayList<String>();

        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAddColour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPos.getText().toString().equals("")) {
                    String value = etColour.getText().toString();
                    alColours.add(value);
                    aaColour.notifyDataSetChanged();
                }
                else {
                    Integer pos = Integer.parseInt(etPos.getText().toString());
                    String value = etColour.getText().toString();
                    alColours.add(pos,value);
                    aaColour.notifyDataSetChanged();
                }
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_LONG).show();
            }
        });



    }
}
