package br.com.cast.turmaformacao.testecontrole.controller.controller.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.testecontrole.R;
import br.com.cast.turmaformacao.testecontrole.controller.controller.adapters.StickerListAdapter;
import br.com.cast.turmaformacao.testecontrole.controller.model.entities.Sticker;
import br.com.cast.turmaformacao.testecontrole.controller.model.services.StickerBusinessService;


public class StickerListActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticker_list);

        bindRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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

    private void bindRecyclerView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewStickers);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        StickerListAdapter adapter = new StickerListAdapter(StickerBusinessService.getAll(), this);
        mRecyclerView.setAdapter(adapter);
    }
}
