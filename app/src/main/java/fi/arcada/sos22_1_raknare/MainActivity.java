package fi.arcada.sos22_1_raknare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView outputText;
    EditText inputText;
    RecyclerView recyclerView;

    ArrayList<DataItem> dataItems = new ArrayList<>();
    ArrayList<Double> values = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataItems = Statistics.getSampleData();

        for (DataItem item : Statistics.getSampleData()) {
            values.add(item.getValue());
        }

        //Koppling mellan XML layout och koden
        outputText = findViewById(R.id.outputText);
        inputText = findViewById(R.id.editTextName);
        recyclerView = findViewById(R.id.dataItemsRecyclerView);

        CustomAdapter adapter = new CustomAdapter(this, dataItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //HashMap-exempel
        HashMap<String, Double> cities = new HashMap<>();
        cities.put("Helsingfors", 658457.0);
        cities.put("Esbo", 297132.0);

        HashMap<String, DataItem> cityItems = new HashMap<>();
        cityItems.put("sbo", new DataItem("Esbo", 297132.0));


        outputText.setText("...");
    }

    public void buttonHandler(View view) {
        //Avläser text fältet och omvandlar editable objektet till en string
        String namn = inputText.getText().toString();

        outputText.setText(String.format("Medelvärde: %.2f\nMedian: %.2f\nStandardavvikelse: %.2f",
                Statistics.calculateMean(values),
                Statistics.calculateMedian(values),
                Statistics.calculateSD(values)
        ));
    }
}