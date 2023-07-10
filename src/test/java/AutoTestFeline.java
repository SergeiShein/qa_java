import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AutoTestFeline {
    Feline feline = new Feline();
    @Test
    public void testEatMeat() throws Exception{

        List<String> meat = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), meat);
    }
    @Test
    public void testFamily() {
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);

    }
    @Test
    public void testKittens() {
        int kittens = feline.getKittens();
        assertEquals(1, kittens);

    }
}

