import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinDef.HWND;

// https://github.com/twall/jna#readme
//    you need 2 jars : jna-3.5.1.jar and platform-3.5.1.jar

public class KillMyPP {
  public static void main(String[] args) {
     HWND hwnd = User32.INSTANCE.FindWindow
       ("TTOTAL_CMD", null); // window title
                                                         // you need to modify this
                                                         // for your need
                                                         
//     User32.INSTANCE.GetClassName( , chars, 0)
     if (hwnd == null) {
       System.out.println("PPT is not running");
     }
     else{
         System.out.println("PPT is found!");
         User32.INSTANCE.ShowWindow(hwnd, WinUser.SW_RESTORE);
//       User32.INSTANCE.PostMessage(hwnd, WinUser.SW_PARENTOPENING, null, null);  // can be WM_QUIT in some occasion
     }
  }
}