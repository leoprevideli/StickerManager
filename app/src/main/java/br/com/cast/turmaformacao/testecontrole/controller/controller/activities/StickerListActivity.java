package br.com.cast.turmaformacao.testecontrole.controller.controller.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.testecontrole.R;
import br.com.cast.turmaformacao.testecontrole.controller.controller.adapters.StickerGridViewAdapter;
import br.com.cast.turmaformacao.testecontrole.controller.controller.adapters.StickerListAdapter;
import br.com.cast.turmaformacao.testecontrole.controller.model.entities.Sticker;
import br.com.cast.turmaformacao.testecontrole.controller.model.services.StickerBusinessService;


public class StickerListActivity extends AppCompatActivity {

    GridView gridviewStickers;
    List<Sticker> gridArray = new ArrayList<Sticker>();
    StickerGridViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticker_list_gridview);

        gridArray = StickerBusinessService.getAll();
        gridviewStickers = (GridView) findViewById(R.id.gridViewStickers);
        adapter = new StickerGridViewAdapter(this, R.layout.sticker_gridview_item, gridArray);
        gridviewStickers.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_stickers_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
