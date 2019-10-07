package fantastic.philosophyQuiz.dataBase;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import fantastic.philosophyQuiz.dataBase.dao.MyQuestionDao;
import fantastic.philosophyQuiz.dataBase.dao.MyQuestionDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class LocalDB_Impl extends LocalDB {
  private volatile MyQuestionDao _myQuestionDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MyQuestions` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `Question` TEXT NOT NULL, `Answer_A` TEXT NOT NULL, `Answer_B` TEXT NOT NULL, `Answer_C` TEXT NOT NULL, `Answer_D` TEXT NOT NULL, `CorrectAnswer` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"18f192de709217bcd0fdfe7636f76ebe\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `MyQuestions`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsMyQuestions = new HashMap<String, TableInfo.Column>(7);
        _columnsMyQuestions.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsMyQuestions.put("Question", new TableInfo.Column("Question", "TEXT", true, 0));
        _columnsMyQuestions.put("Answer_A", new TableInfo.Column("Answer_A", "TEXT", true, 0));
        _columnsMyQuestions.put("Answer_B", new TableInfo.Column("Answer_B", "TEXT", true, 0));
        _columnsMyQuestions.put("Answer_C", new TableInfo.Column("Answer_C", "TEXT", true, 0));
        _columnsMyQuestions.put("Answer_D", new TableInfo.Column("Answer_D", "TEXT", true, 0));
        _columnsMyQuestions.put("CorrectAnswer", new TableInfo.Column("CorrectAnswer", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMyQuestions = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMyQuestions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMyQuestions = new TableInfo("MyQuestions", _columnsMyQuestions, _foreignKeysMyQuestions, _indicesMyQuestions);
        final TableInfo _existingMyQuestions = TableInfo.read(_db, "MyQuestions");
        if (! _infoMyQuestions.equals(_existingMyQuestions)) {
          throw new IllegalStateException("Migration didn't properly handle MyQuestions(fantastic.philosophyQuiz.dataBase.entity.MyQuestion).\n"
                  + " Expected:\n" + _infoMyQuestions + "\n"
                  + " Found:\n" + _existingMyQuestions);
        }
      }
    }, "18f192de709217bcd0fdfe7636f76ebe", "88527947ac9257df73e4998086975217");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "MyQuestions");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `MyQuestions`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public MyQuestionDao myQuestionDao() {
    if (_myQuestionDao != null) {
      return _myQuestionDao;
    } else {
      synchronized(this) {
        if(_myQuestionDao == null) {
          _myQuestionDao = new MyQuestionDao_Impl(this);
        }
        return _myQuestionDao;
      }
    }
  }
}
