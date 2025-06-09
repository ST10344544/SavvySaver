package vcmsa.projects.savvysaver.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lvcmsa/projects/savvysaver/data/SavingsGoalDao;", "", "deleteGoal", "", "goal", "Lvcmsa/projects/savvysaver/data/SavingsGoal;", "(Lvcmsa/projects/savvysaver/data/SavingsGoal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllGoals", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "updateGoal", "app_release"})
@androidx.room.Dao()
public abstract interface SavingsGoalDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    vcmsa.projects.savvysaver.data.SavingsGoal goal, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM savings_goals")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllGoals(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<vcmsa.projects.savvysaver.data.SavingsGoal>> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateGoal(@org.jetbrains.annotations.NotNull()
    vcmsa.projects.savvysaver.data.SavingsGoal goal, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteGoal(@org.jetbrains.annotations.NotNull()
    vcmsa.projects.savvysaver.data.SavingsGoal goal, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}