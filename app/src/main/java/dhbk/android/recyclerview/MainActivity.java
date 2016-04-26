package dhbk.android.recyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // add recycler view on onCreate
        List<Data> data = fill_with_data();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getApplication());
        recyclerView.setAdapter(adapter);
//        These default implementations are available:
//
//        LinearLayoutManager – Displays items in a vertical or horizontal scrolling list.
//                GridLayoutManager – Displays items in a grid.
//                StaggeredGridLayoutManager – Displays items in a staggered grid.
//        You can create a custom LayoutManager by extending RecyclerView.LayoutManager or one of the implementations above and overriding the methods required.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        // animation recycler view, dò xem recycler của mình có action gì để hành động tương ứng
        // DefaultItemAnimator is a basic animation available by default with the RecyclerView.
        // slows down the process of adding and removing items from the RecyclerView.
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(itemAnimator);
    }


    public List<Data> fill_with_data() {
        List<Data> data = new ArrayList<>();
        data.add(new Data("Batman vs Superman", "Following the destruction of Metropolis, Batman embarks on a personal vendetta against Superman ", R.drawable.ic_action_movie));
        data.add(new Data("X-Men: Apocalypse", "X-Men: Apocalypse is an upcoming American superhero film based on the X-Men characters that appear in Marvel Comics ", R.drawable.ic_action_movie));
        data.add(new Data("Captain America: Civil War", "A feud between Captain America and Iron Man leaves the Avengers in turmoil.  ", R.drawable.ic_action_movie));
        data.add(new Data("Kung Fu Panda 3", "After reuniting with his long-lost father, Po  must train a village of pandas", R.drawable.ic_action_movie));
        data.add(new Data("Warcraft", "Fleeing their dying home to colonize another, fearsome orc warriors invade the peaceful realm of Azeroth. ", R.drawable.ic_action_movie));
        data.add(new Data("Alice in Wonderland", "Alice in Wonderland: Through the Looking Glass ", R.drawable.ic_action_movie));
        return data;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
