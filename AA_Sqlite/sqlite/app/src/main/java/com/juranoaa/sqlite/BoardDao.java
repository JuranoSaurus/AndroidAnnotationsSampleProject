package com.juranoaa.sqlite;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SungGeun on 2015-10-10.
 */
public class BoardDao {

    public static final String COLS_BOARD_ARR[] = {
            BoardProvider.COL_ID,
            BoardProvider.COL_TITLE
    };

    private BoardDao() {}

    /**
     * Insert new Board to DB.
     */
    public static void insertNewBoard(Context ctx, Board board) {
        ContentValues Values = new ContentValues();
        ContentResolver cr = ctx.getContentResolver();

        Values.put(BoardProvider.COL_TITLE, board.getTitle());

        cr.insert(BoardProvider.CONTENT_URI_BOARD, Values);
    }

    public static List<Board> getAllBoards(Context ctx) {
        List<Board> boards = new ArrayList<Board>();

        ContentResolver cr = ctx.getContentResolver();
        Cursor c = cr.query(BoardProvider.CONTENT_URI_BOARD,
                COLS_BOARD_ARR, null, null, null);

        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            while (c.isAfterLast() == false) {
                boards.add(new Board(
                        c.getInt(c.getColumnIndex(BoardProvider.COL_ID)),
                        c.getString(c.getColumnIndex(BoardProvider.COL_TITLE))));
                //LogUtil.w("map.put(" + uid + "," + persona_name+ ")");
                c.moveToNext();
            }
        }
        c.close();

        return boards;
    }

    public static Board getBoardById(Context ctx, int id) {
        Board board = null;

        ContentResolver cr = ctx.getContentResolver();
        Cursor c = cr.query(BoardProvider.CONTENT_URI_BOARD,
                COLS_BOARD_ARR, BoardProvider.COL_ID + "=?",
                new String[]{String.valueOf(id)}, null);
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            while (c.isAfterLast() == false) {
                board = new Board(
                        c.getInt(c.getColumnIndex(BoardProvider.COL_ID)),
                        c.getString(c.getColumnIndex(BoardProvider.COL_TITLE)));
                c.moveToNext();
            }
        }
        c.close();

        return board;
    }
}