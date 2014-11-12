package com.example.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DairyDataSource {

  // Database fields
  private SQLiteDatabase database;
  private MySQLiteHelper dbHelper;
  private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
      MySQLiteHelper.COLUMN_WEIGHT, MySQLiteHelper.COLUMN_LENGTH, MySQLiteHelper.COLUMN_GIRTH };

  public DairyDataSource(Context context) {
    dbHelper = new MySQLiteHelper(context);
  }

  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase();
  }

  public void close() {
    dbHelper.close();
  }

  public Dairy createDairy(String weight, String length, String girth) {
    ContentValues values = new ContentValues();
    values.put(MySQLiteHelper.COLUMN_WEIGHT, weight);
    values.put(MySQLiteHelper.COLUMN_LENGTH, length);
    values.put(MySQLiteHelper.COLUMN_GIRTH, girth);
    long insertId = database.insert(MySQLiteHelper.TABLE_DAIRY, null,
        values);
    Cursor cursor = database.query(MySQLiteHelper.TABLE_DAIRY,
        allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
        null, null, null);
    cursor.moveToFirst();
    Dairy newDairy = cursorToDairy(cursor);
    cursor.close();
    return newDairy;
  }

  public void deleteComment(Dairy dairy) {
    long id = dairy.getId();
    System.out.println("Comment deleted with id: " + id);
    database.delete(MySQLiteHelper.TABLE_DAIRY, MySQLiteHelper.COLUMN_ID
        + " = " + id, null);
  }

  public List<Dairy> getAllComments() {
    List<Dairy> dairys = new ArrayList<Dairy>();

    Cursor cursor = database.query(MySQLiteHelper.TABLE_DAIRY,
        allColumns, null, null, null, null, null);

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      Dairy dairy = cursorToDairy(cursor);
      dairys.add(dairy);
      cursor.moveToNext();
    }
    // make sure to close the cursor
    cursor.close();
    return dairys;
  }

  private Dairy cursorToDairy(Cursor cursor) {
    Dairy dairy = new Dairy();
    dairy.setId(cursor.getLong(0));
    dairy.setWeight(cursor.getString(1));
    dairy.setLength(cursor.getString(2));
    dairy.setGirth(cursor.getString(3));
    return dairy;
  }
} 
