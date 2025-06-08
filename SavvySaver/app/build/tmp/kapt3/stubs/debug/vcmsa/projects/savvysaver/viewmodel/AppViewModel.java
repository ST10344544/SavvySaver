package vcmsa.projects.savvysaver.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fJ\u001c\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fJ\u001c\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fJ \u0010\u0013\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0015\u0012\u0004\u0012\u00020\b0\u0014J(\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0015\u0012\u0004\u0012\u00020\b0\u0014J \u0010\u0019\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0015\u0012\u0004\u0012\u00020\b0\u0014J$\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\b0\u0014J$\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00182\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\b0\u0014J6\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00182\u001e\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020#0\"\u0012\u0004\u0012\u00020\b0\u0014J(\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u001c2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0015\u0012\u0004\u0012\u00020\b0\u0014J6\u0010&\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00182\u001e\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020#0\"\u0012\u0004\u0012\u00020\b0\u0014J,\u0010\'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0004\u0012\u00020\b0\u0014J\u001c\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020*2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lvcmsa/projects/savvysaver/viewmodel/AppViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "db", "Lvcmsa/projects/savvysaver/data/AppDatabase;", "addBudget", "", "budget", "Lvcmsa/projects/savvysaver/data/Budget;", "callback", "Lkotlin/Function0;", "addCategory", "category", "Lvcmsa/projects/savvysaver/data/Category;", "addExpense", "expense", "Lvcmsa/projects/savvysaver/data/Expense;", "getAllExpenses", "Lkotlin/Function1;", "", "getBudgetsByMonth", "month", "", "getCategories", "getCategoryById", "id", "", "getCategoryByName", "name", "getExpensesByCategoryAndMonth", "startDateStr", "endDateStr", "", "", "getExpensesByCategoryId", "categoryId", "getExpensesGroupedByCategory", "login", "username", "password", "Lvcmsa/projects/savvysaver/data/User;", "register", "user", "app_debug"})
public final class AppViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final vcmsa.projects.savvysaver.data.AppDatabase db = null;
    
    public AppViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    public final void login(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super vcmsa.projects.savvysaver.data.User, kotlin.Unit> callback) {
    }
    
    public final void register(@org.jetbrains.annotations.NotNull()
    vcmsa.projects.savvysaver.data.User user, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    public final void addCategory(@org.jetbrains.annotations.NotNull()
    vcmsa.projects.savvysaver.data.Category category, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    public final void getCategories(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<vcmsa.projects.savvysaver.data.Category>, kotlin.Unit> callback) {
    }
    
    public final void getCategoryByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super vcmsa.projects.savvysaver.data.Category, kotlin.Unit> callback) {
    }
    
    public final void getCategoryById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super vcmsa.projects.savvysaver.data.Category, kotlin.Unit> callback) {
    }
    
    public final void getExpensesByCategoryId(int categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<vcmsa.projects.savvysaver.data.Expense>, kotlin.Unit> callback) {
    }
    
    public final void addExpense(@org.jetbrains.annotations.NotNull()
    vcmsa.projects.savvysaver.data.Expense expense, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    public final void getAllExpenses(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<vcmsa.projects.savvysaver.data.Expense>, kotlin.Unit> callback) {
    }
    
    public final void addBudget(@org.jetbrains.annotations.NotNull()
    vcmsa.projects.savvysaver.data.Budget budget, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    public final void getBudgetsByMonth(@org.jetbrains.annotations.NotNull()
    java.lang.String month, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<vcmsa.projects.savvysaver.data.Budget>, kotlin.Unit> callback) {
    }
    
    public final void getExpensesGroupedByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String startDateStr, @org.jetbrains.annotations.NotNull()
    java.lang.String endDateStr, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.Map<java.lang.Integer, java.lang.Double>, kotlin.Unit> callback) {
    }
    
    public final void getExpensesByCategoryAndMonth(@org.jetbrains.annotations.NotNull()
    java.lang.String startDateStr, @org.jetbrains.annotations.NotNull()
    java.lang.String endDateStr, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.Map<java.lang.Integer, java.lang.Double>, kotlin.Unit> callback) {
    }
}