package eu.hansolo.medusa;

import eu.hansolo.medusa.Gauge.SkinType;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SectionGaugeApplication extends Application {

    private Gauge gauge;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        gauge = GaugeBuilder.create()
                            .skinType(SkinType.SECTION)
                            .title("Title")
                            .unit("Unit")
                            .build();

        gauge.setMinValue(0.0);
        gauge.setMaxValue(100.0);
        gauge.setValue(45.0);

        gauge.setForegroundBaseColor(Color.RED);
        gauge.setValueVisible(true);
    }

    @Override
    public void start(Stage stage) throws Exception {
        StackPane pane = new StackPane(gauge);
        pane.setPadding(new Insets(10));

        Scene scene = new Scene(pane, 600, 600);

        Platform.setImplicitExit(true);
        stage.setTitle("Dashboard Gauge");
        stage.setScene(scene);
        stage.show();
    }

}
