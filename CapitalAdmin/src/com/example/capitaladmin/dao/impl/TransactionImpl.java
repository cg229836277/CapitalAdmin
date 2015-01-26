package com.example.capitaladmin.dao.impl;

import com.example.capitaladmin.dao.Transaction;

import android.database.sqlite.SQLiteDatabase;

class TransactionImpl implements Transaction {

	private SQLiteDatabase sqLiteDatabase;

	public TransactionImpl(SQLiteDatabase sqLiteDatabase) {
		this.sqLiteDatabase = sqLiteDatabase;
	}

	@Override
	public void beginTransaction() {
		sqLiteDatabase.beginTransaction();
	}

	@Override
	public void commit() {
		sqLiteDatabase.setTransactionSuccessful();
	}

	@Override
	public void endTransaction() {
		sqLiteDatabase.endTransaction();
	}

}
