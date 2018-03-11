
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
//import com.sun.jna.platform.win32.User32;

public class TryWithHWND {

    public interface User32 extends StdCallLibrary {

        User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);

        boolean EnumWindows(WinUser.WNDENUMPROC lpEnumFunc, Pointer arg);

        int GetWindowTextA(HWND hWnd, byte[] lpString, int nMaxCount);
//        java.lang.UnsatisfiedLinkError: Error looking up function 'GetWindowText': Не найдена указанная процедура.
//        int GetWindowText(HWND hWnd, char[] lpString, int nMaxCount);

        int GetClassNameA(HWND hWnd,
                byte[] lpClassName,
                int nMaxCount);
        
        boolean IsWindowVisible(HWND hWnd);
        
        int GetWindowThreadProcessId(HWND hWnd, IntByReference proc);
        
        HWND GetWindow(HWND hWnd, int uCmd);
    }

    public static void main(String[] args) {
        final User32 user32 = User32.INSTANCE;
//        MyStructure struc = new MyStructure();
        int procId = 1440;
        HWND bestHandle = new HWND();
        user32.EnumWindows(new WNDENUMPROC() {
            int count = 0;

            @Override
            public boolean callback(HWND hWnd, Pointer arg1) {
//                (Structure) structure = arg1.
//                MyStructure inStruct = new MyStructure(arg1, procId ,hWnd);
//                System.out.println(inStruct.procId+" Current Handle is: "+hWnd+" inStruct.bestHandle: "+inStruct.bestHandle);
//                inStruct.bestHandle = hWnd;
                if(user32.IsWindowVisible(hWnd)){
                    System.out.println("THIS IS VISIBLE WINDOW");
                }
                byte[] windowText = new byte[512];
//                char[] windowText = new char[512];
                user32.GetWindowTextA(hWnd, windowText, 512);
//                 user32.GetWindowText(hWnd, windowText, 512);
                String wText = Native.toString(windowText, "Windows-1251");

                // get rid of this if block if you want all windows regardless of whether
                // or not they have text
                if (wText.isEmpty()) {
                    return true;
                }

                byte[] windowClass = new byte[512];
                user32.GetClassNameA(hWnd, windowClass, 512);
                String wClass = Native.toString(windowClass);

                // get rid of this if block if you want all windows regardless of whether
                // or not they have text
                if (wClass.isEmpty()) {
                    return true;
                }
                IntByReference procPtr = new IntByReference(0);
                user32.GetWindowThreadProcessId(hWnd, procPtr);
                HWND owner = user32.GetWindow(hWnd, WinUser.GW_OWNER);
                System.out.println("Found window " + hWnd + " For proc: " + procPtr.getValue()
                        + " Text: " + wText + " ClassName is:" + wClass+ ", total " + ++count + " with owner: "+owner);
                return true;
            }
        }, null);
//                , struc.getPointer());
    }

//    public static class MyStructure extends Structure {
//
//        public int procId;// = 1440;
//        public HWND bestHandle;// = new HWND();
//
//        public MyStructure() {
////            super();
////            procId = proc;
////            bestHandle = new HWND();
//        }
//
//        public MyStructure(Pointer p, int proc, HWND hwnd) {
//            super(p);
//            procId = proc;
//            bestHandle = hwnd;
//        }
//
//        @Override
//        protected List<String> getFieldOrder() {
//            return Arrays.asList(new String[] { "procId", "bestHandle" });
//        }
//
//    }
}
