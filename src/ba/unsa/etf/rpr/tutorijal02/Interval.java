package ba.unsa.etf.rpr.tutorijal02;

public class Interval
{
    private
    public void Interval()
    {
        try
        {

        }
        catch(IllegalArgumentException )
        {
            System.out.println("");
        }

    }
    void ctorExceptionTest()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            Interval i = new Interval(2.5, 2.4, true, true);
        });
    }

    public String toString()
    {

    }
    void toStringTest()
    {
        Interval i = new Interval(1.1, 2.5, true, false);
        assertEquals("[1.1,2.5)", i.toString());
    }
    @org.junit.jupiter.api.Test
    void toString2() {
        Interval i = new Interval();
        assertEquals("()", i.toString());
    }

    public boolean isIn()
    {
        if()
    }
    @org.junit.jupiter.api.Test
    void isIn() {
        Interval i = new Interval(1.1, 2.5, true, false);
        assertTrue(i.isIn(2.3));
    }
    @org.junit.jupiter.api.Test
    void isIn2() {
        Interval i = new Interval(1.1, 2.5, true, false);
        assertTrue(i.isIn(1.1));
    }
    @org.junit.jupiter.api.Test
    void isIn3() {
        Interval i = new Interval(1.1, 2.5, true, false);
        assertFalse(i.isIn(2.5));
    }

    public boolean isNull()
    {
        if()
    }
    @org.junit.jupiter.api.Test
    void isNull() {
        Interval i = new Interval();
        assertTrue(i.isNull());
    }

    public void intersects(Interval inter)
    {

    }
    @org.junit.jupiter.api.Test
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
    }

    public boolean equals()
    {

    }
    @org.junit.jupiter.api.Test
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
    }
}
