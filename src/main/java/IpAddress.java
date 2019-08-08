import com.datastax.oss.driver.api.core.cql.*;
import java.net.InetSocketAddress;

public class IpAddress {
    
    private static String address = "35.236.45.215";
    
    public static String get() {
        return address;
    }
}

