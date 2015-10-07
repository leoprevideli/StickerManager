package br.com.cast.turmaformacao.testecontrole.controller.model.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.cast.turmaformacao.testecontrole.controller.util.ApplicationUtil;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "stickersmanagerdb";
    private static final int DATABASE_VERSION = 1;

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getInstance() {
        return new DatabaseHelper(ApplicationUtil.getContext());
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(StickerContract.getCreateTableScript());
        sqLiteDatabase.execSQL(StickerContract.insertStickers());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
