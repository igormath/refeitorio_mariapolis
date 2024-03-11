package br.upe.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneChanger {
    private static Scene scene;

    public static void setScene(Scene scene) {
        SceneChanger.scene = scene;
    }
    public static void setInitialScene(Scene initialScene) {
        scene = initialScene;
    }

    public static void changeScene(String fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SceneChanger.class.getResource("/br/upe/fxml/" + fxml + ".fxml"));
            Parent root = fxmlLoader.load();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
