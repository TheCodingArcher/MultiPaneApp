package android.the.coding.archer.multipaneapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.the.coding.archer.multipaneapp.R;
import android.the.coding.archer.multipaneapp.data.Animal;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class AnimalDetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animal_detail, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        
        if (bundle.containsKey("animal")) {
            final Animal animal = (Animal) bundle.getSerializable("animal");
            final ImageView animalImageView = view.findViewById(R.id.imageview_animal);
            TextView descriptionTextView = view.findViewById(R.id.textview_description);
            
            Picasso.get().load(animal.getImageUrl()).placeholder(R.drawable.draw1).into(animalImageView);
            descriptionTextView.setText(animal.getDescription());
        }
    }
}
