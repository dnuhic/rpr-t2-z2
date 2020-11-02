package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaT, krajnjaT;
    private boolean PocPripada, KrPripada;

    public Interval() {
        pocetnaT = 0; krajnjaT = 0;
        PocPripada = false; KrPripada = false;
    }

    public Interval(double pocetnaT, double krajnjaT, boolean pocPripada, boolean krPripada) {
        this.pocetnaT = pocetnaT;
        this.krajnjaT = krajnjaT;
        PocPripada = pocPripada;
        KrPripada = krPripada;
        if(this.pocetnaT > this.krajnjaT)
                throw new IllegalArgumentException("Neispravna pocetna ili kranja tacka.");
    }

    public boolean isNull() {
        return pocetnaT == 0 && krajnjaT == 0 && !PocPripada && !KrPripada;
    }

    public boolean isIn(double t) {
        if(PocPripada && KrPripada)
            if(t >= pocetnaT && t <= krajnjaT) return true;
            else return false;
        else if(PocPripada && !KrPripada)
            if(t >= pocetnaT && t < krajnjaT) return true;
            else return false;
        else if(KrPripada && !PocPripada)
            if(t > pocetnaT && t <= krajnjaT) return true;
            else return false;
        else if(!KrPripada && !PocPripada)
            if(t > pocetnaT && t < krajnjaT) return true;
            else return false;
    }



}
