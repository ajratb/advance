/**
 *
 * @author BikchentaevAA
 */
public class StringsAndChars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //. ? + * | { } [ ] ( ) " \
        char[] charArray = { '\'', '('};
        String value = "adb(def)/'/\"e";
        
        for(char ch: charArray){
            if(value.contains(String.valueOf(ch))){
                value=value.replace(String.valueOf(ch), "D");
            }
        }
        
        System.out.println(value);
        System.out.println(value.substring(0, value.length()-2)+value.substring(value.length()-2, value.length()));
        System.out.println(value.substring(0, value.length()/2)+value.substring(value.length()/2, value.length()));
        System.out.println(value.substring(0, value.length()/2));
        System.out.println(value.substring(value.length()/2, value.length()));
        System.out.println(value.substring(1, value.length()-1));
    }
    
}
