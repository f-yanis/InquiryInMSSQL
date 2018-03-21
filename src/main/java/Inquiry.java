import java.sql.*;
import java.util.ArrayList;


public class Inquiry {
    private String connectionUrl = "jdbc:sqlserver://gsz-sql01\\MSSQLSERVER:1433;trustServerCertificate=true;integratedSecurity=true;databaseName=AvayaLogger";
    private String answer0 = "SELECT TOP 10 CallStart, CallDuration, Caller, CalledNumber, Party1Device, Party1Name, " +
            "Party2Device, Party2Name, ServerIPCaller, ServerIPCalled FROM dbo.Calls_History ORDER BY CallStart DESC;";

    public ArrayList<String> getList() {
        return list;
    }

    private  ArrayList<String> list = new ArrayList<String>();

    public Statement connect() throws SQLException {
        Connection connection = DriverManager.getConnection(connectionUrl);

            if (!connection.isClosed()) {
                System.out.println("Соединение с БД установлено");
                System.out.println();
            }

            Statement statement = connection.createStatement();

        return statement;
    }

    public void inq0(Statement statement) throws SQLException {
        System.out.println("Выполняется sql запрос и обработка данных");
        ResultSet executeQuery = statement.executeQuery(answer0);

        while (executeQuery.next()) {
            list.add("CallStart: " + executeQuery.getString("CallStart") +
                    "    " + "CallDuration: " + executeQuery.getString("CallDuration") +
                    "    " + "Caller: " + executeQuery.getString("Caller") +
                    "    " + "CalledNumber: " + executeQuery.getString("CalledNumber") +
                    "    " + "Party1Device: " + executeQuery.getString("Party1Device") +
                    "    " + "Party1Name: " + executeQuery.getString("Party1Name") +
                    "    " + "Party2Device: " + executeQuery.getString("Party2Device") +
                    "    " + "Party2Name: " + executeQuery.getString("Party2Name") +
                    "    " + "ServerIPCaller: " + executeQuery.getString("ServerIPCaller") +
                    "    " + "ServerIPCalled: " + executeQuery.getString("ServerIPCalled") + "\r\n");
        }
        System.out.println("Обработка данных завершена");
    }
}


