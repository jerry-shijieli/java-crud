import com.datastax.dse.driver.api.core.DseSession;
import com.datastax.oss.driver.api.core.cql.*;
import java.net.InetSocketAddress;

public class Insert {
    
    public static void main(String[] args) {

        try (DseSession session = DseSession.builder()
                .addContactPoint(new InetSocketAddress(IpAddress.get(), 9042))
                .withLocalDatacenter("DC1")
                .build()) {

            session.execute(
                SimpleStatement.builder( "INSERT INTO killrvideo.advocates (first_name, last_name, region, city, super_power) VALUES (?,?,?,?,?)")
                        .addPositionalValues("Cristina", "Veale", "North Carolina", "Charlotte", "master developer")
                        .build());
        }
    }
}
