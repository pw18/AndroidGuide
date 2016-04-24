package com.example.Mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.model.DiseasesModel;

import java.util.ArrayList;
import java.util.List;

public class CRUD {
	DatabaseGuide connect_db;
	SQLiteDatabase db;
	
	public CRUD(Context context) {
		connect_db =new DatabaseGuide(context);
		db = connect_db.getWritableDatabase();
	}
	
	public long createUser(String user,String pass){
		ContentValues values = new ContentValues();
		values.put("Username" , user);
		values.put("Password" , pass);
		return db.insert(connect_db.DB_TABLE_ADMIN, null, values);
	}

	public List<DiseasesModel> selectDiseasesAll(){
		List<DiseasesModel> data = new ArrayList<>();
		String query = "SELECT * FROM "+DatabaseGuide.DB_TABLE_Diseases;
		Cursor cursor = db.rawQuery(query, null);
		if(cursor.moveToFirst()){
			if(cursor.getCount() != 0){
				do{
					DiseasesModel model = new DiseasesModel();
					model.setName(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_DisName)));
					model.setSysptom(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_DisSysptom)));
					model.setCause(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_DisCause)));
					model.setSysptomInstant(cursor.getString(cursor.getColumnIndex(DatabaseGuide.DB_DisSysptomInstant)));

					data.add(model);
				}while (cursor.moveToNext());
			}
		}

		return data;
	}



}
