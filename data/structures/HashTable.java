package test.hacker.rank.data.structures;

import java.util.List;

/**
 * Collisions' resolution tehchniques: - Linear probing collision avoidance
 * (open addressing strategy) -
 * 
 * 
 * Reasonably performant hash function (Σ aixi) mod ARRAYSIZE. Best if a(i) and
 * array size are prime.
 * 
 * @author niko.strongioglou
 *
 */
public class HashTable {

	public static void main(String[] args) {

		System.out.println("Nikos".hashCode() % 32);
	}
}
