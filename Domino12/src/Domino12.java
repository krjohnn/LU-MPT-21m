/*
 * Autors
 * 
 * Vārds: Krišjānis
 * Uzvārds: Šulcs
 * Studentu apliecības numurs: ks10163
 * 
 */

import java.util.Scanner;

public class Domino12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x;
		
		/* Temporary input */
		Scanner scanner = new Scanner(System.in);
		x = scanner.nextInt();
		
//		x = Integer.parseInt(args[0]); // Input param, player count

		int count = 1;
		for(int i=0; i<=12; i++) {
			for(int j=i; j<=12; j++) {
				System.out.println(count+": "+j+"-"+i+"\n");
				count++;
			}
		}
		return;
	}

}
