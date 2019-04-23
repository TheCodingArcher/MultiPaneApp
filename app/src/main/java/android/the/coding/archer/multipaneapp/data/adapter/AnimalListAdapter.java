package android.the.coding.archer.multipaneapp.data.adapter;

import android.content.Context;
import android.the.coding.archer.multipaneapp.data.Animal;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AnimalListAdapter extends BaseAdapter {

    List<Animal> animalList;
    Context context;

    public AnimalListAdapter(Context context, List<Animal> animalList) {
        this.context = context;
        this.animalList = animalList;
    }

    @Override
    public int getCount() {
        return animalList == null ? 0 : animalList.size();
    }

    @Override
    public Object getItem(int position) {
        return animalList == null ? null : animalList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null)
            view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, null);

        Animal animal = (Animal) getItem(position);
        TextView nameTextView = view.findViewById(android.R.id.text1);
        nameTextView.setText(animal.getName());

        return view;
    }
}
