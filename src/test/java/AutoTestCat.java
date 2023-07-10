import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class AutoTestCat {
    @Mock
    Feline feline;
    Cat cat;
    @Before
    public void before(){
        cat = new Cat(feline);
    }
    @Test
    public void testSound() {

        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }
    @Test
    public void testFood() throws Exception {

        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String>food = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

}
