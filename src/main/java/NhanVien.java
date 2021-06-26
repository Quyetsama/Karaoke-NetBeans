import java.io.Serializable;

public class NhanVien implements Serializable {
    protected String mnv, ht, ns, gt, dt;
    protected long luong;

    public NhanVien(){}

    public NhanVien(String mnv, String ht, String ns, String gt, String dt){
        this.mnv = mnv;
        this.ht = ht;
        this.ns = ns;
        this.gt = gt;
        this.dt = dt;
    }

    public String loaiNhanVien(){
        return "";
    }

    public void setChucVu(int chucVu){}
    public int getChucVu(){
        return 0;
    }

    public void TinhLuong(){
    }

    public void Show(){
//        System.out.println("Mã nhân viên: " + this.mnv);
//        System.out.println("Chức vụ: " + this.loaiNhanVien());
//        System.out.println("Họ tên: " + this.ht);
//        System.out.println("Ngày sinh: " + this.ns);
//        System.out.println("Giới tính: " + this.gt);
//        System.out.println("Lương: " + this.luong);

        System.out.format("%20s %40s %40s %20s %20s %20s %20s \n", this.mnv, this.ht, this.loaiNhanVien(), this.ns, this.gt, this.dt, this.luong);
    }

    public String getMnv() {
        return mnv;
    }

    public void setMnv(String mnv) {
        this.mnv = mnv;
    }

    public String getHt() {
        return ht;
    }

    public void setHt(String ht) {
        this.ht = ht;
    }

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public long getLuong() {
        return luong;
    }

    public void setLuong(long luong) {
        this.luong = luong;
    }

    //FullTime
    public int getNgayLamThem() {
        return 0;
    }

    public void setNgayLamThem(int ngayLamThem) {
    }

    //PartTime
    public int getGioLamViec() {
        return 0;
    }

    public void setGioLamViec(int gioLamViec) {

    }
}

class NhanVienFullTime extends NhanVien{
    private int ngayLamThem;
    private int chucVu;

    public NhanVienFullTime(){}

// Đa hình ở constructor

    public NhanVienFullTime(String mnv, String ht, String ns, String gt, String dt, int ngayLamThem) {
        super(mnv, ht, ns, gt, dt);
        this.ngayLamThem = ngayLamThem;
        this.chucVu = Configs.NHAN_VIEN_FULLTIME; //Mặc định là fulltime

//        this.TinhLuong();
    }
    public NhanVienFullTime(String mnv, String ht, String ns, String gt, String dt) {
        super(mnv, ht, ns, gt, dt);
        this.chucVu = Configs.NHAN_VIEN_FULLTIME;

//        this.TinhLuong();
    }




    @Override
    public String loaiNhanVien() {
        if(this.chucVu == Configs.NHAN_VIEN_FULLTIME){
            return "Nhân viên FullTime" + (this.ngayLamThem > 0 ? " Có làm thêm " + this.ngayLamThem + " ngày" : "");
        }else{
            return "Quản lý" + (this.ngayLamThem > 0 ? " Có làm thêm " + this.ngayLamThem + " ngày" : "");
        }
    }

    @Override
    public void TinhLuong() {
        if(this.chucVu == Configs.NHAN_VIEN_FULLTIME){
            this.luong = Configs.LUONG_NHAN_VIEN_FULL_TIME + this.ngayLamThem * Configs.LUONG_LAM_THEM_MOI_NGAY;
        }else{
            this.luong = Configs.LUONG_NHAN_VIEN_FULL_TIME_QUANLY + this.ngayLamThem * Configs.LUONG_LAM_THEM_MOI_NGAY;
        }
    }

    @Override
    public void Show() {
        super.Show();
    }

    @Override
    public void setChucVu(int chucVu) {
        this.chucVu = chucVu;
    }
    @Override
    public int getChucVu() {
        return this.chucVu;
    }

    @Override
    public int getNgayLamThem() {
        return this.ngayLamThem;
    }
    @Override
    public void setNgayLamThem(int ngayLamThem) {
        this.ngayLamThem = ngayLamThem;
    }


}

class NhanVienPartTime extends NhanVien{
    private int gioLamViec;

    public NhanVienPartTime(){}

    public NhanVienPartTime(String mnv, String ht, String ns, String gt, String dt, int gioLamViec) {
        super(mnv, ht, ns, gt, dt);
        this.gioLamViec = gioLamViec;

//        this.TinhLuong();
    }

    @Override
    public String loaiNhanVien() {
        return "Nhân viên PartTime";
    }

    @Override
    public void TinhLuong() {
        this.luong = Configs.LUONG_NHAN_VIEN_PART_TIME_MOI_GIO * this.gioLamViec;
    }

    @Override
    public void Show() {
        super.Show();
    }

    @Override
    public int getGioLamViec() {
        return this.gioLamViec;
    }
    @Override
    public void setGioLamViec(int gioLamViec) {
        this.gioLamViec = gioLamViec;
    }
}
