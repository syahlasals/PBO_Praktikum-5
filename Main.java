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
        // data jurusan
        Jurusan jurusanTI = new Jurusan("Teknik Komputer dan Informatika");
        
        // data prodi
        Prodi prodiD3 = new Prodi("D3 Teknik Informatika", jurusanTI);
        jurusanTI.addProdi(prodiD3);
        
        // data mahasiswa
        List<Mahasiswa> mahasiswas = new ArrayList<>();
        mahasiswas.add(new Mahasiswa("Aulia", "Jl. Ciwaruga No. 19, Garut", "231511070", prodiD3));
        mahasiswas.add(new Mahasiswa("Agra", "Jl. Sarijadi No. 45, Bandung", "NIM1002", prodiD3));
        mahasiswas.add(new Mahasiswa("Berliana", "Jl. Kopo No. 67, Bandung", "NIM1003", prodiD3));
        mahasiswas.add(new Mahasiswa("Elsa", "Jl. Batujajar No. 89, Bandung", "NIM1004", prodiD3));
        mahasiswas.add(new Mahasiswa("Isyana", "Jl. Gajah Mada No. 12, Cirebon", "NIM1005", prodiD3));
        
        mahasiswas.add(new Mahasiswa("Jihan", "Jl. Merdeka No. 123, Bandung", "NIM1001", prodiD3));
        mahasiswas.add(new Mahasiswa("Melly", "Jl. Pahlawan No. 45, Cimahi", "NIM1002", prodiD3));
        mahasiswas.add(new Mahasiswa("Sifa", "Jl. Diponegoro No. 67, Tasik", "231511092", prodiD3));
        mahasiswas.add(new Mahasiswa("Syahla", "Jl. Rancabentang No. 31, Cimahi", "231511095", prodiD3));
        mahasiswas.add(new Mahasiswa("Yulina", "Jl. Sarijadi No. 12, Tegal", "231511096", prodiD3));
        
        // data dosen
        List<Dosen> dosens = new ArrayList<>();
        dosens.add(new Dosen("Yadhi Aditya P.", "Jl. Cendana No. 78, Bandung", "23150001"));
        dosens.add(new Dosen("Yudi Widhiyasana", "Jl. Melati No. 56, Bandung", "23150002"));
        dosens.add(new Dosen("Suprihanto", "Jl. Anggrek No. 34, Bandung", "23150003"));
        dosens.add(new Dosen("Trisna Gelar A", "Jl. Kenanga No. 90, Bandung", "23150004"));
        dosens.add(new Dosen("Ade Chandra Nugraha", "Jl. Flamboyan No. 23, Bandung", "23150005"));
        
        dosens.add(new Dosen("Muhammad Rizky S", "Jl. Cendana No. 78, Bandung", "23150006"));
        dosens.add(new Dosen("Santi Sundari", "Jl. Melati No. 56, Bandung", "23150007"));
        dosens.add(new Dosen("Irawan Thamrin", "Jl. Anggrek No. 34, Bandung", "23150008"));
        dosens.add(new Dosen("Irwan Setiawan", "Jl. Kenanga No. 90, Bandung", "23150009"));
        dosens.add(new Dosen("Zulkifli Arsyad", "Jl. Flamboyan No. 23, Bandung", "23150010"));
        dosens.add(new Dosen("Ade Hodijah", "Jl. Flamboyan No. 23, Bandung", "23150011"));
        
        // data mata kuliah
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
        
        // data ruangan
        List<Ruangan> ruangans = new ArrayList<>();
        ruangans.add(new Ruangan("D217"));
        ruangans.add(new Ruangan("Lab. MT"));
        ruangans.add(new Ruangan("D101"));
        ruangans.add(new Ruangan("Lab. Database"));
        
        // data jadwal perkuliahan
        List<Jadwal> senins = new ArrayList<>();
        senins.add(new Jadwal("Senin", "08:40-10:40", mataKuliahs.get(0), ruangans.get(0), dosens.get(0)));
        senins.add(new Jadwal("Senin", "10:40-12:20", mataKuliahs.get(1), ruangans.get(0), dosens.get(1)));
        senins.add(new Jadwal("Senin", "13:00-15:30", mataKuliahs.get(2), ruangans.get(0), dosens.get(2)));
        senins.add(new Jadwal("Senin", "15:40-18:20", mataKuliahs.get(3), ruangans.get(1), dosens.get(3)));
        
        List<Jadwal> selasas = new ArrayList<>();
        selasas.add(new Jadwal("Selasa", "07:00-08:40", mataKuliahs.get(4), ruangans.get(2), dosens.get(4)));
        selasas.add(new Jadwal("Selasa", "08:40-10:40", mataKuliahs.get(5), ruangans.get(2), dosens.get(5)));
        selasas.add(new Jadwal("Selasa", "10:40-12:20", mataKuliahs.get(6), ruangans.get(2), dosens.get(6)));
        
        List<Jadwal> rabus = new ArrayList<>();
        rabus.add(new Jadwal("Rabu", "07:00-07:50", mataKuliahs.get(7), ruangans.get(1), dosens.get(3)));
        rabus.add(new Jadwal("Rabu", "07:50-16:40", mataKuliahs.get(7), ruangans.get(1), dosens.get(3)));
        rabus.add(new Jadwal("Rabu", "07:50-16:40", mataKuliahs.get(7), ruangans.get(1), dosens.get(7)));
        rabus.add(new Jadwal("Rabu", "07:50-16:40", mataKuliahs.get(7), ruangans.get(1), dosens.get(8)));
        
        List<Jadwal> kamiss = new ArrayList<>();
        kamiss.add(new Jadwal("Kamis", "09:50-15:30", mataKuliahs.get(8), ruangans.get(3), dosens.get(0)));
        kamiss.add(new Jadwal("Kamis", "15:50-18:20", mataKuliahs.get(9), ruangans.get(3), dosens.get(9)));
        
        List<Jadwal> jumats = new ArrayList<>();
        jumats.add(new Jadwal("Jumat", "07:00-13:50", mataKuliahs.get(10), ruangans.get(3), dosens.get(10)));
        
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