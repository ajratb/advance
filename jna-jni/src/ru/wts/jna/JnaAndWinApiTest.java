package ru.wts.jna;



import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinDef.HWND;

// https://github.com/twall/jna#readme
//    you need 2 jars : jna-3.5.1.jar and platform-3.5.1.jar

public class JnaAndWinApiTest {
  
    public final String MY_WIN_CLASS = "TTOTAL_CMD";
    public final String MY_WIN_TITLE = null;
    
    public static void main(String[] args) {
     JnaAndWinApiTest app=new JnaAndWinApiTest();
     app.findAndShowWindow();
  }
    
    public void findAndShowWindow(){
        //WinDef.HWND FindWindow(String lpClassName, String lpWindowName)
        HWND hwnd = User32.INSTANCE.FindWindow(MY_WIN_CLASS, null);
                                                         
//     User32.INSTANCE.GetClassName( , chars, 0)
     if (hwnd == null) {
       System.out.println("Window is not found");
     }
     else{
         System.out.println(hwnd);
         User32.INSTANCE.ShowWindow(hwnd, WinUser.SW_RESTORE);
//         User32.INSTANCE.GetWindowText(hwnd, chars, 0);
//       User32.INSTANCE.PostMessage(hwnd, WinUser.SW_PARENTOPENING, null, null);  // can be WM_QUIT in some occasion
     }
    }
}