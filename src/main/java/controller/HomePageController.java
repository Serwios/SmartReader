package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class HomePageController {

    @FXML
    private TextArea content;

    @FXML
    private Button loadPdfButton;

    @FXML
    private Text pdfName;

    @FXML
    void initialize() {
        content.onMouseMovedProperty().setValue((event -> new TranslateSelectedTextRunnable()));
        content.onMouseClickedProperty().setValue(event -> new TranslateSelectedTextRunnable());
    }

    @FXML
    void loadPdf(ActionEvent event) {
        File myFile = new File("src/main/resources/java1.pdf");
        try (PDDocument doc = PDDocument.load(myFile)) {
            PDFTextStripper stripper = new PDFTextStripper();
            content.setText(stripper.getText(doc));
            System.out.println(stripper);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    class TranslateSelectedTextRunnable implements Runnable {
        @Override
        public void run() {
            String selectedText = content.getSelectedText();
            if (!selectedText.isBlank()) {
                System.out.println("Translating " + selectedText + " word..");
            }
        }
    }
}
