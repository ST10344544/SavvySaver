package vcmsa.projects.savvysaver.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lvcmsa/projects/savvysaver/ui/SavingsGoalsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "container", "Landroid/widget/LinearLayout;", "db", "Lvcmsa/projects/savvysaver/data/AppDatabase;", "goals", "", "Lvcmsa/projects/savvysaver/data/SavingsGoal;", "loadGoals", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "renderGoals", "showAddAmountDialog", "goal", "showAddGoalDialog", "app_debug"})
public final class SavingsGoalsActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.LinearLayout container;
    private vcmsa.projects.savvysaver.data.AppDatabase db;
    private java.util.List<vcmsa.projects.savvysaver.data.SavingsGoal> goals;
    
    public SavingsGoalsActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loadGoals() {
    }
    
    private final void renderGoals() {
    }
    
    private final void showAddGoalDialog() {
    }
    
    private final void showAddAmountDialog(vcmsa.projects.savvysaver.data.SavingsGoal goal) {
    }
}