package ba.unsa.etf.rpr.tutorijal02;


public class Main
{
    public static void main(String[] args)
    {
        Interval i = new Interval(1.1, 2.5, true, false);
        //assertEquals("[1.1,2.5)", i.toString());

        System.out.println(i.toString());
    }
}
