import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.math.BigDecimal;

public class MD4_Lambdas {

    public static final List<BigDecimal> numbers = Arrays.asList(
            new BigDecimal("15"), new BigDecimal("10"), new BigDecimal("17"),
            new BigDecimal("30"), new BigDecimal("18"), new BigDecimal("23"),
            new BigDecimal("5"), new BigDecimal("12") );

    public static final List<String> persons =
            Arrays.asList("Edgars", "Uldis", "Gita", "Rita", "Elza", "Andris");


    public static void main(String[] args) {

        System.out.println(" ========= Imperative 1 =========");
        //imperative approach
        for(String name : persons) {
            System.out.print(name + " ");
        }
        System.out.println();

        System.out.println(" ========= Functional 1 =========");
        // add your code here, to do the same in a functional style
        //
        //
        System.out.println();

        System.out.println("\n ========= Imperative 2 =========");
        List<String> uppercaseNames = new ArrayList<String>();
        for(String name : persons) {
            uppercaseNames.add(name.toUpperCase());
        }
        for(String name : uppercaseNames) {
            System.out.print(name + " ");
        }
        System.out.println();

        System.out.println(" ========= Functional 2 =========");
        // place your code here, to do the same in a functional style
        //
        //
        System.out.println();

        System.out.println("\n ========= Imperative 3 =========");
        for(String name : persons) {
            System.out.print(name.length() + " ");
        }
        System.out.println();

        System.out.println(" ========= Functional 3 =========");
        // place your code here, to do the same in a functional style
        //
        //
        System.out.println();

        System.out.println("\n ========= Imperative 4 =========");
        BigDecimal totalOfReducedNumbers = BigDecimal.ZERO;
        for(BigDecimal number : numbers) {
            if(number.compareTo(BigDecimal.valueOf(20)) > 0)
                totalOfReducedNumbers =
                        totalOfReducedNumbers.add(number.multiply(BigDecimal.valueOf(0.9)));
        }
        System.out.println("Total of reduced numbers: " + totalOfReducedNumbers);

        System.out.println(" ========= Functional 4 =========");
        // place your code here, to do the same in a functional style
        //
        //

    }

}