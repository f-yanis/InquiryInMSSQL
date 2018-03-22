import java.io.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Inquiry inquiryOut = new Inquiry();
        InquiryInput input;
        InquiryOutput output;
        String filePath = new File("").getAbsolutePath() + "\\config.properties";
        ArrayList<String> list = inquiryOut.getList();

        try (Statement statement = inquiryOut.connect()) {
            inquiryOut.inq0(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (InputStream fis = new FileInputStream(filePath)) {
            input = new InquiryInput(fis);
            input.readConfig();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (OutputStream fos = new FileOutputStream(InquiryInput.getFilePath())) {
            output = new InquiryOutput(fos, list);
            output.writeData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}