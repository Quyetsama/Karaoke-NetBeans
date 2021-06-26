import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NhanVienManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<NhanVien> nhanVienList;
    private NhanVienDAO nhanVienDAO;

    public NhanVienManager(){
        nhanVienDAO = new NhanVienDAO();
        nhanVienList = nhanVienDAO.read();
    }

    public void Add(){
        int chucVu = 2;
        String mnv, ht, ns, gt, dt;
        long luong;


        System.out.println("Ma nhan vien: ");
        String[] s = null;
        if(nhanVienList.size() == 0){
            mnv = "NV1";
        }
        else{
            s = nhanVienList.get(nhanVienList.size()-1).getMnv().split("NV");
            mnv = "NV" + (Integer.parseInt(s[1]) + 1);
        }
        System.out.println(mnv);
        System.out.println("Chuc vu (1: Quan ly, 2: FullTime, 3: PartTime): "); 
        
        chucVu = nhapChucVu();
//        while(true){
//            try{
//                chucVu = Integer.parseInt(scanner.nextLine());
//                break;
//            }catch(NumberFormatException ex){
//                System.out.println("Lỗi định dạng, vui lòng nhập lại: ");
//            }
//        }
        
        


//        scanner.nextLine();
//        mnv = scanner.next();
        System.out.println("Ho ten: "); ht = scanner.nextLine();
        System.out.println("Ngay sinh: "); ns = scanner.nextLine();
        System.out.println("Gioi tinh: "); gt = scanner.nextLine();
        System.out.println("Dia chi: "); dt = scanner.nextLine();

        NhanVien nv;

        if(chucVu == 1){
            int lamThem;
            System.out.println("So ngay lam them: "); lamThem = nhapThoiGianLamViec();

            if(lamThem > 0){
                nv = new NhanVienFullTime(mnv, ht, ns, gt, dt, lamThem);
            }
            else {
                nv = new NhanVienFullTime(mnv, ht, ns, gt, dt);
            }

            nv.setChucVu(1);
        }
        else if(chucVu == 2){
            int lamThem;
            System.out.println("So ngay lam them: "); lamThem = nhapThoiGianLamViec();

            if(lamThem > 0){
                nv = new NhanVienFullTime(mnv, ht, ns, gt, dt, lamThem);
            }
            else {
                nv = new NhanVienFullTime(mnv, ht, ns, gt, dt);
            }
        }
        else {
            int gioLam;
            System.out.println("So gio lam viec: "); gioLam = nhapThoiGianLamViec();
            nv = new NhanVienPartTime(mnv, ht, ns, gt, dt, gioLam);
        }

        nv.TinhLuong();

        nhanVienList.add(nv);
        nhanVienDAO.write(nhanVienList);
    }

    public void Edit(String mnv) {
        boolean isExisted = false;
        int size = nhanVienList.size();
        for (int i = 0; i < size; i++) {
            if (nhanVienList.get(i).getMnv().equals(mnv.trim())) {
                isExisted = true;

                NhanVien nv;

                int chucVu;
                String chucVu1;
                String ht, ns, gt, dt;
                int lamThem, lamViec;

//                scanner.nextLine();
//                System.out.flush();
                System.out.println("Chuc vu (1: Quan ly, 2: FullTime, 3: PartTime) - nhap 'k' de bo qua: "); 
                
                while(true){
                    try{
                        chucVu1 = scanner.nextLine();
                        if(chucVu1.equals("k")){
                            chucVu = nhanVienList.get(i).getChucVu();
                        }else {
                            chucVu = Integer.parseInt(chucVu1);
                        }
                        break;
                    }catch(NumberFormatException ex){
                        System.out.println("Loi dinh dang, vui long nhap lai: ");
                    }
                }
                
               
                

                System.out.println("Ho ten - nhap 'k' de bo qua: "); ht = scanner.nextLine();
                if(ht.equals("k")){
                    ht = nhanVienList.get(i).getHt();
                }

                System.out.println("Ngay sinh - nhap 'k' de bo qua: "); ns = scanner.nextLine();
                if(ns.equals("k")){
                    ns = nhanVienList.get(i).getNs();
                }


                System.out.println("Gioi tinh - nhap 'k' de bo qua: "); gt = scanner.nextLine();
                if(gt.equals("k")){
                    gt = nhanVienList.get(i).getGt();
                }

                System.out.println("Dia chi - nhap 'k' de bo qua: "); dt = scanner.nextLine();
                if(dt.equals("k")){
                    dt = nhanVienList.get(i).getDt();
                }




                if(chucVu == 1){
                    System.out.println("So ngay lam them: "); lamThem = nhapThoiGianLamViec();

                    if(lamThem > 0){
                        nv = new NhanVienFullTime(mnv, ht, ns, gt, dt, lamThem);
                    }
                    else {
                        nv = new NhanVienFullTime(mnv, ht, ns, gt, dt);
                    }

                    nv.setChucVu(1);


                }
                else if(chucVu == 2){
                    System.out.println("So ngay lam them: "); lamThem = nhapThoiGianLamViec();
                    if(lamThem > 0){
                        nv = new NhanVienFullTime(mnv, ht, ns, gt, dt, lamThem);
                    }
                    else {
                        nv = new NhanVienFullTime(mnv, ht, ns, gt, dt);
                    }


                }
                else {
                    System.out.println("So gio lam viec: "); lamViec = nhapThoiGianLamViec();

                    nv = new NhanVienPartTime(mnv, ht, ns, gt, dt, lamViec);


                }

                nv.TinhLuong();
                nhanVienList.set(i, nv);

                break;
            }
        }
        if (!isExisted) {
            System.out.println("Ma nhan vien khong hop le!");
        } else {
            nhanVienDAO.write(nhanVienList);
        }
    }

    public void Delete(String mnv) {
        NhanVien nhanVien = null;
        int size = nhanVienList.size();
        for (int i = 0; i < size; i++) {
            if (nhanVienList.get(i).getMnv().equals(mnv)) {
                nhanVien = nhanVienList.get(i);
                break;
            }
        }
        if (nhanVien != null) {
            nhanVienList.remove(nhanVien);
            nhanVienDAO.write(nhanVienList);
        } else {
            System.out.println("Ma nhan vien khong hop le!");
        }
    }
    
    public int nhapChucVu(){
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
    public int nhapThoiGianLamViec(){
        int tg;
        while(true){
            try{
                tg = Integer.parseInt(scanner.nextLine());
                return tg;
            }catch(NumberFormatException ex){
                System.out.println("loi dinh dang, vui long nhap lai: ");
            }
        }
    }

    public void SortSalary(){
        List<NhanVien> listSort = new ArrayList<>(nhanVienList);
        for(int i = 0 ; i < listSort.size() ; i ++){
            for( int j = listSort.size() - 1 ; j > i ; j --){
                if(listSort.get(j).getLuong() > listSort.get(i).getLuong()){
                    NhanVien tmp = listSort.get(j);
                    listSort.set(j, listSort.get(i));
                    listSort.set(i, tmp);

                }
            }
        }

        // Ghi danh sach da sap xep vao file
        nhanVienDAO.write(listSort, "sortSalary.txt");

        System.out.println("______________________Danh sach nhan vien______________________");
        System.out.format("%20s %40s %40s %20s %20s %20s %20s \n", "Ma nhan vien", "Ho ten", "Chuc vu", "Ngay sinh", "Gioi tinh", "Dia chi", "Luong");
        for (NhanVien nhanVien : listSort) {
            nhanVien.Show();
        }
    }

    public void SortName(){
        List<NhanVien> listSort = new ArrayList<>(nhanVienList);
        for(int i = 0 ; i < listSort.size() ; i ++){
            for( int j = listSort.size() - 1 ; j > i ; j --){
                if(listSort.get(j).getHt().compareTo(listSort.get(i).getHt()) < 0){
                    NhanVien tmp = listSort.get(j);
                    listSort.set(j, listSort.get(i));
                    listSort.set(i, tmp);

                }
            }
        }

        // Ghi danh sach da sap xep vao file
        nhanVienDAO.write(listSort, "sortName.txt");

        System.out.println("______________________Danh sach nhan vien______________________");
        System.out.format("%20s %40s %40s %20s %20s %20s %20s \n", "Ma nhan vien", "Ho ten", "Chuc vu", "Ngay sinh", "Gioi tinh", "Dia chi", "Luong");
        for (NhanVien nhanVien : listSort) {
            nhanVien.Show();
        }
    }

    public void FindMNV(String mnv){
        System.out.println("______________________Danh sach tim kiem nhan vien______________________");
        System.out.format("%20s %40s %40s %20s %20s %20s %20s \n", "Ma nhan vien", "Ho ten", "Chuc vu", "Ngay sinh", "Gioi tinh", "Dia chi", "Luong");

        List<NhanVien> listFind = new ArrayList<>(nhanVienList);
        for(int i = 0 ; i < listFind.size() ; i ++){
            if(listFind.get(i).getMnv().contains(mnv)){
                listFind.get(i).Show();
            }
        }
    }

    public void FindName(String name){
        System.out.println("______________________Danh sach tim kiem nhan vien______________________");
        System.out.format("%20s %40s %40s %20s %20s %20s %20s \n", "Ma nhan vien", "Ho ten", "Chuc vu", "Ngay sinh", "Gioi tinh", "Dia chi", "Luong");

        List<NhanVien> listFind = new ArrayList<>(nhanVienList);
        for(int i = 0 ; i < listFind.size() ; i ++){
            if(listFind.get(i).getHt().contains(name)){
                listFind.get(i).Show();
            }
        }
    }

    public void show() {
        System.out.println("______________________Danh sach nhan vien______________________");
        System.out.format("%20s %40s %40s %20s %20s %20s %20s \n", "Ma nhan vien", "Ho ten", "Chuc vu", "Ngay sinh", "Gioi tinh", "Dia chi", "Luong");
        for (NhanVien nhanVien : nhanVienList) {
            nhanVien.Show();
        }
    }

    public List<NhanVien> getNhanVienList() {
        return nhanVienList;
    }
}

