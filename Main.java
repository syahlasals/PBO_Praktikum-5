import java.util.ArrayList;
import java.util.List;

class Person {
    protected String nama;
    protected String alamat;
    public Person(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }
    @Override
    public String toString() {
        return "Nama: " + nama + ", Alamat: " + alamat;
    }
}

class Dosen extends Person {
    private String nip;
    public Dosen(String nama, String alamat, String nip) {
        super(nama, alamat);
        this.nip = nip;
    }
    @Override
    public String toString() {
        return super.toString() + ", NIP: " + nip;
    }
}

class Mahasiswa extends Person {
    private String nim;
    private Prodi prodi;
    public Mahasiswa(String nama, String alamat, String nim, Prodi prodi) {
        super(nama, alamat);
        this.nim = nim;
        this.prodi = prodi;
    }
    @Override
    public String toString() {
        return super.toString() + ", NIM: " + nim + ", Prodi: " + prodi.getNama();
    }
}

class MataKuliah {
    private String nama;
    public MataKuliah(String nama) {
        this.nama = nama;
    }
    @Override
    public String toString() {
        return nama;
    }
}

class Ruangan {
    private String kode;
    public Ruangan(String kode) {
        this.kode = kode;
    }
    @Override
    public String toString() {
        return kode;
    }
}

class Jadwal {
    private String tanggal;
    private String jam;
    private MataKuliah mataKuliah;
    private Ruangan ruangan;
    private Dosen dosen;
    public Jadwal(String tanggal, String jam, MataKuliah mataKuliah, Ruangan ruangan, Dosen dosen) {
        this.tanggal = tanggal;
        this.jam = jam;
        this.mataKuliah = mataKuliah;
        this.ruangan = ruangan;
        this.dosen = dosen;
    }
    @Override
    public String toString() {
        return "Hari: " + tanggal + ", Jam: " + jam + ", Mata Kuliah: " + mataKuliah + ", Ruangan: " + ruangan + ", Dosen: " + dosen.nama;
    }
}

class Prodi {
    private String nama;
    private Jurusan jurusan;
    
    public Prodi(String nama, Jurusan jurusan) {
        this.nama = nama;
        this.jurusan = jurusan;
    }
    
    public String getNama() {
        return nama;
    }
    
    @Override
    public String toString() {
        return "Prodi: " + nama + ", " + jurusan;
    }
}

class Jurusan {
    private String nama;
    private List<Prodi> prodis;
    
    public Jurusan(String nama) {
        this.nama = nama;
        this.prodis = new ArrayList<>();
    }
    
    public void addProdi(Prodi prodi) {
        prodis.add(prodi);
    }
    
    @Override
    public String toString() {
        return "Jurusan: " + nama;
    }
}

