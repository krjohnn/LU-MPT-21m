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
	
	public static class Piece {
		 private int first_q; //pirmā kvadrāta vērtība
		 private int second_q; //otrā kvadrāta vērtība
		 
		 //klases konstruktors
		 public Piece(int first, int second) {
		  first_q = first;
		  second_q = second;
		 }
		 
		//pārrakstam toString metodi
		 public String toString() {
		      return first_q + "-" + second_q;
		 }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x;
		
		/* Temporary input */	
		Scanner scanner = new Scanner(System.in);
		x = scanner.nextInt();
		
//		x = Integer.parseInt(args[0]); // Input param, player count

		// Domino Piece generator
		int count = 1;
		for(int i=0; i<=12; i++) {
			for(int j=i; j<=12; j++) {
				System.out.println(count+": "+j+"-"+i);
				Piece a = new Piece(j,i);
				System.out.println(a.toString());
				count++;
			}
		}
		return;
	}

}
