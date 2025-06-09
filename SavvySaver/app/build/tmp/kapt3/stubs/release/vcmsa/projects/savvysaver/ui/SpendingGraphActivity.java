package vcmsa.projects.savvysaver.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lvcmsa/projects/savvysaver/ui/SpendingGraphActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "categoryIdToNameMap", "", "", "", "dateFormat", "Ljava/text/SimpleDateFormat;", "endDateEditText", "Landroid/widget/EditText;", "loadGraphButton", "Landroid/widget/Button;", "simpleBarGraphView", "Lvcmsa/projects/savvysaver/ui/SimpleBarGraphView;", "startDateEditText", "viewModel", "Lvcmsa/projects/savvysaver/viewmodel/AppViewModel;", "loadCategoriesAndGraph", "", "loadGraph", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showDatePickerDialog", "editText", "app_release"})
public final class SpendingGraphActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.EditText startDateEditText;
    private android.widget.EditText endDateEditText;
    private android.widget.Button loadGraphButton;
    private vcmsa.projects.savvysaver.ui.SimpleBarGraphView simpleBarGraphView;
    private vcmsa.projects.savvysaver.viewmodel.AppViewModel viewModel;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat dateFormat = null;
    private java.util.Map<java.lang.Integer, java.lang.String> categoryIdToNameMap;
    
    public SpendingGraphActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showDatePickerDialog(android.widget.EditText editText, java.text.SimpleDateFormat dateFormat) {
    }
    
    private final void loadCategoriesAndGraph() {
    }
    
    private final void loadGraph() {
    }
}