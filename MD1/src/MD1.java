/*
 * Autors
 *
 * Vārds: Krišjānis
 * Uzvārds: Šulcs
 * Studentu apliecības numurs: ks10163
 *
 */

/*
 * Spaces
 * ------------
 * Top = N+Z-1 spaces (maxSpaces)
 * Bottom = N spaces (maxPluses)
 *
 * Pluses
 * ------------
 * Top = Z pluses
 * Bottom = 1
 *
 * Newlines
 * ------------
 * Equal to pluses
 *
 */

import java.util.Scanner;

public class MD1 {

	public static void main(String[] args) {
		int Z,N;
		Z = Integer.parseInt(args[0]); // Input param, count of "+"
		N = Integer.parseInt(args[1]); // Input param, count of " " from left

		/* Temporary input */

//        Scanner scanner = new Scanner(System.in);
//        Z = Integer.parseInt(scanner.nextLine());
//        N = Integer.parseInt(scanner.nextLine());
//        Z = scanner.nextInt();
//        N = scanner.nextInt();

		if((Z <= 0 || Z >= 20) || (N <= 0 || N >= 30)) {
			System.out.println("DATI NAV KOREKTI!");
			return;
		}

		int maxSpaces = N; // Topmost "+" will not have more than N spaces
		int maxPluses = Z; // Count of topmost "+"
		int maxNewlines = Z; // We will print as many newlines as there are "+"

		System.out.println("1234567890123456789012345678901234567890123456789012345678901234567890");
		for(int i = 0; maxNewlines > i; i++) {
			for(int j = 0; maxSpaces > j; j++) {
				System.out.print(" ");
			}
			for(int k = 0; maxPluses > k; k++) {
				System.out.print("+ ");
			}
			System.out.print("\n");
			maxSpaces++; // Increase the spaces we need to add as we go "down"
			maxPluses--; // Go "down" the count of pluses
		}

		return;
	}

}

/* EXAMPLE OUTPUT

1234567890123456789012345678901234567890123456789012345678901234567890
                             + + + + + + + + + + + + + + + + + + +
                              + + + + + + + + + + + + + + + + + +
                               + + + + + + + + + + + + + + + + +
                                + + + + + + + + + + + + + + + +
                                 + + + + + + + + + + + + + + +
                                  + + + + + + + + + + + + + +
                                   + + + + + + + + + + + + +
                                    + + + + + + + + + + + +
                                     + + + + + + + + + + +
                                      + + + + + + + + + +
                                       + + + + + + + + +
                                        + + + + + + + +
                                         + + + + + + +
                                          + + + + + +
                                           + + + + +
                                            + + + +
                                             + + +
                                              + +
                                               +

*/