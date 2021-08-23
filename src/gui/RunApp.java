
//Lớp dùng để khởi tạo stage và chạy chương trình

package gui;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import readdata.GetCompanyGroup;

public class RunApp extends Application {

    public static void main(String[] args) throws Exception {
        String filePath = new File("").getAbsolutePath();
        GetCompanyGroup.GetCompanyInfo(new File(filePath + "\\src\\readdata\\CompanyName.csv"));
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("DesignUI.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Stock Analysis Program");
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}