package ba.unsa.etf.rpr.tutorijal02;

import java.util.*;  //da bi se mogla koristiti fukcija "Math.abs(x)"

public class Interval
{
    double t1, t2;
    boolean t1_p, t2_p;

    public Interval(double t1, double t2, boolean t1_p, boolean t2_p)  throws IllegalArgumentException //kostruktor
    {
        try
        {
            final double EPSILON = 0.0001;
            if( t1-t2 < EPSILON)
                throw new IllegalArgumentException("Pocetna tacka veca od krajnje");
        }
        catch(IllegalArgumentException objekat)
        {
            System.out.println(objekat.getMessage() );
        }

        this.t2=t2;
        this.t1=t1;
        this.t2_p=t2_p;
        this.t1_p=t1_p;

    }

    public String toString()
    {
        String s;

        if(t1==0 && t2==0)
        {
           s="()";
        }
        else
        {
            if(t1_p==true)               //"bollean" tipovi elemenata se mogu porediti na jednakost sa operatorom "==", jer spada u POD tipove
                s="[";
            else if(t1_p==false)
                s=s"(";

            s= s+ (t1+","+t2);

            if(t2_p==true)
                s=s+ "]";
            else if(t2_p==false)
                s=s+")";
        }
        return s;
    }

    public Interval()
    {
        t1=0;
        t2=0;
        t1_p=false;
        t2_p=false;
    }

    public boolean isIn(double t3)
    {
        final double EPSILON = 0.0001;

        if(t1_p==false && t2_p==false)
        {
            if(t3<t1 || t3>t2 || Math.abs(t3-t1)<EPSILON || Math.abs(t3-t2)<EPSILON )
                return false;

            return true;
        }
        else if(t1_p==false && t2_p==true)
        {
            if(t3<t1 || t3>t2 || Math.abs(t3-t1)<EPSILON )
                return false;

            return true;
        }
        else if(t1_p==true && t2_p==false)
        {
            if(t3<t1 || t3>t2 || Math.abs(t3-t2)<EPSILON )
                return false;

            return true;
        }
        else if(t1_p==true && t2_p==true)
        {
            if(t3<t1 || t3>t2 )
                return false;

            return true;
        }

    }

    public boolean isNull()
    {
        if(t1==0 && t2==0 && t1_p==false && t2_p==false)
            return true;

        return false;
    }

    public Interval intersects(Interval i2) throws Exception
    {
        if( this.isIn(i2.t1)==true )
        {
            if(this.isIn(i2.t2)==true )
                return new Interval (i2.t1, i2.t2, true, true);
            else(this.isIn(i2.t2)==false)
                return new Interval (i2.t1, this.t2, true, true);
        }
        else if( this.isIn(i2.t1)==false)
        {
            //mozda su krajnje tacke i2 vece od onih objekta nad kojim se vrsi metoda
            if(i2.isIn(this.t1)==true)
            {
                if(i2.isIn(this.t2)==true)
                    return new Interval (this.t1, this.t2, true, true);
                else if(i2.isIn(this.t2)==false)
                    return new Interval(this.t1, i2.t2, true, true);
            }
            else if(i2.isIn(this.t1)==false)
            {
                if(i2.isIn(this.t2)==true)
                    return new Interval(i2.t1, this.t2, true, true);
                else if(i2.isIn(this.t2)==false)
                    throw new Exception ("Intervali se ne sijeku");

            }
        }

    }

    /*@org.junit.jupiter.api.Test
    void intersect() {
        Interval i = new Interval(1.1, 2.5, true, false);
        Interval i2 = i.intersect(new Interval(2.2, 2.6, true, true));
        assertEquals("[2.2,2.5)", i2.toString());
    }
    @org.junit.jupiter.api.Test
    void intersect1() {
        Interval i = new Interval(1.1, 2.5, true, false);
        Interval i2 = new Interval(2.2, 2.6, true, true);
        Interval i3 = Interval.intersect(i, i2);
        assertEquals("[2.2,2.5)", i3.toString());
    }
    @org.junit.jupiter.api.Test
    void intersect2() {
        Interval i = new Interval(1.1, 10.5, true, false);
        Interval i2 = new Interval(2.2, 2.6, true, true);
        Interval i3 = Interval.intersect(i, i2);
        assertEquals("[2.2,2.6]", i3.toString());
    }
    @org.junit.jupiter.api.Test
    void intersect3() {
        Interval i = new Interval(-1.1, 2.5, true, false);
        Interval i2 = new Interval(2.2, 3.6, false, true);
        Interval i3 = Interval.intersect(i, i2);
        assertEquals("(2.2,2.5)", i3.toString());
    }*/

    public boolean equals(Interval i)
    {
        final double EPSILON=0.0001;

        if( Math.abs(t1-i.t1)<EPSILON && Math.abs(t2-i.t2)<EPSILON && t1_p==i.t1_p && t2_p==i.t2_p )
            return true;

        return false;
    }
    /*@org.junit.jupiter.api.Test
    void equals() {
        Interval i = new Interval(1.1, 2.5, true, false);
        Interval i2 = new Interval(1.1, 2.5, true, false);
        assertTrue(i.equals(i2));
    }
    @org.junit.jupiter.api.Test
    void equals2() {
        Interval i = new Interval(1.1, 2.5, true, false);
        Interval i2 = new Interval(1.1, 2.5, true, true);
        assertFalse(i.equals(i2));
    }*/
}
