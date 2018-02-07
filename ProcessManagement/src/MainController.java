/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.jutils.jprocesses.JProcesses;
import org.jutils.jprocesses.model.ProcessInfo;
import org.jutils.jprocesses.model.WindowsPriority;

/**
 *
 * @author Ayrat
 */
public class MainController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        List<ProcessInfo> processesList = JProcesses.getProcessList("XMind.exe");
        
        for (final ProcessInfo processInfo : processesList) {
            if(processInfo.getName().equals("XMind.exe")){
                System.out.println("Process PID: " + processInfo.getPid());
                JProcesses.changePriority(Integer.valueOf(processInfo.getPid()), 
                        WindowsPriority.HIGH);
            }
//            System.out.println("Process PID: " + processInfo.getPid());
//            System.out.println("Process Name: " + processInfo.getName());
//            System.out.println("Process Time: " + processInfo.getTime());
//            System.out.println("User: " + processInfo.getUser());
//            System.out.println("Virtual Memory: " + processInfo.getVirtualMemory());
//            System.out.println("Physical Memory: " + processInfo.getPhysicalMemory());
//            System.out.println("CPU usage: " + processInfo.getCpuUsage());
//            System.out.println("Start Time: " + processInfo.getStartTime());
//            System.out.println("Priority: " + processInfo.getPriority());
//            System.out.println("Full command: " + processInfo.getCommand());
//            System.out.println("------------------");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
