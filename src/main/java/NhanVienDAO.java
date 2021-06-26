import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {
    private static final String nhanVien_File = "nhanvien.txt";

    public void write(List<NhanVien> nhanVienList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(nhanVien_File));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(nhanVienList);

            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public void write(List<NhanVien> nhanVienList, String file) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(file));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(nhanVienList);

            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }


    public List<NhanVien> read() {
        List<NhanVien> nhanVienList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(nhanVien_File));
            ois = new ObjectInputStream(fis);
            nhanVienList = (List<NhanVien>) ois.readObject();

            fis.close();
            ois.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        return nhanVienList;
    }
}
