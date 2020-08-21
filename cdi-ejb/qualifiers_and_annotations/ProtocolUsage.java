package reflect_annotations;

import java.lang.annotation.Annotation;

/**
 *
 * @author BikchentaevAA
 */
public class ProtocolUsage {

//    @Protocol(ProtocolType.HTTPS)
//    private Sender sender;

    @Protocol(ProtocolType.HTTP)
    public static class HTTPSender implements Sender {

        public void send(byte[] data) {
            System.out.println("sended via HTTP");
        }
    }

    @Protocol(ProtocolType.HTTPS)
    public static class HTTPSSender implements Sender {

        public void send(byte[] data) {
            System.out.println("sended via HTTPS");
        }
    }

    public static void main(String[] args) {

//        Protocol protocol = new Protocol() {
//            
//              @Override
//            public Class<? extends Annotation> annotationType() {
//                return Protocol.class;
//            }
//            
//            @Override
//            public ProtocolType value() {
//                String value = "HTTP";
//                return ProtocolType.valueOf(value);
//            }
//
//            @Override
//            public String comment() {
//                throw new UnsupportedOperationException("Not supported yet."); 
//            }
//          
//        };
//        container.select(NetworkLogger.Sender.class, protocol).get().send(null);
        new HTTPSender().send(null);
    }

}
