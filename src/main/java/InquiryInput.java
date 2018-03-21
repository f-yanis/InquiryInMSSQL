import java.io.InputStream;

/*
 * Берет из внешней среды:
 *   - SQL запрос (не точно)
 *   - connectionUrl(не точно)
 *   - путь до файла "AvayaLogger.txt" (можно задать имя файла)
 * В конструктор получает имя файла с конфигурацией*/


public class InquiryInput {
    InputStream in;
    private String file = "C:\\Users\\y.fayzullin\\Desktop\\AvayaLogger.txt";

    public String getFile() {
        return file;
    }
}
