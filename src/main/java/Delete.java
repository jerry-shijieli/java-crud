import com.datastax.dse.driver.api.core.DseSession;
import com.datastax.oss.driver.api.core.cql.*;
import java.net.InetSocketAddress;

public class Delete {
    
    public static void main(String[] args) {

       try (DseSession session = DseSession.builder().withCloudSecureConnectBundle("/home/ubuntu/workspace/creds.zip")
           .withAuthCredentials("KVUser","KVPassword")
           .withKeyspace("killrvideo")
           .build()) {

            session.execute(
                SimpleStatement.builder( "DELETE FROM killrvideo.user_credentials WHERE email = ?")
                        .addPositionalValues("cv@datastax.com")
                        .build());
        }
    }
}