public class Main {
    public static void main(String[] args) {
        // Membuat data jurusan
        Jurusan jurusanTI = new Jurusan("Teknik Komputer dan Informatika");
        
        // Membuat data prodi
        Prodi prodiD3 = new Prodi("D3 Teknik Informatika", jurusanTI);
        jurusanTI.addProdi(prodiD3);
        
        // Membuat data mahasiswa
        List<Mahasiswa> mahasiswas = new ArrayList<>();
        mahasiswas.add(new Mahasiswa("Ani", "Jl. Merdeka No. 123, Jakarta", "NIM1001", prodiD3));
        mahasiswas.add(new Mahasiswa("Budi", "Jl. Pahlawan No. 45, Surabaya", "NIM1002", prodiD3));
        mahasiswas.add(new Mahasiswa("Cindy Muliawati", "Jl. Diponegoro No. 67, Bandung", "NIM1003", prodiD3));
        mahasiswas.add(new Mahasiswa("Dodi Pratama", "Jl. Sudirman No. 89, Semarang", "NIM1004", prodiD3));
        mahasiswas.add(new Mahasiswa("Eka Putri", "Jl. Gajah Mada No. 12, Yogyakarta", "NIM1005", prodiD3));
        
        mahasiswas.add(new Mahasiswa("Fanny", "Jl. Merdeka No. 123, Jakarta", "NIM1001", prodiD3));
        mahasiswas.add(new Mahasiswa("Gian", "Jl. Pahlawan No. 45, Surabaya", "NIM1002", prodiD3));
        mahasiswas.add(new Mahasiswa("Hana", "Jl. Diponegoro No. 67, Bandung", "NIM1003", prodiD3));
        mahasiswas.add(new Mahasiswa("Ino", "Jl. Sudirman No. 89, Semarang", "NIM1004", prodiD3));
        mahasiswas.add(new Mahasiswa("Jeno", "Jl. Gajah Mada No. 12, Yogyakarta", "NIM1005", prodiD3));
        
        // Membuat data dosen
        List<Dosen> dosens = new ArrayList<>();
        dosens.add(new Dosen("Pa Yadhi", "Jl. Cendana No. 78, Jakarta", "NIP2001"));
        dosens.add(new Dosen("Pa Yudhi", "Jl. Melati No. 56, Bandung", "NIP2002"));
        dosens.add(new Dosen("Pa Suprihanto", "Jl. Anggrek No. 34, Surabaya", "NIP2003"));
        dosens.add(new Dosen("Pa Trisna", "Jl. Kenanga No. 90, Yogyakarta", "NIP2004"));
        dosens.add(new Dosen("Pa Ade", "Jl. Flamboyan No. 23, Semarang", "NIP2005"));
        
        dosens.add(new Dosen("Pa Rizky", "Jl. Cendana No. 78, Jakarta", "NIP2001"));
        dosens.add(new Dosen("Bu Santi", "Jl. Melati No. 56, Bandung", "NIP2002"));
        dosens.add(new Dosen("Pa Irawan", "Jl. Anggrek No. 34, Surabaya", "NIP2003"));
        dosens.add(new Dosen("Pa Irwan", "Jl. Kenanga No. 90, Yogyakarta", "NIP2004"));
        dosens.add(new Dosen("Pa Zul", "Jl. Flamboyan No. 23, Semarang", "NIP2005"));
        dosens.add(new Dosen("Bu Ade", "Jl. Flamboyan No. 23, Semarang", "NIP2005"));
        
        // Membuat data mata kuliah
        List<MataKuliah> mataKuliahs = new ArrayList<>();
        mataKuliahs.add(new MataKuliah("PBO Teori"));
        mataKuliahs.add(new MataKuliah("Komgraf Teori"));
        mataKuliahs.add(new MataKuliah("Matdis 2"));
        mataKuliahs.add(new MataKuliah("Komgraf Praktek"));
        mataKuliahs.add(new MataKuliah("Basis Data Teori"));
        mataKuliahs.add(new MataKuliah("Aljabar Linear"));
        mataKuliahs.add(new MataKuliah("PRPL Teori"));
        mataKuliahs.add(new MataKuliah("Proyek 3"));
        mataKuliahs.add(new MataKuliah("PRPL Praktek"));
        mataKuliahs.add(new MataKuliah("PBO Praktek"));
        mataKuliahs.add(new MataKuliah("Basis Data Praktek"));
        
        // Membuat data ruangan
        List<Ruangan> ruangans = new ArrayList<>();
        ruangans.add(new Ruangan("D217"));
        ruangans.add(new Ruangan("D217"));
        ruangans.add(new Ruangan("D217"));
        ruangans.add(new Ruangan("D111"));
        ruangans.add(new Ruangan("D101"));
        ruangans.add(new Ruangan("D101"));
        ruangans.add(new Ruangan("D101"));
        ruangans.add(new Ruangan("D111"));
        ruangans.add(new Ruangan("Lab. Database"));
        ruangans.add(new Ruangan("Lab. Database"));
        ruangans.add(new Ruangan("Lab. Database"));
        
        // Membuat jadwal senin 
        List<Jadwal> senins = new ArrayList<>();
        senins.add(new Jadwal("Senin", "08:40-10:40", mataKuliahs.get(0), ruangans.get(0), dosens.get(0)));
        senins.add(new Jadwal("Senin", "10:40-12:20", mataKuliahs.get(1), ruangans.get(0), dosens.get(1)));
        senins.add(new Jadwal("Senin", "13:00-15:30", mataKuliahs.get(2), ruangans.get(0), dosens.get(2)));
        senins.add(new Jadwal("Senin", "15:40-18:20", mataKuliahs.get(3), ruangans.get(1), dosens.get(3)));
        
        List<Jadwal> selasas = new ArrayList<>();
        selasas.add(new Jadwal("Selasa", "07:00-12:00", mataKuliahs.get(1), ruangans.get(1), dosens.get(1)));
        selasas.add(new Jadwal("Selasa", "13:00-15:00", mataKuliahs.get(2), ruangans.get(2), dosens.get(2)));
        selasas.add(new Jadwal("Selasa", "15:00-17:00", mataKuliahs.get(3), ruangans.get(3), dosens.get(3)));
        selasas.add(new Jadwal("Selasa", "08:00-10:00", mataKuliahs.get(4), ruangans.get(4), dosens.get(4)));
        
        List<Jadwal> rabus = new ArrayList<>();
        rabus.add(new Jadwal("Selasa", "10:00-12:00", mataKuliahs.get(1), ruangans.get(1), dosens.get(1)));
        rabus.add(new Jadwal("Rabu", "13:00-15:00", mataKuliahs.get(2), ruangans.get(2), dosens.get(2)));
        rabus.add(new Jadwal("Kamis", "15:00-17:00", mataKuliahs.get(3), ruangans.get(3), dosens.get(3)));
        rabus.add(new Jadwal("Jumat", "08:00-10:00", mataKuliahs.get(4), ruangans.get(4), dosens.get(4)));
        
        List<Jadwal> kamiss = new ArrayList<>();
        kamiss.add(new Jadwal("Selasa", "10:00-12:00", mataKuliahs.get(1), ruangans.get(1), dosens.get(1)));
        kamiss.add(new Jadwal("Rabu", "13:00-15:00", mataKuliahs.get(2), ruangans.get(2), dosens.get(2)));
        kamiss.add(new Jadwal("Kamis", "15:00-17:00", mataKuliahs.get(3), ruangans.get(3), dosens.get(3)));
        kamiss.add(new Jadwal("Jumat", "08:00-10:00", mataKuliahs.get(4), ruangans.get(4), dosens.get(4)));
        
        List<Jadwal> jumats = new ArrayList<>();
        jumats.add(new Jadwal("Selasa", "10:00-12:00", mataKuliahs.get(1), ruangans.get(1), dosens.get(1)));
        jumats.add(new Jadwal("Rabu", "13:00-15:00", mataKuliahs.get(2), ruangans.get(2), dosens.get(2)));
        jumats.add(new Jadwal("Kamis", "15:00-17:00", mataKuliahs.get(3), ruangans.get(3), dosens.get(3)));
        jumats.add(new Jadwal("Jumat", "08:00-10:00", mataKuliahs.get(4), ruangans.get(4), dosens.get(4)));
        
        // Menampilkan data mahasiswa
        System.out.println("Data Mahasiswa:");
        for (Mahasiswa mahasiswa : mahasiswas) {
            System.out.println(mahasiswa);
        }
        
        System.out.println("\nData Dosen:");
        for (Dosen dosen : dosens) {
            System.out.println(dosen);
        }
        
        System.out.println("\nJadwal Perkuliahan Senin:");
        for (Jadwal senin : senins) {
            System.out.println(senin);
        }
        System.out.println("\nJadwal Perkuliahan Selasa:");
        for (Jadwal selasa : selasas) {
            System.out.println(selasa);
        }
        System.out.println("\nJadwal Perkuliahan Rabu:");
        for (Jadwal rabu : rabus) {
            System.out.println(rabu);
        }
        System.out.println("\nJadwal Perkuliahan Kamis:");
        for (Jadwal kamis : kamiss) {
            System.out.println(kamis);
        }
        System.out.println("\nJadwal Perkuliahan Jumat:");
        for (Jadwal jumat : jumats) {
            System.out.println(jumat);
        }
        
        System.out.println("\nData Jurusan dan Prodi:");
        System.out.println(jurusanTI + " - " + prodiD3);
        System.out.println(jurusanTI + " - " + prodiD3);
    }
}