
//Lớp thiết kế giao diện và bắt sự kiện cho các controller trong app

package gui;

import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.ArrayList;
import java.util.Calendar;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import process.*;
import readdata.GetForeignTransaction;
import readdata.GetStockInfo;

public class Controller extends Thread implements Initializable {
    // controller của DesignUI
    @FXML
    private DatePicker date;
    @FXML
    private TreeView<String> treeView;
    @FXML
    private TextArea textArea;
    @FXML
    private TextArea textArea1;

    // controller của SubStagePieChart
    @FXML
    private TextArea textArea2;

    // controller của ProgressBar
    @FXML
    private ProgressBar progressBar;
    @FXML
    private ProgressIndicator progressIndicator;

    private ArrayList<String> array = new ArrayList<String>(); // Đẩy các tag vào arraylist để xử lí sự kiện

    @Override

    // Phương thức chạy đầu tiên khi khởi động app
    public void initialize(URL location, ResourceBundle resources) {
        tagList();
        addText();

        PauseTransition delay = new PauseTransition(Duration.seconds(120));
        delay.setOnFinished( event -> fun() );
        delay.play();
    }

    @SuppressWarnings("unchecked") // Chống cảnh báo yêu cầu tạo biến thuộc tính của phương thức getChildren()

    // Đưa ra danh sách tag cha con theo mô hình cây
    public void tagList() {
        TreeItem<String> root = new TreeItem<>();

        TreeItem<String> overall = new TreeItem<>("Tổng quan");
        TreeItem<String> overall1 = new TreeItem<>("Tổng quan tăng giảm");
        TreeItem<String> overall2 = new TreeItem<>("Tổng quan toàn sàn");

        TreeItem<String> vnIndex = new TreeItem<>("Chỉ số Vn-Index");
        TreeItem<String> vnIndex1 = new TreeItem<>("Chỉ số VN-Index chốt phiên");
        TreeItem<String> vnIndex2 = new TreeItem<>("Top cổ phiếu ảnh hưởng tới giá trị VN-Index");

        TreeItem<String> top = new TreeItem<>("Top");
        TreeItem<String> top1 = new TreeItem<>("Top 5 tăng mạnh");
        TreeItem<String> top2 = new TreeItem<>("Top 5 giảm mạnh");
        TreeItem<String> top3 = new TreeItem<>("Top khối lượng khớp lệnh");
        TreeItem<String> top4 = new TreeItem<>("Top giá trị khớp lệnh");

        TreeItem<String> fEnterprise = new TreeItem<>("Doanh nghiệp nước ngoài");
        TreeItem<String> fEnterprise1 = new TreeItem<>("Top khối lượng nước ngoài mua");
        TreeItem<String> fEnterprise2 = new TreeItem<>("Top giá trị nước ngoài mua");
        TreeItem<String> fEnterprise3 = new TreeItem<>("Top khối lượng nước ngoài bán");
        TreeItem<String> fEnterprise4 = new TreeItem<>("Top giá trị nước ngoài bán");

        TreeItem<String> share = new TreeItem<>("Các cổ phiếu");
        TreeItem<String> share1 = new TreeItem<>("Các cổ phiếu tăng giá");
        TreeItem<String> share2 = new TreeItem<>("Các cổ phiếu giảm giá");
        TreeItem<String> share3 = new TreeItem<>("Các cổ phiếu đứng giá");

        TreeItem<String> vn30 = new TreeItem<>("Cổ phiếu VN30");
        TreeItem<String> vn30_1 = new TreeItem<>("Cổ phiếu VN30");

        TreeItem<String> shareArea = new TreeItem<>("Nhóm cổ phiếu theo ngành");
        TreeItem<String> shareArea1 = new TreeItem<>("Bất động sản");
        TreeItem<String> shareArea2 = new TreeItem<>("Tài chính");
        TreeItem<String> shareArea3 = new TreeItem<>("Hàng hóa chủ chốt");
        TreeItem<String> shareArea4 = new TreeItem<>("Hàng tiêu dùng");
        TreeItem<String> shareArea5 = new TreeItem<>("Hàng tiêu dùng thiết yếu");
        TreeItem<String> shareArea6 = new TreeItem<>("Nguyên vật liệu");
        TreeItem<String> shareArea7 = new TreeItem<>("Vận tải");
        TreeItem<String> shareArea8 = new TreeItem<>("Dịch vụ tiện ích");
        TreeItem<String> shareArea10 = new TreeItem<>("Chăm sóc sức khỏe");
        TreeItem<String> shareArea11 = new TreeItem<>("Năng lượng");

        overall.getChildren().addAll(overall1, overall2);
        vnIndex.getChildren().addAll(vnIndex1, vnIndex2);
        top.getChildren().addAll(top1, top2, top3, top4);
        fEnterprise.getChildren().addAll(fEnterprise1, fEnterprise2, fEnterprise3, fEnterprise4);
        share.getChildren().addAll(share1, share2, share3);
        vn30.getChildren().add(vn30_1);
        shareArea.getChildren().addAll(shareArea1, shareArea2, shareArea3, shareArea4, shareArea5, shareArea6, shareArea7, shareArea8, shareArea10, shareArea11);
        root.getChildren().addAll(overall, vnIndex, top, fEnterprise, share, vn30, shareArea);

        treeView.setRoot(root);
        treeView.setShowRoot(false);
    }

