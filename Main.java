package texteditor_test;
public class Main {
    public static void main(String[] args) {
        TextEditorController controller = TextEditorController.getInstance();
        controller.loadFile("example.txt");
    }
}
