import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * Берет из внешней среды:
 *   - SQL запрос (не точно)
 *   - connectionUrl(не точно)
 *   - путь до файла "AvayaLogger.txt" (можно задать имя файла)
 * В конструктор получает имя файла с конфигурацией*/


public class InquiryInput {
    private InputStream in;
    private Properties properties;
    private static String filePath;
    private int b;

    public InquiryInput(InputStream in) {
        this.in = in;
        this.properties = new Properties();
    }

    public void readConfig() throws IOException {
        properties.load(in);
        filePath = properties.getProperty("path");
    }

    public static String getFilePath() {
        return filePath;
    }
}
