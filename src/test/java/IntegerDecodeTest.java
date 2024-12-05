import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class IntegerDecodeTest {
    @Test
    public void test_NFE(){
        assertThrows(NumberFormatException.class, ()->Integer.decode(""));
    }

    @Test
    public void test_plus(){
        Integer res = Integer.decode("+10");
        assertEquals(+10,res);
    }
    @Test
    public void test_minus(){
        Integer res = Integer.decode("-10");
        assertEquals(-10,res);
    }
    @Test
    public void test_hex(){
        assertEquals(16,Integer.decode("0x10"));
        assertEquals(16,Integer.decode("0X10"));
        assertEquals(16,Integer.decode("#10"));

        assertEquals(16,Integer.decode("+0x10"));
        assertEquals(16,Integer.decode("+0X10"));
        assertEquals(16,Integer.decode("+#10"));

        assertEquals(-16,Integer.decode("-0x10"));
        assertEquals(-16,Integer.decode("-0X10"));
        assertEquals(-16,Integer.decode("-#10"));
    }

    @Test
    public void test_oct(){
        assertEquals(8,Integer.decode("010"));

        assertEquals(8,Integer.decode("+010"));

        assertEquals(-8,Integer.decode("-010"));
    }

    @Test
    public void test_sign_in_wrong_position(){
        assertThrows(NumberFormatException.class,()->Integer.decode("1-0"),"sign in wrong position");
        assertThrows(NumberFormatException.class,()->Integer.decode("1+0"),"sign in wrong position");
    }
    @Test
    public void test_NaN(){
        assertThrows(NumberFormatException.class,()->Integer.decode("abc"),"is not a number");
    }
    @Test
    public void test_min_value(){
        assertEquals(Integer.MIN_VALUE,Integer.decode("-2147483648"));
    }
}
