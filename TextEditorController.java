package texteditor_test;
import java.io.File;

public class TextEditorController {
    private static TextEditorController instance;
    private TextEditorModel model;
    private TextEditorView view;

    private TextEditorController(TextEditorModel model, TextEditorView view) {
        this.model = model;
        this.view = view;
    }

    public static synchronized TextEditorController getInstance() {
        if (instance == null) {
            TextEditorModel model = new TextEditorModel();
            TextEditorView view = new TextEditorView();
            instance = new TextEditorController(model, view);
        }
        return instance;
    }


    public void loadFile(String filePath) {
        model.loadFile(filePath);
        view.displayText(model.getLines());
    }

    public void saveFile(String filePath) {
        model.saveFile(filePath);
    }

    public void addLine(String line) {
        model.addLine(line);
        view.displayText(model.getLines());
    }

    public void deleteLine(int index) {
        model.deleteLine(index);
        view.displayText(model.getLines());
    }

    public void listFilesRecursive(File directory) {
        model.listFilesRecursive(directory);
    }
}
