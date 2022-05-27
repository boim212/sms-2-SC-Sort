package Sorting;
public class Mahasiswa implements Comparable{
    private String nama;
    private int nim;
    private String alamat;

    public Mahasiswa() {
    }

    public Mahasiswa(String nama, int nim) {
        this.nama = nama;
        this.nim = nim;
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

//    @Override
//    public int compareTo(Object o) {
////        Mahasiswa temp = (Mahasiswa)o;
//        if (this.nim > ((Mahasiswa)o).getNim()) {
//            return 1;
//        }else if (this.nim < ((Mahasiswa)o).getNim()) {
//            return -1;
//        }else{
//            return 0;
//        }
//    }
    
    @Override
    public int compareTo(Object o) {
        Mahasiswa temp = (Mahasiswa)o;
        if (this.nama.compareTo(temp.getNama()) >= 0) {
            return 1;
        }else if (this.nama.compareTo(temp.getNama()) < 0) {
            return -1;
        }else{
            return 0;
        }
    }
    
}
