import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Inquiry inquiry = new Inquiry();
        ArrayList<String> list = inquiry.getList();

        try (Statement statement = inquiry.connect()) {
            inquiry.inq0(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (OutputStream fos = new FileOutputStream("AvayaLogger")) {
            InquiryOutput output = new InquiryOutput(fos, list);
            output.writeData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        list = inquiry.getList();
//
//        for (String i : list) {
//            System.out.println(i);
//            System.out.println();
//        }
    }
}