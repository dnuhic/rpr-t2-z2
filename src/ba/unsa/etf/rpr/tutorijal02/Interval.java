package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaT, krajnjaT;
    private boolean PocPripada, KrPripada;

    public Interval(double pocetnaT, double krajnjaT, boolean pocPripada, boolean krPripada) {
        this.pocetnaT = pocetnaT;
        this.krajnjaT = krajnjaT;
        PocPripada = pocPripada;
        KrPripada = krPripada;
        if(this.pocetnaT > this.krajnjaT)
                throw new IllegalArgumentException("Neispravna pocetna ili kranja tacka.");
    }



}
