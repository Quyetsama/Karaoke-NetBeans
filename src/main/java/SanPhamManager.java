import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SanPhamManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<SanPham> sanphamList;
    private SanPhamDAO sanphamDAO;

    public SanPhamManager() {
        sanphamDAO = new SanPhamDAO();
        sanphamList = sanphamDAO.read();
    }

    public boolean CheckMNCC(String mnv){
        NhaCungCapManager managerNCC = new NhaCungCapManager();

        for(int i = 0; i < managerNCC.getNhaCungCapList().size(); i++){
            if(managerNCC.getNhaCungCapList().get(i).getMncc().equals(mnv)){
                return true;
            }
        }
        System.out.println("Ma nha cung cap khong ton tai, vui long nhap lai!");
        return false;
    }

    public void Add() {
        String msp;

        System.out.println("Ma san pham: ");
        String[] s = null;
        if(sanphamList.size() == 0){
            msp = "SP1";
        }
        else{
            s = sanphamList.get(sanphamList.size()-1).getMsp().split("SP");
            msp = "SP" + (Integer.parseInt(s[1]) + 1);
        }
        System.out.println(msp);
        System.out.println("Ten san pham: ");
        String tenSP = scanner.nextLine();

        System.out.println("So luong: ");
        int soLuong = nhapSoLuong();

        System.out.println("Don gia: ");
        float donGia = nhapDonGia();


        
        NhaCungCapManager managerNCC = new NhaCungCapManager();
        String mncc;
        String dsNCC = "";


        for(int i = 0; i < managerNCC.getNhaCungCapList().size(); i++){
            if(i==0){
                dsNCC += "" + managerNCC.getNhaCungCapList().get(i).getMncc();
            }else {
                dsNCC +=", " + managerNCC.getNhaCungCapList().get(i).getMncc();
            }
        }
        
        System.out.println("Nha cung cap (" + dsNCC + "): ");
        do{
            mncc = scanner.nextLine();
        }while (!CheckMNCC(mncc));

        SanPham sp = new SanPham(msp, tenSP, soLuong, donGia, mncc);
        sanphamList.add(sp);
        sanphamDAO.write(sanphamList);
    }

    public void Edit(String msp) {
        boolean isExisted = false;
        int size = sanphamList.size();
        for (int i = 0; i < size; i++) {
            if(sanphamList.get(i).getMsp().equals(msp)) {
                isExisted = true;

                SanPham sp;

                String tenSP;
                int sl;
                String sl1;
                float donGia;
                String donGia1;
                String mncc;



                System.out.println("Ten san pham - nhap 'k' de bo qua: "); tenSP = scanner.nextLine();
                if(tenSP.equals("k")){
                    tenSP = sanphamList.get(i).getTenSP();
                }

                System.out.println("So luong - nhap 'k' de bo qua: "); 
                
                while(true){
                    try{
                        sl1 = scanner.nextLine();
                        if(sl1.equals("k")){
                            sl = sanphamList.get(i).getSoLuong();
                        }else{
                            sl = Integer.parseInt(sl1);
                        }
                        break;
                    }catch(NumberFormatException ex){
                        System.out.println("loi dinh dang, vui long nhap lai: ");
                    }
                }
                


                System.out.println("Don gia - nhap 'k' de bo qua: "); 
                
                while(true){
                    try{
                        donGia1 = scanner.nextLine();
                        if(donGia1.equals("k")){
                            donGia = sanphamList.get(i).getDonGia();
                        }else{
                            donGia = Float.parseFloat(donGia1);
                        }
                        break;
                    }catch(NumberFormatException ex){
                        System.out.println("loi dinh dang, vui long nhap lai: ");
                    }
                }
                
                


                
                NhaCungCapManager managerNCC = new NhaCungCapManager();
                String dsNCC = "";


                for(int j = 0; j < managerNCC.getNhaCungCapList().size(); j++){
                    if(j==0){
                        dsNCC += "" + managerNCC.getNhaCungCapList().get(j).getMncc();
                    }else {
                        dsNCC += ", " + managerNCC.getNhaCungCapList().get(j).getMncc();
                    }
                }
                
                System.out.println("Nha cung cap - nhap 'k' de bo qua (" + dsNCC + "): ");
                do{
                    mncc = scanner.nextLine();

                    if(mncc.equals("k")){
                        break;
                    }
                }while (!CheckMNCC(mncc));

                if(mncc.equals("k")){
                    mncc = sanphamList.get(i).getMancc();
                }



                sp = new SanPham(msp, tenSP, sl, donGia, mncc);


                sanphamList.set(i,sp);

                break;
            }
        }
        if(!isExisted) {
            System.out.println("Ma san pham khong hop le!");
        }else {
            sanphamDAO.write(sanphamList);
        }
    }

    public void Delete(String msp) {
        SanPham sp = null;
        int size = sanphamList.size();
        for (int i = 0; i < size; i++) {
            if(sanphamList.get(i).getMsp().equals(msp)) {
                sp = sanphamList.get(i);
                break;
            }
        }
        if(sp != null) {
            sanphamList.remove(sp);
            sanphamDAO.write(sanphamList);
        }
        else {
            System.out.println("Ma san pham khong hop le!");
        }
    }
    
    public int nhapSoLuong(){
        int chucvu;
        while(true){
            try{
                chucvu = Integer.parseInt(scanner.nextLine());
                return chucvu;
            }catch(NumberFormatException ex){
                System.out.println("loi dinh dang, vui long nhap lai: ");
            }
        }
    }
    
    public float nhapDonGia(){
        float dongia;
        while(true){
            try{
                dongia = Float.parseFloat(scanner.nextLine());
                return dongia;
            }catch(NumberFormatException ex){
                System.out.println("loi dinh dang, vui long nhap lai: ");
            }
        }
    }

    public void SortSanPhamPrice() {
        List<SanPham> listSort = new ArrayList<>(sanphamList);
        for(int i = 0 ; i < listSort.size() ; i ++){
            for( int j = listSort.size() - 1 ; j > i ; j --){
                if(listSort.get(j).getDonGia() > listSort.get(i).getDonGia()){
                    SanPham tmp = listSort.get(j);
                    listSort.set(j, listSort.get(i));
                    listSort.set(i, tmp);

                }
            }
        }

        // Ghi danh sach da sap xep vao file
        sanphamDAO.write(listSort, "sortSanPhamPrice.txt");

        System.out.println("______________________Danh sach san pham______________________");
        System.out.format("%20s %20s %20s %20s %20s \n", "Ma san pham", "Ten san pham", "So luong", "Don gia", "Nha cung cap");
        for (SanPham sanPham : listSort) {
            sanPham.Show();
        }
    }

    public void SortSanPhamName(){
        List<SanPham> listSort = new ArrayList<>(sanphamList);
        for(int i = 0 ; i < listSort.size() ; i ++){
            for( int j = listSort.size() - 1 ; j > i ; j --){
                if(listSort.get(j).getTenSP().compareTo(listSort.get(i).getTenSP()) < 0){
                    SanPham tmp = listSort.get(j);
                    listSort.set(j, listSort.get(i));
                    listSort.set(i, tmp);

                }
            }
        }

        // Ghi danh sach da sap xep vao file
        sanphamDAO.write(listSort, "SortSanPhamName.txt");

        System.out.println("______________________Danh sach san pham______________________");
        System.out.format("%20s %20s %20s %20s %20s \n", "Ma san pham", "Ten san pham", "So luong", "Don gia", "Nha cung cap");
        for (SanPham sanPham : listSort) {
            sanPham.Show();
        }
    }

    public void FindMSP(String msp){
        System.out.println("______________________Danh sach tim kiem san pham______________________");
        System.out.format("%20s %20s %20s %20s %20s \n", "Ma san pham", "Ten san pham", "So luong", "Don gia", "Nha cung cap");

        List<SanPham> listFind = new ArrayList<>(sanphamList);
        for(int i = 0 ; i < listFind.size() ; i ++){
            if(listFind.get(i).getMsp().contains(msp)){
                listFind.get(i).Show();
            }
        }
    }

    public void FindName(String name){
        System.out.println("______________________Danh sach tim kiem san pham______________________");
        System.out.format("%20s %20s %20s %20s %20s \n", "Ma san pham", "Ten san pham", "So luong", "Don gia", "Nha cung cap");

        List<SanPham> listFind = new ArrayList<>(sanphamList);
        for(int i = 0 ; i < listFind.size() ; i ++){
            if(listFind.get(i).getTenSP().contains(name)){
                listFind.get(i).Show();
            }
        }
    }

    public void show() {
        System.out.println("______________________Danh sach san pham______________________");
        System.out.format("%20s %20s %20s %20s %20s \n", "Ma san pham", "Ten san pham", "So luong", "Don gia", "Nha cung cap");
        for (SanPham sp : sanphamList) {
            sp.Show();

        }
    }

}

