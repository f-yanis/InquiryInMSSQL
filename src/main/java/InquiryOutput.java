import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class InquiryOutput {
    private OutputStream out;
    private ArrayList<String> list;

    public InquiryOutput(OutputStream out, ArrayList list) {
        this.out = out;
        this.list = list;
    }

    public void writeData() {
        for (String i : list) {

        }
    }
}
