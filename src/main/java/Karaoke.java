import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Karaoke {
    public static void main(String[] args) {

        String x = null;
        Scanner sc = new Scanner(System.in);
        boolean cont1 = true;
        do{
            System.out.println("___________________MENU___________________");
            System.out.println("1, Quan ly nhan vien");
            System.out.println("2, Quan ly san pham");
            System.out.println("3, Quan ly nha cung cap");
            System.out.println("4, Quan ly hoa don");
            System.out.println("5, Thoat");
            x = sc.nextLine();
            switch (x){
                case "1":
                    NhanVienManager manager = new NhanVienManager();

                    boolean cont2 = true;
                    do{
                        System.out.println("___________________QUAN LY NHAN VIEN___________________");
                        System.out.println("1, Them");
                        System.out.println("2, Sua");
                        System.out.println("3, Xoa");
                        System.out.println("4, Tim kiem");
                        System.out.println("5, Sap xep");
                        System.out.println("6, Hien thi danh sach");
                        System.out.println("7, Quay lai");

                        String y = null;
                        y = sc.nextLine();
                        switch (y){
                            case "1":
                                manager.Add();
                                break;
                            case "2":
                                System.out.println("Nhap ma nhan vien can sua: ");
                                manager.Edit(sc.nextLine());
                                break;
                            case "3":
                                System.out.println("Nhap ma nhan vien can xoa: ");
                                manager.Delete(sc.nextLine());
                                break;
                            case "4":
                                System.out.println("1, Ma nhan vien");
                                System.out.println("2, Ten");

                                String z = null;
                                z = sc.nextLine();

                                switch (z){
                                    case "1":
                                        System.out.println("Nhap ma nhan vien can tim: ");
                                        manager.FindMNV(sc.nextLine());
                                        break;
                                    case "2":
                                        System.out.println("Nhap ten nhan vien can tim: ");
                                        manager.FindName(sc.nextLine());
                                        break;
                                }

                                break;
                            case "5":
                                System.out.println("1, Ten");
                                System.out.println("2, Luong");

                                String t = null;
                                t = sc.nextLine();

                                switch (t){
                                    case "1":
                                        manager.SortName();
                                        break;
                                    case "2":
                                        manager.SortSalary();
                                        break;
                                }

                                break;
                            case "6":
                                manager.show();
                                break;
                            case "7":
                                cont2= false;
                                break;
                        }
                    }while (cont2);
                    break;

                case "2":
                    SanPhamManager managerSP = new SanPhamManager();

                    boolean cont3 = true;
                    do{
                        System.out.println("___________________QUAN LY SAN PHAM___________________");
                        System.out.println("1, Them");
                        System.out.println("2, Sua");
                        System.out.println("3, Xoa");
                        System.out.println("4, Tim kiem");
                        System.out.println("5, Sap xep");
                        System.out.println("6, Hien thi danh sach");
                        System.out.println("7, Quay lai");

                        String y = null;
                        y = sc.nextLine();
                        switch (y){
                            case "1":
                                managerSP.Add();
                                break;
                            case "2":
                                System.out.println("Nhap ma san pham can sua: ");
                                managerSP.Edit(sc.nextLine());
                                break;
                            case "3":
                                System.out.println("Nhap ma san pham can xoa: ");
                                managerSP.Delete(sc.nextLine());
                                break;
                            case "4":
                                System.out.println("1, Ma san pham");
                                System.out.println("2, Ten");

                                String z = null;
                                z = sc.nextLine();

                                switch (z){
                                    case "1":
                                        System.out.println("Nhap ma san pham can tim: ");
                                        managerSP.FindMSP(sc.nextLine());
                                        break;
                                    case "2":
                                        System.out.println("Nhap ten san pham can tim: ");
                                        managerSP.FindName(sc.nextLine());
                                        break;
                                }
                                break;
                            case "5":
                                System.out.println("1, Ten");
                                System.out.println("2, Don gia");

                                String t = null;
                                t = sc.nextLine();

                                switch (t){
                                    case "1":
                                        managerSP.SortSanPhamName();
                                        break;
                                    case "2":
                                        managerSP.SortSanPhamPrice();
                                        break;
                                }
                                break;
                            case "6":
                                managerSP.show();
                                break;
                            case "7":
                                cont3= false;
                                break;
                        }
                    }while (cont3);
                    break;
                case "3":

                    NhaCungCapManager managerNCC = new NhaCungCapManager();

                    boolean cont4 = true;
                    do{
                        System.out.println("___________________QUAN LY NHA CUNG CAP___________________");
                        System.out.println("1, Them");
                        System.out.println("2, Sua");
                        System.out.println("3, Xoa");
                        System.out.println("4, Tim kiem");
                        System.out.println("5, Sap xep (Theo ten)");
                        System.out.println("6, Hien thi danh sach");
                        System.out.println("7, Quay lai");

                        String y = null;
                        y = sc.nextLine();
                        switch (y){
                            case "1":
                                managerNCC.Add();
                                break;
                            case "2":
                                System.out.println("Nhap ma nha cung cap can sua: ");
                                managerNCC.Edit(sc.nextLine());
                                break;
                            case "3":
                                System.out.println("Nhap ma nha cung cap can xoa: ");
                                managerNCC.Delete(sc.nextLine());
                                break;
                            case "4":
                                System.out.println("Nhap ma nha cung cap can tim: ");
                                managerNCC.FindMNCC(sc.nextLine());
                                break;
                            case "5":
                                managerNCC.SortByName();
                                break;
                            case "6":
                                managerNCC.show();
                                break;
                            case "7":
                                cont4= false;
                                break;
                        }
                    }while (cont4);

                    break;

                case "4":

                    HoaDonManager managerHD = new HoaDonManager();

                    boolean cont5 = true;
                    do{
                        System.out.println("___________________QUAN LY HOA DON___________________");
                        System.out.println("1, Them");
                        System.out.println("2, Sua");
                        System.out.println("3, Xoa");
                        System.out.println("4, Tim kiem");
                        System.out.println("5, Sap xep (Thanh tien)");
                        System.out.println("6, Hien thi danh sach");
                        System.out.println("7, Quay lai");

                        String y = null;
                        y = sc.nextLine();
                        switch (y){
                            case "1":
                                managerHD.Add();
                                break;
                            case "2":
                                System.out.println("Nhap ma hoa don can sua: ");
                                managerHD.Edit(sc.nextLine());
                                break;
                            case "3":
                                System.out.println("Nhap ma hoa don can xoa: ");
                                managerHD.Delete(sc.nextLine());
                                break;
                            case "4":
                                System.out.println("Nhap ma hoa don can tim: ");
                                managerHD.FindMHD(sc.nextLine());
                                break;
                            case "5":
                                managerHD.SortHoaDon();
                                break;
                            case "6":
                                managerHD.show();
                                break;
                            case "7":
                                cont5= false;
                                break;
                        }
                    }while (cont5);

                    break;

                case "5":
                    cont1 = false;
                    break;
            }
        }while (cont1);

    }
}
