import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AutoTestParameterizedLion {
    private String sex;
    private boolean mane;
    public AutoTestParameterizedLion (String sex, boolean mane){
        this.sex = sex;
        this.mane = mane;
    }
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }
    @Test
    public void testSex() throws Exception {
        Lion lion = new Lion(sex, null);
        boolean testMane = lion.doesHaveMane();
        assertEquals(mane, testMane);
    }
}
