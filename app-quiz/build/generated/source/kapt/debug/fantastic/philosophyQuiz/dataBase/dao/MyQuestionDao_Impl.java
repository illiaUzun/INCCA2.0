package fantastic.philosophyQuiz.dataBase.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import fantastic.philosophyQuiz.dataBase.entity.MyQuestion;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class MyQuestionDao_Impl implements MyQuestionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfMyQuestion;

  private final SharedSQLiteStatement __preparedStmtOfDeleteMyQuestion;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllMyQuestions;

  public MyQuestionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMyQuestion = new EntityInsertionAdapter<MyQuestion>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `MyQuestions`(`id`,`Question`,`Answer_A`,`Answer_B`,`Answer_C`,`Answer_D`,`CorrectAnswer`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MyQuestion value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getQuestion() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getQuestion());
        }
        if (value.getAnswerA() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAnswerA());
        }
        if (value.getAnswerB() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAnswerB());
        }
        if (value.getAnswerC() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAnswerC());
        }
        if (value.getAnswerD() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAnswerD());
        }
        if (value.getCorrectAnswer() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCorrectAnswer());
        }
      }
    };
    this.__preparedStmtOfDeleteMyQuestion = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM MyQuestions WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllMyQuestions = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE  FROM MyQuestions";
        return _query;
      }
    };
  }

  @Override
  public void insert(MyQuestion myQuestion) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfMyQuestion.insert(myQuestion);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteMyQuestion(long id) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteMyQuestion.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, id);
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteMyQuestion.release(_stmt);
    }
  }

  @Override
  public void deleteAllMyQuestions() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllMyQuestions.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllMyQuestions.release(_stmt);
    }
  }

  @Override
  public List<MyQuestion> getAllMyQuestions() {
    final String _sql = "SELECT * FROM MyQuestions";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfQuestion = _cursor.getColumnIndexOrThrow("Question");
      final int _cursorIndexOfAnswerA = _cursor.getColumnIndexOrThrow("Answer_A");
      final int _cursorIndexOfAnswerB = _cursor.getColumnIndexOrThrow("Answer_B");
      final int _cursorIndexOfAnswerC = _cursor.getColumnIndexOrThrow("Answer_C");
      final int _cursorIndexOfAnswerD = _cursor.getColumnIndexOrThrow("Answer_D");
      final int _cursorIndexOfCorrectAnswer = _cursor.getColumnIndexOrThrow("CorrectAnswer");
      final List<MyQuestion> _result = new ArrayList<MyQuestion>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MyQuestion _item;
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        final String _tmpQuestion;
        _tmpQuestion = _cursor.getString(_cursorIndexOfQuestion);
        final String _tmpAnswerA;
        _tmpAnswerA = _cursor.getString(_cursorIndexOfAnswerA);
        final String _tmpAnswerB;
        _tmpAnswerB = _cursor.getString(_cursorIndexOfAnswerB);
        final String _tmpAnswerC;
        _tmpAnswerC = _cursor.getString(_cursorIndexOfAnswerC);
        final String _tmpAnswerD;
        _tmpAnswerD = _cursor.getString(_cursorIndexOfAnswerD);
        final String _tmpCorrectAnswer;
        _tmpCorrectAnswer = _cursor.getString(_cursorIndexOfCorrectAnswer);
        _item = new MyQuestion(_tmpId,_tmpQuestion,_tmpAnswerA,_tmpAnswerB,_tmpAnswerC,_tmpAnswerD,_tmpCorrectAnswer);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
