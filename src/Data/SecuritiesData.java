package Data;

import Securities.SBNs;
import Securities.Stocks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SecuritiesData {
    public static ArrayList<Stocks> stocksList = new ArrayList<>();
    public static ArrayList<SBNs> sbnsList = new ArrayList<>();

    static {
        Stocks bbri = new Stocks("BBRI", "Bank Rakyat Indonesia", 3700, "Keuangan");
        bbri.getPriceHistory().addAll(List.of(3650.0, 3750.0, 3800.0, 3700.0, 3600.0, 3900.0, 4000.0));
        stocksList.add(bbri);

        Stocks bbca = new Stocks("BBCA", "Bank Central Asia", 7900, "Keuangan");
        bbca.getPriceHistory().addAll(List.of(7800.0, 8000.0, 8100.0, 8000.0, 7900.0, 8200.0, 8300.0));
        stocksList.add(bbca);

        Stocks pwon = new Stocks("PWON", "Pakuwon Jati", 396, "Properti");
        pwon.getPriceHistory().addAll(List.of(400.0, 430.0, 460.0, 450.0, 440.0, 480.0, 490.0));
        stocksList.add(pwon);

        Stocks bsde = new Stocks("BSDE", "Bumi Serpong Damai", 860, "Properti");
        bsde.getPriceHistory().addAll(List.of(855.0, 880.0, 900.0, 920.0, 910.0, 940.0, 950.0));
        stocksList.add(bsde);

        Stocks jsma = new Stocks("JSMR", "Jasa Marga", 3800, "Infrastruktur");
        jsma.getPriceHistory().addAll(List.of(3750.0, 3900.0, 3950.0, 3800.0, 3700.0, 4000.0, 4100.0));
        stocksList.add(jsma);

        Stocks ptpp = new Stocks("PTPP", "Pembangunan Perumahan", 1000, "Infrastruktur");
        ptpp.getPriceHistory().addAll(List.of(1020.0, 1050.0, 1080.0, 1100.0, 1070.0, 1050.0, 1020.0));
        stocksList.add(ptpp);

        Stocks bmri = new Stocks("BMRI", "Bank Mandiri", 7000, "Keuangan");
        bmri.getPriceHistory().addAll(List.of(6950.0, 7150.0, 7250.0, 7200.0, 7300.0, 7400.0, 7500.0));
        stocksList.add(bmri);

        Stocks smgr = new Stocks("SMGR", "Semen Gresik", 10250, "Properti");
        smgr.getPriceHistory().addAll(List.of(10300.0, 10250.0, 10350.0, 10150.0, 10200.0, 10400.0, 10350.0));
        stocksList.add(smgr);

        Stocks wika = new Stocks("WIKA", "Wijaya Karya", 2300, "Infrastruktur");
        wika.getPriceHistory().addAll(List.of(2250.0, 2400.0, 2500.0, 2450.0, 2300.0, 2200.0, 2150.0));
        stocksList.add(wika);

        Stocks tlkm = new Stocks("TLKM", "Telkom Indonesia", 3500, "Telekomunikasi");
        tlkm.getPriceHistory().addAll(List.of(3400.0, 3550.0, 3650.0, 3600.0, 3500.0, 3550.0, 3500.0));
        stocksList.add(tlkm);

        Stocks unvr = new Stocks("UNVR", "Unilever Indonesia", 8500, "Konsumsi");
        unvr.getPriceHistory().addAll(List.of(8400.0, 8600.0, 8700.0, 8550.0, 8500.0, 8450.0, 8300.0));
        stocksList.add(unvr);

        Stocks adro = new Stocks("ADRO", "Adaro Energy", 1400, "Energi");
        adro.getPriceHistory().addAll(List.of(1350.0, 1500.0, 1600.0, 1450.0, 1550.0, 1500.0, 1400.0));
        stocksList.add(adro);

        Stocks hmsp = new Stocks("HMSP", "Hanjaya Mandala Sampoerna", 12000, "Konsumsi");
        hmsp.getPriceHistory().addAll(List.of(11800.0, 12200.0, 12500.0, 12150.0, 12000.0, 11900.0, 11800.0));
        stocksList.add(hmsp);

        Stocks rpln = new Stocks("RPLN", "PLN (Perusahaan Listrik Negara)", 1400, "Utilitas");
        rpln.getPriceHistory().addAll(List.of(1375.0, 1420.0, 1450.0, 1405.0, 1390.0, 1380.0, 1350.0));
        stocksList.add(rpln);

        Stocks pgas = new Stocks("PGAS", "Perusahaan Gas Negara", 2200, "Energi");
        pgas.getPriceHistory().addAll(List.of(2150.0, 2250.0, 2300.0, 2230.0, 2210.0, 2190.0, 2200.0));
        stocksList.add(pgas);

        Stocks indf = new Stocks("INDF", "Indofood Sukses Makmur", 8000, "Konsumsi");
        indf.getPriceHistory().addAll(List.of(7900.0, 8050.0, 8100.0, 8000.0, 7950.0, 7900.0, 7800.0));
        stocksList.add(indf);

        Stocks giaa = new Stocks("GIAA", "Garuda Indonesia", 60, "Transportasi");
        giaa.getPriceHistory().addAll(List.of(58.0, 65.0, 75.0, 72.0, 70.0, 68.0, 60.0));
        stocksList.add(giaa);

        Stocks btpn = new Stocks("BTPN", "Bank Tabungan Pensiunan Nasional", 3800, "Keuangan");
        btpn.getPriceHistory().addAll(List.of(3750.0, 3850.0, 3900.0, 3800.0, 3780.0, 3760.0, 3750.0));
        stocksList.add(btpn);

        Stocks antm = new Stocks("ANTM", "Antam (Aneka Tambang)", 2500, "Pertambangan");
        antm.getPriceHistory().addAll(List.of(2450.0, 2550.0, 2600.0, 2550.0, 2500.0, 2450.0, 2500.0));
        stocksList.add(antm);

        Stocks bbni = new Stocks("BBNI", "Bank Negara Indonesia", 6700, "Keuangan");
        bbni.getPriceHistory().addAll(List.of(6600.0, 6750.0, 6800.0, 6750.0, 6700.0, 6650.0, 6600.0));
        stocksList.add(bbni);

        Stocks pani = new Stocks("PANI", "Pantai Indah Kapuk Dua", 1500, "Real Estat");
        pani.getPriceHistory().addAll(List.of(1450.0, 1550.0, 1600.0, 1550.0, 1520.0, 1500.0, 1480.0));
        stocksList.add(pani);

        Stocks gotoshm = new Stocks("GOTO", "GoTo", 2000, "Teknologi");
        gotoshm.getPriceHistory().addAll(List.of(1950.0, 2050.0, 2100.0, 2050.0, 2000.0, 1950.0, 1900.0));
        stocksList.add(gotoshm);

        Stocks asii = new Stocks("ASII", "Astra International", 7800, "Otomotif");
        asii.getPriceHistory().addAll(List.of(7700.0, 7800.0, 7900.0, 7950.0, 7850.0, 7800.0, 7700.0));
        stocksList.add(asii);

        Stocks alfm = new Stocks("ALFM", "Alfamart", 1500, "Ritel");
        alfm.getPriceHistory().addAll(List.of(1480.0, 1520.0, 1550.0, 1500.0, 1480.0, 1470.0, 1460.0));
        stocksList.add(alfm);

        Stocks bren = new Stocks("BREN", "Brenex", 1100, "Teknologi");
        bren.getPriceHistory().addAll(List.of(1050.0, 1150.0, 1200.0, 1150.0, 1100.0, 1050.0, 1000.0));
        stocksList.add(bren);

        Stocks myor = new Stocks("MYOR", "Mayora Indah", 2000, "Konsumsi");
        myor.getPriceHistory().addAll(List.of(1950.0, 2050.0, 2100.0, 2050.0, 2000.0, 1950.0, 1900.0));
        stocksList.add(myor);

        Stocks buka = new Stocks("BUKA", "Bukalapak", 1000, "Teknologi");
        buka.getPriceHistory().addAll(List.of(950.0, 1050.0, 1100.0, 1050.0, 1000.0, 950.0, 900.0));
        stocksList.add(buka);

        Stocks sido = new Stocks("SIDO", "Sidomuncul", 1200, "Farmasi");
        sido.getPriceHistory().addAll(List.of(1150.0, 1250.0, 1300.0, 1250.0, 1200.0, 1150.0, 1100.0));
        stocksList.add(sido);

        Stocks silo = new Stocks("SILO", "Siloam Hospitals", 3200, "Kesehatan");
        silo.getPriceHistory().addAll(List.of(3150.0, 3250.0, 3300.0, 3250.0, 3200.0, 3150.0, 3100.0));
        stocksList.add(silo);

        Stocks inaf = new Stocks("INAF", "Indofarma", 800, "Farmasi");
        inaf.getPriceHistory().addAll(List.of(780.0, 820.0, 830.0, 820.0, 800.0, 780.0, 750.0));
        stocksList.add(inaf);

        Stocks ctra = new Stocks("CTRA", "Ciputra Development", 1200, "Real Estat");
        ctra.getPriceHistory().addAll(List.of(1180.0, 1220.0, 1240.0, 1220.0, 1200.0, 1180.0, 1160.0));
        stocksList.add(ctra);

        Stocks lpkr = new Stocks("LPKR", "Lippo Karawaci", 1300, "Real Estat");
        lpkr.getPriceHistory().addAll(List.of(1280.0, 1320.0, 1340.0, 1320.0, 1300.0, 1280.0, 1250.0));
        stocksList.add(lpkr);

        Stocks ultj = new Stocks("ULTJ", "Ultra Jaya Milk", 3000, "Konsumsi");
        ultj.getPriceHistory().addAll(List.of(2950.0, 3000.0, 3050.0, 3100.0, 3000.0, 2980.0, 2900.0));
        stocksList.add(ultj);

        Stocks good = new Stocks("GOOD", "Garuda Food Putra Putri", 6800, "Konsumsi");
        good.getPriceHistory().addAll(List.of(6700.0, 6800.0, 6900.0, 6850.0, 6800.0, 6750.0, 6600.0));
        stocksList.add(good);

        Stocks mppa = new Stocks("MPPA", "Matahari Putra Prima", 2300, "Ritel");
        mppa.getPriceHistory().addAll(List.of(2200.0, 2250.0, 2300.0, 2350.0, 2250.0, 2200.0, 2150.0));
        stocksList.add(mppa);

        Stocks cmry = new Stocks("CMRY", "Cisarua Mountain Dairy", 1500, "Konsumsi");
        cmry.getPriceHistory().addAll(List.of(1450.0, 1500.0, 1550.0, 1530.0, 1500.0, 1480.0, 1450.0));
        stocksList.add(cmry);

        sbnsList.add(new SBNs("FR0089", "Obligasi Negara 2028", 1200000, 9000, 7, 12, LocalDate.of(2028, 5, 1)));
        sbnsList.add(new SBNs("FR0092", "Obligasi Negara 2030", 1000000, 12000, 6.75, 12, LocalDate.of(2030, 7, 1)));
        sbnsList.add(new SBNs("FR0091", "Obligasi Negara 2031", 1200000, 13000, 7.25, 12, LocalDate.of(2031, 2, 10)));
        sbnsList.add(new SBNs("FR0093", "Obligasi Negara 2032", 1250000, 14000, 7.5, 12, LocalDate.of(2032, 1, 1)));
        sbnsList.add(new SBNs("FR0094", "Obligasi Negara 2033", 1300000, 15000, 7.75, 12, LocalDate.of(2033, 4, 15)));
        sbnsList.add(new SBNs("FR0095", "Obligasi Negara 2034", 1350000, 16000, 7.5, 12, LocalDate.of(2034, 6, 20)));
        sbnsList.add(new SBNs("FR0096", "Obligasi Negara 2035", 1400000, 17000, 8, 12, LocalDate.of(2035, 3, 15)));
        sbnsList.add(new SBNs("FR0097", "Obligasi Negara 2036", 1450000, 18000, 8.25, 12, LocalDate.of(2036, 2, 10)));
        sbnsList.add(new SBNs("FR0098", "Obligasi Negara 2037", 1500000, 19000, 8.5, 12, LocalDate.of(2037, 7, 1)));
        sbnsList.add(new SBNs("FR0099", "Obligasi Negara 2038", 1550000, 20000, 8.75, 12, LocalDate.of(2038, 5, 5)));
        sbnsList.add(new SBNs("FR0100", "Obligasi Negara 2039", 1600000, 21000, 9, 12, LocalDate.of(2039, 10, 10)));
        sbnsList.add(new SBNs("FR0101", "Obligasi Negara 2040", 1650000, 22000, 9.25, 12, LocalDate.of(2040, 1, 20)));
        sbnsList.add(new SBNs("FR0102", "Obligasi Negara 2041", 1700000, 23000, 9.5, 12, LocalDate.of(2041, 8, 1)));
        sbnsList.add(new SBNs("FR0103", "Obligasi Negara 2042", 1750000, 24000, 9.75, 12, LocalDate.of(2042, 6, 15)));
        sbnsList.add(new SBNs("FR0104", "Obligasi Negara 2043", 1800000, 25000, 10, 12, LocalDate.of(2043, 3, 20)));
        sbnsList.add(new SBNs("FR0105", "Obligasi Negara 2044", 1850000, 26000, 10.25, 12, LocalDate.of(2044, 7, 5)));
        sbnsList.add(new SBNs("FR0106", "Obligasi Negara 2045", 1900000, 27000, 10.5, 12, LocalDate.of(2045, 12, 1)));
        sbnsList.add(new SBNs("ORI025", "ORI Seri 025", 1150000, 8000, 6.85, 12, LocalDate.of(2027, 9, 5)));
        sbnsList.add(new SBNs("ORI026", "ORI Seri 026", 1200000, 10000, 7, 12, LocalDate.of(2028, 1, 25)));
        sbnsList.add(new SBNs("ORI027", "ORI Seri 027", 1250000, 13000, 7.15, 12, LocalDate.of(2028, 6, 10)));
        sbnsList.add(new SBNs("ORI028", "ORI Seri 028", 1300000, 14000, 7.3, 12, LocalDate.of(2028, 11, 15)));
        sbnsList.add(new SBNs("ORI029", "ORI Seri 029", 1350000, 15000, 7.5, 12, LocalDate.of(2029, 4, 20)));
        sbnsList.add(new SBNs("ORI030", "ORI Seri 030", 1400000, 16000, 7.6, 12, LocalDate.of(2029, 8, 10)));
        sbnsList.add(new SBNs("ORI031", "ORI Seri 031", 1450000, 17000, 7.8, 12, LocalDate.of(2030, 2, 15)));
        sbnsList.add(new SBNs("ORI032", "ORI Seri 032", 1500000, 18000, 8, 12, LocalDate.of(2030, 7, 25)));
        sbnsList.add(new SBNs("ORI033", "ORI Seri 033", 1550000, 19000, 8.15, 12, LocalDate.of(2031, 3, 5)));
        sbnsList.add(new SBNs("ORI034", "ORI Seri 034", 1600000, 20000, 8.3, 12, LocalDate.of(2031, 8, 1)));
        sbnsList.add(new SBNs("ORI035", "ORI Seri 035", 1650000, 21000, 8.5, 12, LocalDate.of(2032, 1, 30)));
        sbnsList.add(new SBNs("ORI036", "ORI Seri 036", 1700000, 22000, 8.6, 12, LocalDate.of(2032, 7, 20)));
        sbnsList.add(new SBNs("ORI037", "ORI Seri 037", 1750000, 23000, 8.8, 12, LocalDate.of(2033, 2, 10)));
        sbnsList.add(new SBNs("ORI038", "ORI Seri 038", 1800000, 24000, 9, 12, LocalDate.of(2033, 8, 15)));
    }

    public static ArrayList<Stocks> getStocksList() {
        return stocksList;
    }
}
