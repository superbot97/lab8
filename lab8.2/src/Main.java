import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ConnectionPool connectionPool = new ConnectionPool();
        Connection connection = connectionPool.getConnection();
        connection.url = "jdbc:mysql://localhost/store";
        connection.login = "root";
        connection.password = "password";
        System.out.println(connection.url);
        System.out.println(connection.login);
        System.out.println(connection.password);
        connectionPool.releaseConnection(connection);
        Connection connection2 = connectionPool.getConnection();
        System.out.println(connection2.url);
        System.out.println(connection2.login);
        System.out.println(connection2.password);
    }
}

class Connection{
    String url;
    String login;
    String password;

    public Connection(String url, String login, String password){
        this.url = url;
        this.login = login;
        this.password = password;
    }
}

class ConnectionPool{
    List<Connection> free = new LinkedList<>();
    List<Connection> used = new LinkedList<>();

    public Connection getConnection(){
        if(free.isEmpty()){
            Connection connection = new Connection("", "", "");
            used.add(connection);
            return connection;
        }else {
            Connection connection = free.get(0);
            used.add(connection);
            free.remove(connection);
            return connection;
        }
    }

    public void releaseConnection(Connection connection){
        used.remove(connection);
        free.add(connection);
    }
}