    // Phương thức trả về ngày để xử lý việc đọc file của ngày đó
    public DatePicker dateReturn() {
        if (date.getValue().isAfter(LocalDate.now()) || date.getValue().isEqual(LocalDate.now()))
            return null;
        else
            return date;
    }

    // Phương thức kiểm tra việc chọn ngày của người dùng
    public void checkDate() throws Exception {
        // Kiểm tra và đưa ra cảnh báo việc chọn những ngày chưa có dữ liệu chứng khoán
        if (date.getValue().isAfter(LocalDate.now()) || date.getValue().isEqual(LocalDate.now())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cảnh báo lỗi");
            alert.setHeaderText("Lỗi khi chọn ngày");
            alert.setContentText("Chưa có dữ liệu chứng khoán của ngày được chọn!!!\n\nVui lòng chọn lại ngày!!!!");
            alert.showAndWait();
        }

        else {
            // Kiểm tra và đưa ra cảnh báo việc chọn vào ngày Thứ Bảy và Chủ Nhật
            if (date.getValue().getDayOfWeek().getValue() == (Calendar.SATURDAY - 1)
                    || date.getValue().getDayOfWeek().getValue() == (Calendar.SATURDAY)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Cảnh báo lỗi");
                alert.setHeaderText("Lỗi khi chọn ngày");
                alert.setContentText("Không có dữ liệu chứng khoán vào ngày nghỉ!!!\n\nVui lòng chọn lại ngày!!!!");
                alert.showAndWait();
            }
            else {
                // Hiển thị ra cửa sổ chờ lấy dữ liệu trực tuyến
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ProgressBar.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("Vui lòng đợi");
                stage.setScene(scene);
                stage.show();

                // Tiến hành lấy dữ liệu trực tuyến
                dateReturn();
                GetStockInfo.GetInfo(LocalDate.of(dateReturn().getValue().getYear(), dateReturn().getValue().getMonthValue(), dateReturn().getValue().getDayOfMonth()));
                readForeignTransactionFile();
            }
        }
    }

