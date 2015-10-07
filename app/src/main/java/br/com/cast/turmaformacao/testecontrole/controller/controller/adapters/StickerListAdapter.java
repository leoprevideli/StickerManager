package br.com.cast.turmaformacao.testecontrole.controller.controller.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import br.com.cast.turmaformacao.testecontrole.R;
import br.com.cast.turmaformacao.testecontrole.controller.model.entities.Sticker;

public class StickerListAdapter extends RecyclerView.Adapter<StickerListAdapter.ViewHolder> {

    private List<Sticker> stickerList;
    private Context context;

    public StickerListAdapter(List<Sticker> stickerList, Context context) {
        this.context = context;
        this.stickerList = stickerList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sticker_list_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Sticker item = stickerList.get(i);
        viewHolder.textViewNumber.setText(item.getNumber().toString());
    }

    @Override
    public int getItemCount() {
        return stickerList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView textViewNumber;
        protected ImageButton buttonRemove;
        protected ImageButton buttonAdd;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewNumber = (TextView) itemView.findViewById(R.id.textViewNumber);
            buttonRemove = (ImageButton) itemView.findViewById(R.id.buttonRemove);
            buttonAdd = (ImageButton) itemView.findViewById(R.id.buttonAdd);
        }
    }

}
