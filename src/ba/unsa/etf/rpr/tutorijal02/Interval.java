package ba.unsa.etf.rpr.tutorijal02;

import static java.lang.Math.abs;

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
        else
            if(t > pocetnaT && t < krajnjaT) return true;
            else return false;
    }

    public Interval intersect(Interval i) {
        Interval temp = new Interval();
        //if(abs(pocetnaT - i.pocetnaT) <= 10e-7 &)
        if(pocetnaT > i.pocetnaT) temp.pocetnaT = pocetnaT;
        else temp.pocetnaT = i.pocetnaT;
        if(krajnjaT < i.krajnjaT) temp.krajnjaT = krajnjaT;
        else temp.pocetnaT = i.krajnjaT;
        return temp;
    }

    public static Interval intersect(Interval i1, Interval i2) {
        Interval temp = new Interval();
        //if(abs(pocetnaT - i.pocetnaT) <= 10e-7 &)
        if(i1.pocetnaT > i2.pocetnaT) temp.pocetnaT = i1.pocetnaT;
        else temp.pocetnaT = i2.pocetnaT;
        if(i1.krajnjaT < i2.krajnjaT) temp.krajnjaT = i1.krajnjaT;
        else temp.pocetnaT = i2.krajnjaT;
        return temp;
    }

}
