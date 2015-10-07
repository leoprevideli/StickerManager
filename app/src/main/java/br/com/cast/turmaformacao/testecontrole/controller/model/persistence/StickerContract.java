package br.com.cast.turmaformacao.testecontrole.controller.model.persistence;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.testecontrole.controller.model.entities.Sticker;

public class StickerContract {

    public static final String TABLE = "sticker";
    public static final String NUMBER = "number";
    public static final String NAME = "name";
    public static final String AMOUNT = "amount";

    public static final String[] COLUMNS = { NUMBER, NAME, AMOUNT };

    public static String getCreateTableScript(){
        StringBuilder sql = new StringBuilder();
        sql.append(" CREATE TABLE ");
        sql.append(TABLE);
        sql.append(" ( ");
        sql.append(NUMBER + " INTEGER PRIMARY KEY, ");
        //TODO Colocar campo 'name' como NOT NULL
        sql.append(NAME + " TEXT, ");
        sql.append(AMOUNT + " INTEGER ");
        sql.append(" ); ");
        return sql.toString();
    }

    public static ContentValues getContentValues(Sticker sticker){
        ContentValues values = new ContentValues();
        values.put(StickerContract.NUMBER, sticker.getNumber());
        values.put(StickerContract.NAME, sticker.getName());
        values.put(StickerContract.AMOUNT, sticker.getAmount());
        return  values;
    }

    public static Sticker getSticker(Cursor cursor) {
        if (!cursor.isBeforeFirst() || cursor.moveToNext()) {
            Sticker sticker = new Sticker();
            sticker.setNumber(cursor.getLong(cursor.getColumnIndex(NUMBER)));
            sticker.setName(cursor.getString(cursor.getColumnIndex(NAME)));
            sticker.setAmount(cursor.getInt(cursor.getColumnIndex(AMOUNT)));
            return sticker;
        }
        return null;
    }

    public static List<Sticker> getStickers(Cursor cursor){
        ArrayList<Sticker> values = new ArrayList<>();
        while (cursor.moveToNext()) {
            values.add(getSticker(cursor));
        }
        return values;
    }

    public static String insertStickers(){
        StringBuilder sql = new StringBuilder();
        for(int i = 0; i <= 10; i++){
            sql.append(" INSERT INTO ");
            sql.append(TABLE);
            sql.append(" ( ");
            sql.append(NUMBER + ", ");
            sql.append(NAME + ", ");
            sql.append(AMOUNT);
            sql.append(" ) ");
            sql.append(" VALUES ");
            sql.append(" ( ");
            sql.append(i + ", ");
            sql.append("'" + "Name " + i + "'" + ", ");
            sql.append("'" + (i*2) +"'");
            sql.append(" ); ");
        }
        return sql.toString();
    }
}
