import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class AutoTestLion {
    @Mock
    Feline feline;
    @Test
    public void testOther ()throws Exception{
        Exception exception = assertThrows(Exception.class, () -> {
            Lion lionOther = new Lion("Другое", feline);
        });
        String expectedMessage = "Используйте допустимые значения пола животного - самей или самка";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void testKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(3);
        int kittens = lion.getKittens();
        assertEquals(3, kittens);
    }
    @Test
    public void testFoods() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> foods = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), foods);
    }
}
