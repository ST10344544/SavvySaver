package vcmsa.projects.savvysaver.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lvcmsa/projects/savvysaver/ui/BudgetGoalsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "budgetAmountEditText", "Landroid/widget/EditText;", "budgetListView", "Landroid/widget/ListView;", "budgetStatusTextView", "Landroid/widget/TextView;", "categories", "", "Lvcmsa/projects/savvysaver/data/Category;", "categorySpinner", "Landroid/widget/Spinner;", "createBudgetButton", "Landroid/widget/Button;", "currentMonth", "", "kotlin.jvm.PlatformType", "viewModel", "Lvcmsa/projects/savvysaver/viewmodel/AppViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "refreshBudgetList", "setupCategorySpinner", "app_release"})
public final class BudgetGoalsActivity extends androidx.appcompat.app.AppCompatActivity {
    private vcmsa.projects.savvysaver.viewmodel.AppViewModel viewModel;
    private android.widget.Spinner categorySpinner;
    private android.widget.ListView budgetListView;
    private android.widget.EditText budgetAmountEditText;
    private android.widget.Button createBudgetButton;
    private android.widget.TextView budgetStatusTextView;
    private final java.lang.String currentMonth = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<vcmsa.projects.savvysaver.data.Category> categories;
    
    public BudgetGoalsActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupCategorySpinner() {
    }
    
    private final void refreshBudgetList() {
    }
}