package br.com.cast.turmaformacao.testecontrole.controller.model.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.com.cast.turmaformacao.testecontrole.controller.model.entities.Sticker;

public class StickerRepository {

    public static List<Sticker> getAll() {

        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        Cursor cursor = db.query(StickerContract.TABLE, StickerContract.COLUMNS, null, null, null, null, null);
        List<Sticker> contacts = StickerContract.getStickers(cursor);

        db.close();
        databaseHelper.close();
        return contacts;
    }

    public static void saveSticker(Sticker sticker) {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = StickerContract.getContentValues(sticker);
        if (sticker.getNumber() == null) {
            db.insert(StickerContract.TABLE, null, values);
        } else {
            String where = StickerContract.NUMBER + " = ? ";
            String[] params = {sticker.getNumber().toString()};
            db.update(StickerContract.TABLE, values, where, params);
        }
    }
}
