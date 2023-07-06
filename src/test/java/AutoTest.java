import com.example.Animal;
import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;



import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AutoTest {
    @Test
    public void testAnimal() throws Exception{
        Animal animal = new Animal();
        List<String> foods= animal.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), foods);
        foods= animal.getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), foods);
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood("Землеводные");
        });
        String expectedMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void testFeline() throws Exception{
        Feline feline = new Feline();
        List<String> meat = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), meat);
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
        int kittens = feline.getKittens();
        assertEquals(1, kittens);
    }
    @Mock
    Feline feline;

    @Test
    public void testCat() throws Exception {
        Cat cat = new Cat(feline);
        String sound = cat.getSound();
        assertEquals("Мяу", sound);

        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String>food = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
    @Test
    public void testLion()throws Exception{
        Lion lion = new Lion("Самец");
        boolean mane = lion.doesHaveMane();
        assertTrue(mane);
        lion = new Lion("Самка");
        mane = lion.doesHaveMane();
        assertFalse(mane);
        Exception exception = assertThrows(Exception.class, () -> {
            Lion lionOther = new Lion("Другое");
        });
        String expectedMessage = "Используйте допустимые значения пола животного - самей или самка";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
        lion = new Lion(feline);
        Mockito.when(feline.getKittens()).thenReturn(3);
        int kittens = lion.getKittens();
        assertEquals(3, kittens);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> foods = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), foods);
    }


}

