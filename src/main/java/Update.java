import com.datastax.dse.driver.api.core.DseSession;
import com.datastax.oss.driver.api.core.cql.*;
import java.net.InetSocketAddress;

public class Update {
    
    public static void main(String[] args) {

       try (DseSession session = DseSession.builder().withCloudSecureConnectBundle("/home/ubuntu/workspace/creds.zip")
           .withAuthCredentials("KVUser","KVPassword")
           .withKeyspace("killrvideo")
           .build()) {

            session.execute(
                SimpleStatement.builder( "UPDATE killrvideo.user_credentials SET password = ? WHERE email = ?")
                        .addPositionalValues("Cr1st1n@sN3wP@ssW0rd", "cv@datastax.com")
                        .build());
        }
    }
}
