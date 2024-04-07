package texteditor_test;

import java.io.*;
import java.util.*;

public class TextEditorModel {
    private List<String> lines;
    private String currentFilePath;

    public TextEditorModel() {
        lines = new ArrayList<>();
        currentFilePath = null;
    }

    public void loadFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            lines = new ArrayList<>();
            reader.lines().forEach(lines::add);
            currentFilePath = filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            currentFilePath = filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public void deleteLine(int index) {
        lines.remove(index);
    }

    public List<String> getLines() {
        return lines;
    }

    public String getCurrentFilePath() {
        return currentFilePath;
    }

	public void listFilesRecursive(File directory) {
		// TODO Auto-generated method stub
		
	}
}
