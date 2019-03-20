


/**
 *
 * @author BikchentaevAA
 */
public class CalcStudy {
    public static void main(String[] args) {
        byte a = (byte)139;
        byte c = (byte)254;
        byte b = 0x10;//0001_0000
        byte d = 0b0001_0000; // 2^4
        System.out.println(a + " " +c + " " +b + " "+d);
        
        long code;
        Sample smp = new Sample();
        String codeVal = String.valueOf(smp.getCode());
        System.out.println(codeVal);
    }
    
    static class Sample{
        long code;
        long getCode(){return code;}
    }
    //0 - 0
    //127 - 127
    //128 - -127
    //254 - -2
    //255 - -1
    //256 - 0
    //257 - 1
}
