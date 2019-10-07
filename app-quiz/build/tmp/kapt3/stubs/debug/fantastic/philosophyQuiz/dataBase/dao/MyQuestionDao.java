package fantastic.philosophyQuiz.dataBase.dao;

import java.lang.System;

@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\'\u00a8\u0006\f"}, d2 = {"Lfantastic/philosophyQuiz/dataBase/dao/MyQuestionDao;", "", "deleteAllMyQuestions", "", "deleteMyQuestion", "id", "", "getAllMyQuestions", "", "Lfantastic/philosophyQuiz/dataBase/entity/MyQuestion;", "insert", "myQuestion", "app-quiz_debug"})
public abstract interface MyQuestionDao {
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM MyQuestions")
    public abstract java.util.List<fantastic.philosophyQuiz.dataBase.entity.MyQuestion> getAllMyQuestions();
    
    @android.arch.persistence.room.Insert(onConflict = android.arch.persistence.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    fantastic.philosophyQuiz.dataBase.entity.MyQuestion myQuestion);
    
    @android.arch.persistence.room.Query(value = "DELETE FROM MyQuestions WHERE id = :id")
    public abstract void deleteMyQuestion(long id);
    
    @android.arch.persistence.room.Query(value = "DELETE  FROM MyQuestions")
    public abstract void deleteAllMyQuestions();
}