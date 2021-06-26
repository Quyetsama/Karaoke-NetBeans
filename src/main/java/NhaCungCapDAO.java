import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAO {
    String path = "nhacungcap.txt";

    public void write(List<NhaCungCap> nhaCungCapList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(path));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(nhaCungCapList);

            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
        }
    }

    public void write(List<NhaCungCap> nhaCungCapList, String file) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(file));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(nhaCungCapList);

            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
        }
    }

    public List<NhaCungCap> read() {
        List<NhaCungCap> nhaCungCapList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(path));
            ois = new ObjectInputStream(fis);
            nhaCungCapList = (List<NhaCungCap>) ois.readObject();

            fis.close();
            ois.close();
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
        }
        return nhaCungCapList;
    }
}
