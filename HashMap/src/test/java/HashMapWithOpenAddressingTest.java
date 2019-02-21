import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class HashMapWithOpenAddressingTest {

private static  HashMapWithOpenAddressing<Integer, Long> myHashMap;

    @Parameterized.Parameter
    public Integer key;
    @Parameterized.Parameter(1)
    public Long value;


    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {1, 11L}, {2, 24L}, {3, 36L}
        });
    }


    @Before
    public void initial(){
        myHashMap = new HashMapWithOpenAddressing<>();
    }

    @Test
    public void put() {
        assertTrue(myHashMap.put(key, value));
    }

    @Test
    public void get() {
        myHashMap.put(key, value);
        assertEquals(myHashMap.get(key), value);
    }

    @Test
    public void size() {
        initialise();
        assertEquals(myHashMap.size(), 17);
    }

    public void initialise(){
        for(int i = 0; i <= 16; i++)
            myHashMap.put(i, i*2L);
    }
}