import com.datastax.dse.driver.api.core.DseSession;
import com.datastax.oss.driver.api.core.cql.*;
import java.net.InetSocketAddress;

public class SelectRows {
    
    public static void main(String args[]) {
        try (DseSession session = DseSession.builder()
                .addContactPoint(new InetSocketAddress(IpAddress.get(), 9042))
                .withLocalDatacenter("DC1")
                .build()) {
            ResultSet results = session.execute(
                SimpleStatement.builder( "SELECT * FROM killrvideo.advocates WHERE region = ? AND city = ? AND last_name = ? AND first_name = ?")
                        .addPositionalValues("North Carolina", "Charlotte", "Veale", "Cristina")
                        .build());
            Row row = results.one();
            System.out.println("***************************************************************************************");
            System.out.format("%s %s %s %s %s\n",
                row.getString("first_name"),
                row.getString("last_name"),
                row.getString("city"),
                row.getString("region"),
                row.getString("super_power"));
            System.out.println("***************************************************************************************");
        }
    }
}
