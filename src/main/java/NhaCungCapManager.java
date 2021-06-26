import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NhaCungCapManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<NhaCungCap> nhaCungCapList;
    private NhaCungCapDAO nhaCungCapDAO;

    public NhaCungCapManager() {
        nhaCungCapDAO = new NhaCungCapDAO();
        nhaCungCapList = nhaCungCapDAO.read();
    }



    public void Add() {
        String mncc;

        System.out.println("Ma nha cung cap: ");
        String[] s = null;
        if(nhaCungCapList.size() == 0){
            mncc = "NCC1";
        }
        else{
            s = nhaCungCapList.get(nhaCungCapList.size()-1).getMncc().split("NCC");
            mncc = "NCC" + (Integer.parseInt(s[1]) + 1);
        }
        System.out.println(mncc);



        System.out.println("Ten nha cung cap: ");
        String name = scanner.nextLine();

        System.out.println("So dien thoai: ");
        String sdt = scanner.nextLine();

        System.out.println("Dia chi: ");
        String address = scanner.nextLine();



        NhaCungCap ncc = new NhaCungCap(mncc, name, sdt, address);
        nhaCungCapList.add(ncc);
        nhaCungCapDAO.write(nhaCungCapList);
    }

    public void Edit(String mncc) {
        boolean isExisted = false;
        int size = nhaCungCapList.size();
        for (int i = 0; i < size; i++) {
            if(nhaCungCapList.get(i).getMncc().equals(mncc)) {
                isExisted = true;

                NhaCungCap ncc;

                String name, phone, address;


                System.out.println("Ten nha cung cap - nhap 'k' de bo qua: "); name = scanner.nextLine();
                if(name.equals("k")){
                    name = nhaCungCapList.get(i).getName();
                }



                System.out.println("So dien thoai - nhap 'k' de bo qua: "); phone = scanner.next();
                if(phone.equals("k")){
                    phone = nhaCungCapList.get(i).getPhone();
                }

                scanner.nextLine();

                System.out.println("Dia chi - nhap 'k' de bo qua: "); address = scanner.nextLine();
                if(address.equals("k")){
                    address = nhaCungCapList.get(i).getAddress();
                }






                ncc = new NhaCungCap(mncc, name, phone, address);


                nhaCungCapList.set(i,ncc);

                break;
            }
        }
        if(!isExisted) {
            System.out.println("Ma nha cung cap khong hop le!");
        }else {
            nhaCungCapDAO.write(nhaCungCapList);
        }
    }

    public void Delete(String mncc) {
        NhaCungCap ncc = null;
        int size = nhaCungCapList.size();
        for (int i = 0; i < size; i++) {
            if(nhaCungCapList.get(i).getMncc().equals(mncc)) {
                ncc = nhaCungCapList.get(i);
                break;
            }
        }
        if(ncc != null) {
            nhaCungCapList.remove(ncc);
            nhaCungCapDAO.write(nhaCungCapList);
        }
        else {
            System.out.println("Ma nha cung cap khong hop le!");
        }
    }

    public void SortByName() {
        List<NhaCungCap> listSort = new ArrayList<>(nhaCungCapList);
        for(int i = 0 ; i < listSort.size() ; i ++){
            for( int j = listSort.size() - 1 ; j > i ; j --){
                if(listSort.get(j).getName().compareTo(listSort.get(i).getName()) < 0){
                    NhaCungCap tmp = listSort.get(j);
                    listSort.set(j, listSort.get(i));
                    listSort.set(i, tmp);

                }
            }
        }

        // Ghi danh sach da sap xep vao file
        nhaCungCapDAO.write(listSort, "SortNhaCungCap.txt");

        System.out.println("______________________Danh sach nha cung cap______________________");
        System.out.format("%20s %20s %20s %20s \n", "Ma nha cung cap", "Ten nha cung cap", "So dien thoai", "Dia chi");
        for (NhaCungCap ncc : listSort) {
            ncc.Show();
        }
    }

    public void FindMNCC(String mncc){
        System.out.println("______________________Danh sach nha cung cap______________________");
        System.out.format("%20s %20s %20s %20s \n", "Ma nha cung cap", "Ten nha cung cap", "So dien thoai", "Dia chi");

        List<NhaCungCap> listFind = new ArrayList<>(nhaCungCapList);
        for(int i = 0 ; i < listFind.size() ; i ++){
            if(listFind.get(i).getMncc().contains(mncc)){
                listFind.get(i).Show();
            }
        }
    }

    public void show() {
        System.out.println("______________________Danh sach nha cung cap______________________");
        System.out.format("%20s %20s %20s %20s \n", "Ma nha cung cap", "Ten nha cung cap", "So dien thoai", "Dia chi");
        for (NhaCungCap ncc : nhaCungCapList) {
            ncc.Show();

        }
    }

    public List<NhaCungCap> getNhaCungCapList() {
        return nhaCungCapList;
    }
}

