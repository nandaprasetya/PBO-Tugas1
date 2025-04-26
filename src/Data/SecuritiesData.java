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
        Stocks bbri = new Stocks("BBRI", "Bank Rakyat Indonesia", 3700, "Finance");
        bbri.getPriceHistory().addAll(List.of(3650.0, 3600.0, 3700.0, 3750.0, 3700.0, 3800.0, 4150.0));
        stocksList.add(bbri);

        Stocks bbca = new Stocks("BBCA", "Bank Central Asia", 7900, "Finance");
        bbca.getPriceHistory().addAll(List.of(7800.0, 7900.0, 7950.0, 8000.0, 8100.0, 8050.0, 8000.0));
        stocksList.add(bbca);

        Stocks pwon = new Stocks("PWON", "Pakuwon Jati", 396, "Property");
        pwon.getPriceHistory().addAll(List.of(400.0, 395.0, 400.0, 405.0, 399.0, 397.0, 396.0));
        stocksList.add(pwon);

        Stocks bsde = new Stocks("BSDE", "Bumi Serpong Damai", 860, "Property");
        bsde.getPriceHistory().addAll(List.of(855.0, 860.0, 865.0, 870.0, 860.0, 880.0, 875.0));
        stocksList.add(bsde);

        Stocks jsma = new Stocks("JSMR", "Jasa Marga", 3800, "Infrastructure");
        jsma.getPriceHistory().addAll(List.of(3750.0, 3800.0, 3900.0, 3850.0, 3800.0, 4000.0, 3950.0));
        stocksList.add(jsma);

        Stocks ptpp = new Stocks("PTPP", "Pembangunan Perumahan", 1000, "Infrastructure");
        ptpp.getPriceHistory().addAll(List.of(1020.0, 1005.0, 1010.0, 1020.0, 1000.0, 990.0, 980.0));
        stocksList.add(ptpp);

        Stocks bmri = new Stocks("BMRI", "Bank Mandiri", 7000, "Finance");
        bmri.getPriceHistory().addAll(List.of(6950.0, 7050.0, 7100.0, 7200.0, 7150.0, 7250.0, 7300.0));
        stocksList.add(bmri);

        Stocks smgr = new Stocks("SMGR", "Semen Gresik", 10250, "Property");
        smgr.getPriceHistory().addAll(List.of(10300.0, 10250.0, 10200.0, 10150.0, 10200.0, 10250.0, 10300.0));
        stocksList.add(smgr);

        Stocks wika = new Stocks("WIKA", "Wijaya Karya", 2300, "Infrastructure");
        wika.getPriceHistory().addAll(List.of(2250.0, 2300.0, 2350.0, 2400.0, 2300.0, 2250.0, 2200.0));
        stocksList.add(wika);


        sbnsList.add(new SBNs("FR0087", "Obligasi Negara 2025", 1000000, 10000, 6, 12, LocalDate.of(2025, 1, 1)));
        sbnsList.add(new SBNs("ORI021", "ORI Seri 021", 1500000, 5000, 5.5, 12, LocalDate.of(2025, 11, 12)));
    }

    public static ArrayList<Stocks> getStocksList() {
        return stocksList;
    }
}
