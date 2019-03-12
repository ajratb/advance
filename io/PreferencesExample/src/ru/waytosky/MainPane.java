package ru.waytosky;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.BackingStoreException;
import java.util.prefs.InvalidPreferencesFormatException;
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author BikchentaevAA
 */
public class MainPane implements Initializable {

    @FXML
    private Label lbStatus;

    @FXML
    private Label lbBoolVal;

    @FXML
    private Label lbStringVal;

    private final File file;

    private final String FILE_NAME = "config.xml";

    public MainPane() {
        file = new File(FILE_NAME);
    }

    @FXML
    void onActionBtnCreatePrefs(ActionEvent event)
            throws BackingStoreException, IOException {
        createPreferences();
    }

    private void createPreferences() throws BackingStoreException, IOException {
//        Preferences preferences = Preferences.userRoot().node(this.getClass().getName());
//      Preferences preferences = Preferences.userRoot();
        Preferences preferences = Preferences.userNodeForPackage(this.getClass());
        preferences.putBoolean("openStartMenu", true);
        preferences.putBoolean("SavePass", true);
        preferences.put("UserName", "");
        preferences.put("PassWord", "123456");
        preferences.exportNode(new FileOutputStream(FILE_NAME));
    }

    @FXML
    void onActionBtnGetPrefs(ActionEvent event)
            throws IOException, InvalidPreferencesFormatException {
        // this can throw FileNotFoundException
        Preferences.importPreferences(new FileInputStream(FILE_NAME));
        Preferences preferences = Preferences.userNodeForPackage(this.getClass());
//        Preferences preferences = Preferences.userRoot();//it work even with root
//        Preferences preferences = Preferences.userRoot().node(this.getClass().getName());
        boolean bool = preferences.getBoolean("SavePass", false);
        lbBoolVal.setText("bool: " + bool);
        String str = preferences.get("PassWord", "");
        lbStringVal.setText("string: " + str);
    }

    @FXML
    void onActionBtnRemovePrefs(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (file.exists()) {
            lbStatus.setText("State: file exists");
        } else {
            lbStatus.setText("State: file is not found");
        }
    }

}
