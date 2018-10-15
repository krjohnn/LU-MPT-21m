/*
 * Autors
 * 
 * Vārds: Krišjānis
 * Uzvārds: Šulcs
 * Studentu apliecības numurs: ks10163
 * 
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
		
		Piece Set[] = new Piece[91];
		List<Piece> Set2 = new ArrayList<Piece>();
		
		int count = 0;
		for(int i=0; i<=12; i++) {
			for(int j=i; j<=12; j++) {
				System.out.println(count+": "+j+"-"+i);
				Set[count] = new Piece(j,i);
				Set2.add(new Piece(j,i));
//				System.out.println(Set[count].toString());
				count++;
			}
		}
		
		System.out.println("------Array------");
		for(int i=0; i<Set.length; i++) {
			System.out.println(Set[i].toString());
		}
		
		System.out.println("------Array List------");
		Collections.shuffle(Set2);
		for(int i=0; i<Set2.size(); i++) {
			System.out.println(Set2.get(i).toString());
		}
		
		
		/*
		Random rand = new Random();
		int n = rand.nextInt(Set2.size())+0;
		for(int i=0; i<Set2.size(); i++) {
			n = rand.nextInt(Set2.size())+0;
//			System.out.println(n);
			System.out.println(Set2.get(n).toString());
			Set2.remove(n);
		}
		
		*/
		
		return;
	}

}
