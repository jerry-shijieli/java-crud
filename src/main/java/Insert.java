import com.datastax.dse.driver.api.core.DseSession;
import com.datastax.oss.driver.api.core.cql.*;
import java.net.InetSocketAddress;
import java.util.UUID;

public class Insert {
    
    public static void main(String[] args) {

        try (DseSession session = DseSession.builder()
                .addContactPoint(new InetSocketAddress(IpAddress.get(), 9042))
                .withLocalDatacenter("dc1")
                .build()) {

            session.execute(
                SimpleStatement.builder( "INSERT INTO killrvideo.user_credentials (email, password, userid) VALUES (?,?,?)")
                        .addPositionalValues("cv@datastax.com", "3@$tC0@$tC@ss@ndr@", UUID.fromString("55555555-5555-5555-5555-555555555555"))
                        .build());
        }
    }
}
