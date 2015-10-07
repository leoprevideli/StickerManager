package br.com.cast.turmaformacao.testecontrole.controller.model.persistence;

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
}
