package fi.arcada.sos22_1_raknare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView outputText;
    EditText inputText;

    double[] values = {1, 2.5, 3.5, 9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Koppling mellan XML layout och koden
        outputText = findViewById(R.id.outputText);
        inputText = findViewById(R.id.editTextName);

        outputText.setText("...");
    }

    public void buttonHandler(View view) {
        //Avläser text fältet och omvandlar editable objektet till en string
        String namn = inputText.getText().toString();

        outputText.setText(String.format("Medelvärde: %.2f", Statistics.calculateMean(values)));
    }

}