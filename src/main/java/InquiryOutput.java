import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/*
* */


public class InquiryOutput {
    private OutputStream out;
    private ArrayList<String> list;

    public InquiryOutput(OutputStream out, ArrayList list) {
        this.out = out;
        this.list = list;
    }

    public void writeData() {
        System.out.println("Запись в файл");
        for (String i : list) {
            try {
                out.write(i.getBytes());
                out.write("\n".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
