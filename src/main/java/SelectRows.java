import com.datastax.dse.driver.api.core.DseSession;
import com.datastax.oss.driver.api.core.cql.*;
import java.net.InetSocketAddress;

public class SelectRows {
    
    public static void main(String args[]) {
       try (DseSession session = DseSession.builder().withCloudSecureConnectBundle(DBConnection.getConnectionPath())
           .withAuthCredentials(DBConnection.getUsername(), DBConnection.getPassword())
           .build()) {

            ResultSet results = session.execute(
                SimpleStatement.builder( "SELECT * FROM killrvideo.user_credentials WHERE email = ?")
                        .addPositionalValues("cv@datastax.com")
                        .build());
            Row row = results.one();
            System.out.println("***************************************************************************************");
            System.out.format("%s %s %s\n",
                row.getString("email"),
                row.getString("password"),
                row.getUuid("userid"));
            System.out.println("***************************************************************************************");
        }
    }
}
