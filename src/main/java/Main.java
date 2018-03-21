import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Inquiry inquiryOut = new Inquiry();
        InquiryInput inquiryIn = new InquiryInput();
        ArrayList<String> list = inquiryOut.getList();
        String file = inquiryIn.getFile();

        try (Statement statement = inquiryOut.connect()) {
            inquiryOut.inq0(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (OutputStream fos = new FileOutputStream(file)) {
            InquiryOutput output = new InquiryOutput(fos, list);
            output.writeData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Готово!");
    }
}