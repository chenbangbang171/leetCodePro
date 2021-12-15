import com.genericTest.Drink;
import com.genericTest.GenericTest;

public class Test {


    @org.junit.jupiter.api.Test
    void test(){
        GenericTest genericTest = new GenericTest();
        Drink drink = genericTest.getDrink(1);

        System.out.println(drink.getClass());
    }
}
