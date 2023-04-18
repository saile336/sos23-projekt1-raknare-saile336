package fi.arcada.sos22_1_raknare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView outputText;
    EditText inputText, inputValue;
    RecyclerView recyclerView;
    CustomAdapter adapter;

    ArrayList<DataItem> dataItems = new ArrayList<>();
    ArrayList<Double> values = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Koppling mellan XML layout och koden
        outputText = findViewById(R.id.outputText);
        inputText = findViewById(R.id.editTextName);
        inputValue = findViewById(R.id.dataValue);
        recyclerView = findViewById(R.id.dataItemsRecyclerView);

        adapter = new CustomAdapter(this, dataItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void buttonHandler(View view) {

        if (TextUtils.isEmpty(inputValue.getText())) return;

        dataItems.add(new DataItem(inputText.getText().toString(),
                Double.parseDouble(inputValue.getText().toString())));

        // Uppdatera recyclerView:en
        adapter.notifyDataSetChanged();

        // Skapa values-arraylist med endast värden
        ArrayList<Double> values = new ArrayList<>();
        for (DataItem item: dataItems) {
            values.add(item.getValue());
        }

        // Kolla att det finns tillräckligt med värden att räkna ut
        if (values.size() < 3) {
            outputText.setText("Mera data behövs...");
            return;
        }

        outputText.setText(String.format("Min värde: %.2f\nMax värde: %.2f\nMedelvärde: %.2f\nMedian: %.2f\nTypvärde: %.2f\nStandardavvikelse: %.2f",
                Statistics.calcMin(values),
                Statistics.calcMax(values),
                Statistics.calcAverage(values),
                Statistics.calcMedian(values),
                Statistics.calcMode(values),
                Statistics.calcStDev(values)
        ));
    }
}