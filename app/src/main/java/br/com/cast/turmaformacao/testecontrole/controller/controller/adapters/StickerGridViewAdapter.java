package br.com.cast.turmaformacao.testecontrole.controller.controller.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.testecontrole.R;
import br.com.cast.turmaformacao.testecontrole.controller.model.entities.Sticker;

public class StickerGridViewAdapter extends ArrayAdapter<Sticker> {

    Context context;
    int layoutResourceId;
    List<Sticker> data = new ArrayList<Sticker>();

    public StickerGridViewAdapter(Context context, int layoutResourceId, List<Sticker> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RecordHolder();
            holder.textViewNumber = (TextView) row.findViewById(R.id.textViewNumber);
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }

        Sticker sticker = data.get(position);
        holder.textViewNumber.setText(sticker.getNumber().toString());
        return row;

    }

    private static class RecordHolder {
        TextView textViewNumber;
    }

}
