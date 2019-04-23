package android.the.coding.archer.multipaneapp;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.the.coding.archer.multipaneapp.data.Animal;
import android.the.coding.archer.multipaneapp.fragment.AnimalDetailFragment;
import android.the.coding.archer.multipaneapp.fragment.AnimalListFragment;

public class MainActivity extends FragmentActivity implements AnimalListFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null)
            return;

        AnimalListFragment animalListFragment = new AnimalListFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.framelayout_left, animalListFragment);

        if (findViewById(R.id.framelayout_right) != null) {
            Animal animal = new Animal();
            animal.setName("Penguin");
            animal.setImageUrl("http://www.emperor-penguin.com/penguin-chick.jpg");
            animal.setDescription("Penguin Penguin Penguin Penguin Penguin Penguin Penguin Penguin Penguin Penguin Penguin Penguin Penguin ");

            Bundle bundle = new Bundle();
            bundle.putSerializable("animal", animal);

            AnimalDetailFragment animalDetailFragment = new AnimalDetailFragment();
            animalDetailFragment.setArguments(bundle);
            fragmentTransaction.add(R.id.framelayout_right, animalDetailFragment);
        }

        fragmentTransaction.commit();
    }

    @Override
    public void onAnimalSelected(Animal animal) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        int containerViewId = R.id.framelayout_left;

        if (findViewById(R.id.framelayout_right) != null)
            containerViewId = R.id.framelayout_right;

        Bundle bundle = new Bundle();
        bundle.putSerializable("animal", animal);

        AnimalDetailFragment animalDetailFragment = new AnimalDetailFragment();
        animalDetailFragment.setArguments(bundle);
        fragmentTransaction.replace(containerViewId, animalDetailFragment);

        if (findViewById(R.id.framelayout_right) == null)
            fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }
}
