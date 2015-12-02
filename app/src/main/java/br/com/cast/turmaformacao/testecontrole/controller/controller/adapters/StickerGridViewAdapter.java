package br.com.cast.turmaformacao.testecontrole.controller.controller.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.testecontrole.R;
import br.com.cast.turmaformacao.testecontrole.controller.model.entities.Sticker;
import br.com.cast.turmaformacao.testecontrole.controller.model.services.StickerBusinessService;

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
        final RecordHolder holder;
        final Sticker sticker = data.get(position);
        if (row == null) {
            holder = new RecordHolder();
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

        } else {
            holder = (RecordHolder) row.getTag();
        } 

        holder.count = sticker.getAmount();
        holder.textViewNumber = (TextView) row.findViewById(R.id.textViewNumber);
        holder.textViewQuantity = (TextView) row.findViewById(R.id.textViewQuantity);
        holder.iv_logo_card = (ImageView) row.findViewById(R.id.iv_logo_card);
        holder.buttonAdd = (ImageButton) row.findViewById(R.id.buttonAdd);
        holder.buttonRemove = (ImageButton) row.findViewById(R.id.buttonRemove);
        holder.textViewQuantity.setText(sticker.getAmount().toString());
        paintQuantity(holder.count, holder, context);
        row.setTag(holder);

        holder.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.count != 99) {
                    holder.count++;
                }
                //holder.textViewQuantity.setText("" + holder.count);
                sticker.setAmount(holder.count);
                StickerBusinessService.saveSticker(sticker);
                holder.textViewQuantity.setText(sticker.getAmount().toString());
                paintQuantity(holder.count, holder, context);
            }
        });

        holder.buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.count != 0) {
                    holder.count--;
                }
                //holder.textViewQuantity.setText("" + holder.count);
                sticker.setAmount(holder.count);
                StickerBusinessService.saveSticker(sticker);
                holder.textViewQuantity.setText(sticker.getAmount().toString());
                paintQuantity(holder.count, holder, context);
            }
        });


        holder.textViewNumber.setText(sticker.getNumber().toString());
        //
        return row;

    }

    private static class RecordHolder {
        TextView textViewNumber;
        TextView textViewQuantity;
        ImageView iv_logo_card;
        ImageButton buttonAdd;
        ImageButton buttonRemove;
        int count;
    }

    public static void paintQuantity(int contador, RecordHolder holder, Context context){
        if(contador == 0){
            holder.textViewQuantity.setVisibility(View.INVISIBLE);
        }else if(contador == 1){
            holder.textViewQuantity.setVisibility(View.VISIBLE);
            holder.textViewQuantity.setTextColor(ContextCompat.getColor(context, R.color.material_green_500));
        }else if(contador > 1){
            holder.textViewQuantity.setTextColor(ContextCompat.getColor(context, R.color.material_amber_600));
        }
    }

}
