import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {
    private int angkaBenar;
    private int jumlahTebakan;
    private Button tombolTebak;
    private TextField inputAngka;
    private Label labelFeedback;
    private Label labelPercobaan;

    @Override
    public void start(Stage stage) {
        Random random = new Random();
        angkaBenar = random.nextInt(100) + 1;
        jumlahTebakan = 0;

        Label judul = new Label("\uD83C\uDFF9 Tebak Angka 1–100");
        judul.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        judul.setTextFill(Color.GREEN);

        labelFeedback = new Label("Masukkan tebakanmu!");
        labelFeedback.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 12));
        labelFeedback.setTextFill(Color.GRAY);

        inputAngka = new TextField();
        inputAngka.setPromptText("Masukkan angka di sini");
        inputAngka.setPrefWidth(200);

        tombolTebak = new Button("\uD83C\uDFB2 Coba Tebak!");
        tombolTebak.setStyle("-fx-background-color: #44bd32; -fx-text-fill: white;");

        tombolTebak.setOnAction(e -> prosesTebakan());

        HBox inputArea = new HBox(10, inputAngka, tombolTebak);
        inputArea.setAlignment(Pos.CENTER);

        labelPercobaan = new Label("Jumlah percobaan: 0");
        labelPercobaan.setTextFill(Color.DIMGRAY);

        VBox root = new VBox(15, judul, labelFeedback, inputArea, labelPercobaan);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #ffd700;");

        Scene scene = new Scene(root, 400, 280);
        stage.setTitle("Tebak Angka Advance");
        stage.setScene(scene);
        stage.show();
    }

    private void prosesTebakan() {
        String input = inputAngka.getText().trim();
        try {
            int tebakan = Integer.parseInt(input);
            jumlahTebakan++;
            inputAngka.clear();
            labelPercobaan.setText("Jumlah percobaan: " + jumlahTebakan);

            if (tebakan < angkaBenar) {
                labelFeedback.setText("\uD83D\uDD3D Terlalu kecil!");
                labelFeedback.setTextFill(Color.ORANGE);
            } else if (tebakan > angkaBenar) {
                labelFeedback.setText("\uD83D\uDD3C Terlalu besar!");
                labelFeedback.setTextFill(Color.ORANGE);
            } else {
                labelFeedback.setText("\uFE0F Tebakan benar!");
                labelFeedback.setTextFill(Color.GREEN);
                tombolTebak.setText("\uD83D\uDD01 Main Lagi");
                tombolTebak.setOnAction(e -> resetGame());
            }

        } catch (NumberFormatException e) {
            labelFeedback.setText("❌ Masukkan angka valid!");
            labelFeedback.setTextFill(Color.RED);
        }
    }

    private void resetGame() {
        Random random = new Random();
        angkaBenar = random.nextInt(100) + 1;
        jumlahTebakan = 0;
        labelFeedback.setText("Masukkan tebakanmu!");
        labelFeedback.setTextFill(Color.GRAY);
        labelPercobaan.setText("Jumlah percobaan: 0");
        tombolTebak.setText("\uD83C\uDFB2 Coba Tebak!");
        tombolTebak.setOnAction(e -> prosesTebakan());
        inputAngka.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}