package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaT, krajnjaT;
    private boolean PocPripada, KrPripada;

    public Interval() {
        pocetnaT = 0; krajnjaT = 0;
        PocPripada = false; KrPripada = false;
    }

    public Interval(double pocetnaT, double krajnjaT, boolean pocPripada, boolean krPripada) {
        this.pocetnaT = pocetnaT; this.krajnjaT = krajnjaT;
        PocPripada = pocPripada; KrPripada = krPripada;
        if(this.pocetnaT > this.krajnjaT)
                throw new IllegalArgumentException("Neispravna pocetna ili kranja tacka.");
    }

    public boolean isNull() {
        return pocetnaT == 0 && krajnjaT == 0 && !PocPripada && !KrPripada;
    }

    public boolean isIn(double t) {
        if(PocPripada)
            if(KrPripada) return t >= pocetnaT && t <= krajnjaT;
            else return t >= pocetnaT && t < krajnjaT;
        else
            if(KrPripada) return t > pocetnaT && t <= krajnjaT;
            else return t > pocetnaT && t < krajnjaT;
    }

    public Interval intersect(Interval i) {
        if(pocetnaT > i.pocetnaT)
            if(krajnjaT < i.krajnjaT) return new Interval(pocetnaT, krajnjaT, PocPripada, KrPripada);
            else return new Interval(pocetnaT, i.krajnjaT, PocPripada, i.KrPripada);
        else
            if(krajnjaT < i.krajnjaT) return new Interval(i.pocetnaT, krajnjaT, i.PocPripada, KrPripada);
            else return new Interval(i.pocetnaT, i.krajnjaT, i.PocPripada, i.KrPripada);
    }

    public static Interval intersect(Interval i1, Interval i2) {
        if(i1.pocetnaT > i2.pocetnaT)
            if(i1.krajnjaT < i2.krajnjaT) return new Interval(i1.pocetnaT, i1.krajnjaT, i1.PocPripada, i1.KrPripada);
            else return new Interval(i1.pocetnaT, i2.krajnjaT, i1.PocPripada, i2.KrPripada);
        else
            if(i1.krajnjaT < i2.krajnjaT) return new Interval(i2.pocetnaT, i1.krajnjaT, i2.PocPripada, i1.KrPripada);
            else return new Interval(i2.pocetnaT, i2.krajnjaT, i2.PocPripada, i2.KrPripada);
    }

    @Override
    public String toString() {
        String s = "";
        if(pocetnaT == krajnjaT) return s + "()";
        if(PocPripada) s = s + "[";
        else s = s + "(";
        s = s + pocetnaT + "," + krajnjaT;
        if(KrPripada) s = s + "]";
        else s = s + ")";
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Interval) {
            Interval i = (Interval) obj;
            return i.pocetnaT == pocetnaT && i.krajnjaT == krajnjaT && PocPripada == i.PocPripada && KrPripada == i.KrPripada;
        }
        return false;
    }
}
