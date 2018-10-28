package ba.unsa.etf.rpr.tutorijal02;

import java.util.*;  //da bi se mogla koristiti fukcija "Math.abs(x)"

public class Interval
{
    private double t1, t2;
    private boolean t1_p, t2_p;

    public Interval(double t1, double t2, boolean t1_p, boolean t2_p)  throws IllegalArgumentException //kostruktor
    {
        try
        {
            final double EPSILON = 0.0001;
            if( t1 > t2)
                throw new IllegalArgumentException("Pocetna tacka veca od krajnje");
        }
        catch(IllegalArgumentException objekat)
        {
            System.out.println( objekat.getMessage() );
            throw objekat;
        }

        this.t2=t2;
        this.t1=t1;
        this.t2_p=t2_p;
        this.t1_p=t1_p;

    }

    public String toString()
    {
        String s;

        if(t1==0 && t2==0 && t1_p==false && t2_p==false)
        {
           s="()";
        }
        else
        {
            if(t1_p==true)               //"bollean" tipovi elemenata se mogu porediti na jednakost sa operatorom "==", jer spada u POD tipove
                s="[";
            else
                s="(";

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

    public boolean isIn(double t3) {
        final double EPSILON = 0.0001;

        if (t1_p == false && t2_p == false)
        {
            if (t3 < t1 || t3 > t2 || Math.abs(t3 - t1) < EPSILON || Math.abs(t3 - t2) < EPSILON)
                return false;

            return true;
        }
        else if (t1_p == false && t2_p == true)
        {
            if (t3 < t1 || t3 > t2 || Math.abs(t3 - t1) < EPSILON)
                return false;

            return true;
        }
        else if (t1_p == true && t2_p == false)
        {
            if (t3 < t1 || t3 > t2 || Math.abs(t3 - t2) < EPSILON)
                return false;

            return true;
        }
        else if (t1_p == true && t2_p == true)
        {
            if (t3 < t1 || t3 > t2)
                return false;

            return true;
        }
        return false;//ZAsto
    }

    public boolean isNull()
    {
        if(t1==0 && t2==0 && t1_p==false && t2_p==false)
            return true;

        return false;
    }

    public Interval intersect(Interval i2)
    {
       if( this.isIn(i2.t1)==true )
       {
           if(i2.t1_p==true)
           {
               if(this.isIn(i2.t2)==true )
               {
                   if(i2.t2_p==true)
                       return new Interval (i2.t1, i2.t2, true, true);
                   else if(i2.t2_p==false)
                       return new Interval (i2.t1, i2.t2, true, false);
               }
               else if(this.isIn(i2.t2)==false)
               {
                   if(this.t2_p==true)
                       return new Interval (i2.t1, this.t2, true, true);
                   else if(this.t2_p==false)
                       return new Interval (i2.t1, this.t2, true, false);
               }
           }
           else if(i2.t1_p==false)
           {
               if(this.isIn(i2.t2)==true )
               {
                   if(i2.t2_p==true)
                       return new Interval (i2.t1, i2.t2, false, true);
                   else if(i2.t2_p==false)
                       return new Interval (i2.t1, i2.t2, false, false);
               }
               else if(this.isIn(i2.t2)==false)
               {
                   if(this.t2_p==true)
                       return new Interval (i2.t1, this.t2, false, true);
                   if(this.t2_p==false)
                       return new Interval (i2.t1, this.t2, false, false);
               }
           }
       }//moguce je da dodje i do sljedecih slucajeva koji se ne ispituju u testovima
       else if( this.isIn(i2.t1)==false)
       {
           //mozda su krajnje tacke i2 vece od onih objekta nad kojim se vrsi metoda
           if(i2.isIn(this.t1)==true)
           {
               if(this.t1_p==true)
               {
                   if(i2.isIn(this.t2)==true)
                   {
                       if(this.t2_p==true)
                           return new Interval (this.t1, this.t2, true, true);
                       if(this.t2_p==false)
                           return new Interval (this.t1, this.t2, true, false);
                   }
                   else if(i2.isIn(this.t2)==false)
                   {
                       if(i2.t2_p==true)
                           return new Interval(this.t1, i2.t2, true, true);
                       else if(i2.t2_p==false)
                           return new Interval(this.t1, i2.t2, true, false);
                   }
               }
               else if(this.t1_p==false)
               {
                   if(i2.isIn(this.t2)==true)
                   {
                       if(this.t2_p==true)
                           return new Interval (this.t1, this.t2, false, true);
                       if(this.t2_p==false)
                           return new Interval (this.t1, this.t2, false, false);
                   }
                   else if(i2.isIn(this.t2)==false)
                   {
                       if(i2.t2_p==true)
                           return new Interval(this.t1, i2.t2, false, true);
                       else if(i2.t2_p==false)
                           return new Interval(this.t1, i2.t2, false, false);
                   }
               }

           }
           else if(i2.isIn(this.t1)==false)
           {
               System.out.println("Intervali se ne sijeku"); //throw new Exception ("Intervali se ne sijeku");
               return  null;
           }
       }
        return null;
    }

    public static Interval intersect(Interval i1, Interval i2) //throws Exception
    {
        if( i1.isIn(i2.t1)==true )
        {
            if(i2.t1_p==true)
            {
                if(i1.isIn(i2.t2)==true )
                {
                    if(i2.t2_p==true)
                        return new Interval (i2.t1, i2.t2, true, true);
                    else if(i2.t2_p==false)
                        return new Interval (i2.t1, i2.t2, true, false);
                }
                else if(i1.isIn(i2.t2)==false)
                {
                    if(i1.t2_p==true)
                        return new Interval (i2.t1, i1.t2, true, true);
                    if(i1.t2_p==false)
                        return new Interval (i2.t1, i1.t2, true, false);
                }
            }
            else if(i2.t1_p==false)
            {
                if(i1.isIn(i2.t2)==true )
                {
                    if(i2.t1_p==true)
                        return new Interval (i2.t1, i2.t2, false, true);
                    else if(i2.t1_p==false)
                        return new Interval (i2.t1, i2.t2, false, false);
                }
                else if(i1.isIn(i2.t2)==false)
                {
                    if(i1.t2_p==true)
                        return new Interval (i2.t1, i1.t2, false, true);
                    if(i1.t2_p==false)
                        return new Interval (i2.t1, i1.t2, false, false);
                }
            }

        }//moguce je da dodje i do sljedecih slucajeva koji se ne ispituju u testovima
        else if( i1.isIn(i2.t1)==false)
        {
            //mozda su krajnje tacke i2 vece od onih objekta nad kojim se vrsi metoda
            if(i2.isIn(i1.t1)==true)
            {
                if(i1.t1_p==true)
                {
                    if(i2.isIn(i1.t2)==true)
                    {
                        if(i1.t2_p==true)
                            return new Interval (i1.t1, i1.t2, true, true);
                        if(i1.t2_p==false)
                            return new Interval (i1.t1, i1.t2, true, false);
                    }
                    else if(i2.isIn(i1.t2)==false)
                    {
                        if(i2.t2_p==true)
                            return new Interval(i1.t1, i2.t2, true, true);
                        else if(i2.t2_p==false)
                            return new Interval(i1.t1, i2.t2, true, false);
                    }
                }
                else if(i1.t1_p==false)
                {
                    if(i2.isIn(i1.t2)==true)
                    {
                        if(i1.t2_p==true)
                            return new Interval (i1.t1, i1.t2, false, true);
                        if(i1.t2_p==false)
                            return new Interval (i1.t1, i1.t2, false, false);
                    }
                    else if(i2.isIn(i1.t2)==false)
                    {
                        if(i2.t2_p==true)
                            return new Interval(i1.t1, i2.t2, false, true);
                        else if(i2.t2_p==false)
                            return new Interval(i1.t1, i2.t2, false, false);
                    }
                }

            }
            else if(i2.isIn(i1.t1)==false)
            {
                    System.out.println("Intervali se ne sijeku"); //throw new Exception ("Intervali se ne sijeku");
                    return  null;
            }
        }
        return null;
    }

    public boolean equals(Interval i)
    {
        final double EPSILON=0.0001;

        if( Math.abs(t1-i.t1)<EPSILON && Math.abs(t2-i.t2)<EPSILON && t1_p==i.t1_p && t2_p==i.t2_p )
            return true;

        return false;
    }

}
