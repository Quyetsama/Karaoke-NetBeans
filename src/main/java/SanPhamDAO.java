import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {
    String path = "sanpham.txt";

    public void write(List<SanPham> sanphamList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(path));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(sanphamList);

            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
        }
    }

    public void write(List<SanPham> sanphamList, String file) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(file));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(sanphamList);

            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
        }
    }

    public List<SanPham> read() {
        List<SanPham> sanphamList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(path));
            ois = new ObjectInputStream(fis);
            sanphamList = (List<SanPham>) ois.readObject();

            fis.close();
            ois.close();
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
        }
        return sanphamList;
    }
}
