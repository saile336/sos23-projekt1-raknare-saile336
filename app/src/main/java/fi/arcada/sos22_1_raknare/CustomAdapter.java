package fi.arcada.sos22_1_raknare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    Context context;
    ArrayList<DataItem> dataItems;

    //Konstruktor
    public CustomAdapter(Context context, ArrayList<DataItem> dataItems) {
        this.context = context;
        this.dataItems = dataItems;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_row, parent, false);
        return new ViewHolder(view);
    }

    //Ger nya värden åt de list-items som ska in på skärmen
    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        DataItem item = dataItems.get(position);
        holder.name.setText(item.getName());
        holder.value.setText(String.format("%2f", item.getValue())); //Set text vill ha en string!
    }

    //Håller reda på antalet items i the dataset
    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    //Holder klassen beskriver ett enskilt element i RecyclerView:n
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView value;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.dataItemName);
            value = itemView.findViewById(R.id.dataItemValue);
        }
    }
}
