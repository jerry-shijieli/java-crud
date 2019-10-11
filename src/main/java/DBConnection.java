public class DBConnection {
    private static String connectionPath = "/home/ubuntu/workspace/creds.zip";
    private static String username = "KVUser";
    private static String password = "KVPassword";

    public static String getConnectionPath() {
        return connectionPath;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}