    // Phương thức thêm các tags cần phân tích dữ liệu vào 1 ô text để đưa ra mẫu
    // câu của các tags đó
    public void addText() {
        treeView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {
                if (treeView.getSelectionModel().getSelectedItem().isLeaf()) {
                    if (click.getClickCount() == 2) {
                        if (!array.contains(treeView.getSelectionModel().getSelectedItem().getValue()))
                            textArea.appendText(treeView.getSelectionModel().getSelectedItem().getValue() + "\n");
                        array.add(treeView.getSelectionModel().getSelectedItem().getValue());
                    }
                }
            }
        });
    }

    // Phương thức bắt sự kiện cho nút Remove để xóa dữ liệu trong ô text
    public void cleanText() {
        textArea.clear();
        array.clear();
        textArea1.clear();
    }

    // Phương thức hiển thị các mẫu ra màn hình theo ngày
    public void showText() {
        // Kiểm tra và đưa ra cảnh báo việc chưa chọn ngày
        if (date.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cảnh báo lỗi");
            alert.setHeaderText("Lỗi khi chọn ngày");
            alert.setContentText("Bạn chưa chọn ngày xem dữ liệu chứng khoán!!!\n\nVui lòng chọn lại ngày!!!");
            alert.showAndWait();
        }

        // Tiến hành hiển thị các mẫu câu
        ProcessTag1 tag1 = new ProcessTag1();
        ProcessTag2 tag2 = new ProcessTag2();
        ProcessTag3 tag3 = new ProcessTag3();
        ProcessTag4 tag4 = new ProcessTag4();
        ProcessTag9 tag9 = new ProcessTag9();
        ProcessTag10 tag10 = new ProcessTag10();
        ProcessTag11 tag11 = new ProcessTag11();
        ProcessVn30Tag tagVn30 = new ProcessVn30Tag();
        ProcessTagI1 tagI1 = new ProcessTagI1();
        ProcessTagI2 tagI2 = new ProcessTagI2();
        ProcessTagII1 tagII1 = new ProcessTagII1(LocalDate.of(dateReturn().getValue().getYear(),
                dateReturn().getValue().getMonthValue(), dateReturn().getValue().getDayOfMonth()));
        ProcessTagII2 tagII2 = new ProcessTagII2(LocalDate.of(dateReturn().getValue().getYear(),
                dateReturn().getValue().getMonthValue(), dateReturn().getValue().getDayOfMonth()));
        ProcessTagGroup tagGroup = new ProcessTagGroup();
        ProcessTagGroup1 tagGroup1 = new ProcessTagGroup1();
        ProcessTagGroup2 tagGroup2 = new ProcessTagGroup2();
        ProcessTagGroup3 tagGroup3 = new ProcessTagGroup3();
        ProcessTagGroup4 tagGroup4 = new ProcessTagGroup4();
        ProcessTagGroup5 tagGroup5 = new ProcessTagGroup5();
        ProcessTagGroup6 tagGroup6 = new ProcessTagGroup6();
        ProcessTagGroup7 tagGroup7 = new ProcessTagGroup7();
        ProcessTagGroup8 tagGroup8 = new ProcessTagGroup8();
        ProcessTagGroup10 tagGroup10 = new ProcessTagGroup10();
        ProcessTagGroup11 tagGroup11 = new ProcessTagGroup11();


        if (dateReturn() != null) {
            for (String i : array) {
                if (i.equals(tag1.sentences.get(0))) {
                    textArea1.appendText(tag1.RandomSentences() + "\n\n");
                }
                if (i.equals(tag2.sentences.get(0))) {
                    textArea1.appendText(tag2.RandomSentences() + "\n\n");
                }
                if (i.equals(tag3.sentences.get(0))) {
                    textArea1.appendText(tag3.RandomSentences() + "\n\n");
                }
                if (i.equals(tag4.sentences.get(0))) {
                    textArea1.appendText(tag4.RandomSentences() + "\n\n");
                }

                //Xử lí điều kiện doanh nghiệp nước ngoài không có dữ liệu
                for(int j = 15; j <= 18; j++) {
                    if (dateReturn().getValue().isEqual(LocalDate.of(2020, 12, j)) || dateReturn().getValue().isEqual(LocalDate.of(2020, 12, 21))) {
                        ProcessTag5 tag5 = new ProcessTag5();
                        ProcessTag6 tag6 = new ProcessTag6();
                        ProcessTag7 tag7 = new ProcessTag7();
                        ProcessTag8 tag8 = new ProcessTag8();

                        if(i.equals(tag5.sentences.get(0))) {
                            textArea1.appendText(tag5.RandomSentences() + "\n\n");
                        }
                        if(i.equals(tag6.sentences.get(0))) {
                            textArea1.appendText(tag6.RandomSentences() + "\n\n");
                        }
                        if(i.equals(tag7.sentences.get(0))) {
                            textArea1.appendText(tag7.RandomSentences() + "\n\n");
                        }
                        if(i.equals(tag8.sentences.get(0))) {
                            textArea1.appendText(tag8.RandomSentences() + "\n\n");
                        }
                        break;
                    }
                    else {
                        if(j == 18) {
                            if(i.equals("Top khối lượng nước ngoài mua") || i.equals("Top giá trị nước ngoài mua") || i.equals("Top khối lượng nước ngoài bán") || i.equals("Top giá trị nước ngoài bán")) {
                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("Cảnh báo lỗi");
                                alert.setHeaderText("Lỗi khi chọn ngày");
                                alert.setContentText("Không có dữ liệu chứng khoán doanh nghiệp nước ngoài vào ngày này!!!\n\nVui lòng chọn lại ngày!!!!");
                                alert.showAndWait();
                                break;
                            }
                        }
                    }

                }
                if (i.equals(tag9.sentences.get(0))) {
                    textArea1.appendText(tag9.RandomSentences() + "\n\n");
                }
                if (i.equals(tag10.sentences.get(0))) {
                    textArea1.appendText(tag10.RandomSentences() + "\n\n");
                }
                if (i.equals(tag11.sentences.get(0))) {
                    textArea1.appendText(tag11.RandomSentences() + "\n\n");
                }
                if (i.equals(tagVn30.sentences.get(0))) {
                    textArea1.appendText(tagVn30.RandomSentences() + "\n\n");
                }
                if (i.equals(tagI1.sentences.get(0))) {
                    textArea1.appendText(tagI1.RandomSentences() + "\n\n");
                }
                if (i.equals(tagI2.sentences.get(0))) {
                    textArea1.appendText(tagI2.RandomSentences() + "\n\n");
                }
                if (i.equals(tagII1.sentences.get(0))) {
                    textArea1.appendText(tagII1.RandomSentences() + "\n\n");
                }
                if (i.equals(tagII2.sentences.get(0))) {
                    textArea1.appendText(tagII2.RandomSentences() + "\n\n");
                }
                if (i.equals(tagGroup1.sentences1.get(0))) {
                    textArea1.appendText(tagGroup1.RandomSentences() + "\n\n");
                }
                if (i.equals(tagGroup2.sentences1.get(0))) {
                    textArea1.appendText(tagGroup2.RandomSentences() + "\n\n");
                }
                if (i.equals(tagGroup3.sentences1.get(0))) {
                    textArea1.appendText(tagGroup3.RandomSentences() + "\n\n");
                }
                if (i.equals(tagGroup4.sentences1.get(0))) {
                    textArea1.appendText(tagGroup4.RandomSentences() + "\n\n");
                }
                if (i.equals(tagGroup5.sentences1.get(0))) {
                    textArea1.appendText(tagGroup5.RandomSentences() + "\n\n");
                }
                if (i.equals(tagGroup6.sentences1.get(0))) {
                    textArea1.appendText(tagGroup6.RandomSentences() + "\n\n");
                }
                if (i.equals(tagGroup7.sentences1.get(0))) {
                    textArea1.appendText(tagGroup7.RandomSentences() + "\n\n");
                }
                if (i.equals(tagGroup8.sentences1.get(0))) {
                    textArea1.appendText(tagGroup8.RandomSentences() + "\n\n");
                }
                if (i.equals(tagGroup10.sentences1.get(0))) {
                    textArea1.appendText(tagGroup10.RandomSentences() + "\n\n");
                }
                if (i.equals(tagGroup11.sentences1.get(0))) {
                    textArea1.appendText(tagGroup11.RandomSentences() + "\n\n");
                }
            }
        }
    }

    //Đọc dữ liệu file excel của nhà đầu tư nước ngoài
    public void readForeignTransactionFile() {
        String filePath = new File("").getAbsolutePath();

        if (dateReturn().getValue().isEqual(LocalDate.of(2020, 12, 15))) {
            GetForeignTransaction.GetForeign(new File(filePath + "\\src\\readdata\\Foreign\\15_12_2020.csv"));
        }
        if (dateReturn().getValue().isEqual(LocalDate.of(2020, 12, 16))) {
            GetForeignTransaction.GetForeign(new File(filePath + "\\src\\readdata\\Foreign\\16_12_2020.csv"));
        }
        if (dateReturn().getValue().isEqual(LocalDate.of(2020, 12, 17))) {
            GetForeignTransaction.GetForeign(new File(filePath + "\\src\\readdata\\Foreign\\17_12_2020.csv"));
        }
        if (dateReturn().getValue().isEqual(LocalDate.of(2020, 12, 18))) {
            GetForeignTransaction.GetForeign(new File(filePath + "\\src\\readdata\\Foreign\\18_12_2020.csv"));
        }
        if (dateReturn().getValue().isEqual(LocalDate.of(2020, 12, 21))) {
            GetForeignTransaction.GetForeign(new File(filePath + "\\src\\readdata\\Foreign\\21_12_2020.csv"));
        }
    }

    // Phương thức dùng để chọn đường dẫn lưu các mẫu câu đã phân tích(cho những ai
    // cần nghiên cứu)
    public void fileSaveDirectory() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Chọn đường dẫn đến nơi lưu dữ liệu chứng khoán");

        // Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            saveFile(textArea1.getText(), file);
        }
    }

    // Phương thức dùng để lưu các mẫu câu đã phân tích vào file txt(cho những ai
    // cần nghiên cứu)
    public void saveFile(String content, File file) {
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(RunApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Đưa ra hướng dẫn cho người dùng app
    public void tutorial() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hướng dẫn sử dụng phần mềm");
        alert.setHeaderText("Phần mềm phân tích chứng khoán");
        alert.setContentText(
                "Bước 1: Chọn các tags bạn muốn xem bằng cách nháy đúp chuột vào danh sách bên trái.\nBước 2: Chọn ngày bạn muốn xem dữ liệu.\nBước 3: Nhấn Run để sinh ra câu phân tích chứng khoán.\nBước 4: Nhấn Remove để bắt đầu lại từ đầu.");
        alert.showAndWait();
    }

    public void openAbout() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("SubStagePieChart.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Authors");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fun() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("fun.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Tài khoản dùng thử hết hạn");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
/*
 * public void saveFile() { DirectoryChooser chooser = new DirectoryChooser();
 * chooser.setTitle("Chọn đường dẫn đến nơi lưu mẫu câu"); File
 * selectedDirectory = null; while(selectedDirectory == null) {
 * selectedDirectory = chooser.showDialog(null); } File file = new
 * File(selectedDirectory + "/" + "Report.txt"); PrintWriter outFile = null; try
 * { outFile = new PrintWriter(file); } catch (FileNotFoundException e) {
 * e.printStackTrace(); } outFile.println(textArea1.getText()); outFile.close();
 * }
 */