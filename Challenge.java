package test.hacker.rank;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import javassist.bytecode.analysis.ControlFlow.Node;

import org.hibernate.cfg.SetSimpleValueTypeSecondPass;

import antlr.StringUtils;

public class Challenge {

	public static void sum(String[] args) {
		Scanner s = new Scanner(System.in);
		long l = s.nextLong();

		long sum = 0;
		for (int i = 0; i < l; i++) {
			sum += s.nextInt();

		}

		System.out.println(sum);
		s.close();
	}

	public static void diagonalDiff(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();

		int sumD = 0;
		int sumDA = 0;

		Integer[][] matrix = new Integer[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = s.nextInt();
			}
		}

		for (int i = 0; i < size; i++) {
			sumD += matrix[i][i];
			sumDA += matrix[i][size - (i + 1)];
		}

		System.out.println(Math.abs(sumD - sumDA));
		s.close();
	}

	public static void plusMinus(String[] args) {
		Scanner s = new Scanner(System.in);
		int sumP = 0;
		int sumN = 0;
		int sumO = 0;

		int l = s.nextInt();
		int number = 0;
		for (int i = 0; i < l; i++) {
			number = s.nextInt();
			if (number < 0) {
				sumN++;
			} else if (number > 0) {
				sumP++;
			} else {
				sumO++;
			}
		}
		System.out.println((double) sumP / l);
		System.out.println((double) sumN / l);
		System.out.println((double) sumO / l);
		s.close();
	}

	public static void staircase(String[] args) {
		Scanner s = new Scanner(System.in);
		int height = s.nextInt();
		String lineToPrint = "";

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < height; j++) {
				if (j >= height - (i + 1)) {
					lineToPrint = lineToPrint + "#";
				} else {
					lineToPrint = lineToPrint + " ";
				}
			}
			System.out.println(lineToPrint);
			lineToPrint = "";
		}
		s.close();
	}

	public static void timeConversionRegExp(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		Matcher matcher = Pattern.compile("(.+)(:\\d{2}:\\d{2})(\\D{2})")
				.matcher(input);

		if (matcher.matches()) {
			String hourString = matcher.group(1);
			String zone = matcher.group(3);
			int h = Integer.parseInt(hourString);
			if (zone.equals("AM") && h == 12) {
				System.out.println("00" + matcher.group(2));
			} else if (zone.equals("PM") && h == 12) {
				System.out.println("12" + matcher.group(2));
			} else {
				System.out.println(h + 12 + matcher.group(2));
			}
		}
		s.close();
	}

	public static void timeConversionRegular(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		String sp = input.substring(2, 8);
		String zone = input.substring(8, 10);
		int hour = Integer.parseInt(input.substring(0, 2));

		if (zone.equals("AM") && hour == 12) {
			System.out.println("00" + sp);
		} else if (zone.equals("PM") && hour == 12) {
			System.out.println("12" + sp);
		} else {
			System.out.println((zone.equals("AM") ? (hour < 10 ? "0" + hour
					: hour) : hour + 12) + sp);
		}
		s.close();
	}

	public static void angryProfessor(String[] args) {
		Scanner s = new Scanner(System.in);
		int total = 0;
		int threshold = 0;
		int onTime = 0;

		int tc = s.nextInt();

		String[] results = new String[tc];

		for (int i = 0; i < tc; i++) {
			total = s.nextInt();
			if (total < 1 || total > 1000) {
				continue;
			}
			threshold = s.nextInt();
			if (threshold < 1 || threshold > total) {
				continue;
			}
			for (int j = 0; j < total; j++) {
				if (s.nextInt() <= 0) {
					onTime++;
				}
			}
			if (onTime >= threshold) {
				results[i] = "NO";
			} else {
				results[i] = "YES";
			}
			onTime = 0;
		}

		for (String r : results) {
			System.out.println(r);
		}
		s.close();
	}

	/**
	 * The Diophantine equation solution
	 * 
	 * @param args
	 */
	public static void sherlockBeastDiophantine(String[] args) {
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();

		long[] results = new long[tc];

		for (int i = 0; i < tc; i++) {
			int decent = s.nextInt();
			if (decent <= 1 || decent >= 100_000) {
				results[i] = -1;
			}
		}

		for (long l : results) {
			System.out.println(l);
		}
		s.close();
	}

	public static void sherlockAndTheBeast(String[] args) {

		Scanner s = new Scanner(System.in);
		char[] decent = null;
		String[] results = null;
		int threes = 0;
		int fives = 0;

		int tc = s.nextInt();
		results = new String[tc];

		for (int i = 0; i < tc; i++) {

			int n = s.nextInt();
			decent = new char[n];

			if (n == 1) {
				results[i] = "-1";
				continue;
			}

			for (int j = 0; j < n; j++) {
				decent[j] = '5';
			}
			fives = n;

			while (decent[0] != '3') {

				if (threes % 5 == 0 && fives % 3 == 0) {
					break;
				}

				threes++;
				fives--;
				decent[n - threes] = '3';

			}

			if (threes % 5 != 0 || fives % 3 != 0) {
				results[i] = "-1";
			} else {
				results[i] = new String(decent);
			}

			decent = null;
			threes = 0;
			fives = 0;
		}

		for (String result : results) {
			System.out.println(result);
		}
		s.close();
	}

	/**
	 * The Utopian tree
	 */
	public static void utopianTree(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			Integer[] results = null;
			int tc = s.nextInt();
			results = new Integer[tc];

			int height = 1;

			for (int i = 0; i < tc; i++) {

				int cycles = s.nextInt();

				for (int j = 1; j <= cycles; j++) {
					if (j % 2 == 0) {
						height++;
					} else {
						height = 2 * height;
					}
				}
				results[i] = height;
				height = 1;
			}
			for (Integer r : results) {
				System.out.println(r);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void findDigit(String[] args) {

		try (Scanner s = new Scanner(System.in)) {

			int tc = s.nextInt();
			int[] r = null;
			int j = 0;
			int initial;
			int totalDivisors = 0;
			int[] results = new int[tc];
			;

			for (int i = 0; i < tc; i++) {

				int digit = s.nextInt();
				initial = digit;
				int l = String.valueOf(digit).length();
				r = new int[l];

				j = 0;
				while (digit != 0) {
					r[j] = digit % 10;
					digit /= 10;

					if (r[j] != 0 && initial % r[j] == 0) {
						totalDivisors++;
					}

					j++;
				}
				results[i] = totalDivisors;
				totalDivisors = 0;

			}

			for (int i : results) {
				System.out.println(i);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void sherlockAndTheSquares(String[] args) {

		try (Scanner s = new Scanner(System.in)) {

			int tc = s.nextInt();
			int[] results = new int[tc];

			for (int i = 0; i < tc; i++) {

				int start = s.nextInt();
				int end = s.nextInt();

				results[i] = (int) (Math.floor(Math.sqrt(end))
						- Math.ceil(Math.sqrt(start)) + 1);

			}

			for (int i : results) {
				System.out.println(i);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void serviceLane(String[] args) {

		try (Scanner s = new Scanner(System.in)) {

			int length = s.nextInt();
			int tc = s.nextInt();
			int[] lane = new int[length];
			int[] results = new int[tc];
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < length; i++) {
				lane[i] = s.nextInt();
			}

			for (int i = 0; i < tc; i++) {
				int start = s.nextInt();
				int end = s.nextInt();

				for (int j = start; j <= end; j++) {
					if (lane[j] < min) {
						min = lane[j];
					}
				}
				results[i] = min;
				min = Integer.MAX_VALUE;
			}

			for (int i : results) {
				System.out.println(i);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void cutTheSticksLambdas(String[] args) {

		try (Scanner s = new Scanner(System.in)) {

			int length = s.nextInt();
			List<Integer> r = new ArrayList<>();

			for (int i = 0; i < length; i++) {
				r.add(s.nextInt());
			}

			System.out.println(r.size());
			while (r.size() != 1) {
				Collections.sort(r);
				final List<Integer> helper = r;
				r = r.stream().map(c -> c - helper.get(0))
						.collect(Collectors.toList());
				r.removeIf(c -> c == 0);
				System.out.println(r.size());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void cutTheSticksList(String[] args) {

		try (Scanner s = new Scanner(System.in)) {

			int length = s.nextInt();
			List<Integer> r = new ArrayList<>();

			for (int i = 0; i < length; i++) {
				r.add(s.nextInt());
			}

			System.out.println(r.size());
			while (true) {

				Collections.sort(r);
				int helper = r.get(0);
				for (int i = 0; i < r.size(); i++) {
					r.set(i, r.get(i) - helper);
				}
				r.removeIf(c -> c == 0);
				if (r.size() == 0) {
					break;
				}
				System.out.println(r.size());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void chocolateFeast(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int c = in.nextInt();
			int m = in.nextInt();
			int total = n / c;
			int wrappers = total;
			while (wrappers >= m) {
				total += (wrappers / m);
				int leftover = wrappers % m;
				wrappers = (wrappers / m) + leftover;
			}
			System.out.println(total);
		}

		in.close();

	}

	public static void ceasarCipher(String[] args) {

		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		in.nextLine();
		char[] word = in.nextLine().toCharArray();
		int offset = in.nextInt();
		char[] cipher = new char[length];

		for (int i = 0; i < length; i++) {
			if (Character.isAlphabetic((int) word[i])) {
				if (Character.isUpperCase(word[i])
						&& word[i] + offset % 26 > 90) {
					cipher[i] = (char) ('A' + (word[i] + offset % 26 - 91));
				} else if (Character.isLowerCase(word[i])
						&& word[i] + offset % 26 > 122) {
					cipher[i] = (char) ('a' + (word[i] + offset % 26 - 123));
				} else {
					cipher[i] = (char) (word[i] + offset % 26);
				}
				// 6MFE95QigCLQY85mee3WH2laic1jX8s6p2iBMeODrSs6GFMuIeWWa
			} else {
				cipher[i] = word[i];
			}

		}
		System.out.println(new String(cipher));
		in.close();
	}

	// TODO
	public static void gridSearch(String[] args) {

		Scanner s = new Scanner(System.in);

		int tc = s.nextInt();

		for (int i = 0; i < tc; i++) {

			// grid dimensions
			int R = s.nextInt();
			int C = s.nextInt();
			System.out.println("R : " + R + " C: " + C);
			String[] grid = new String[R];
			s.nextLine();

			// read rows of grid
			for (int j = 0; j < R; j++) {
				grid[j] = s.nextLine();
			}

			// pattern dimentions
			int r = s.nextInt();
			int c = s.nextInt();
			System.out.println("r : " + r + " c: " + c);
			String[] pattern = new String[r];
			s.nextLine();

			for (int j = 0; j < r; j++) {
				pattern[j] = s.nextLine();
			}
		}
		s.close();
	}

	public static void cavityMap(String[] args) {

		Scanner s = new Scanner(System.in);

		int size = s.nextInt();
		s.nextLine();
		char[][] map = new char[size][size];

		for (int i = 0; i < size; i++) {
			String line = s.nextLine();
			map[i] = line.toCharArray();
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i != 0 && i != size - 1 && j != 0 && j != size - 1
						&& map[i][j - 1] < map[i][j]
						&& map[i][j + 1] < map[i][j]
						&& map[i + 1][j] < map[i][j]
						&& map[i - 1][j] < map[i][j]) {
					map[i][j] = 'X';

				}
			}
		}

		for (int i = 0; i < size; i++) {
			System.out.println(new String(map[i]));
		}
		s.close();

	}

	public static void manasaAndStonesSmallSets(String[] args) {

		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		for (int i = 0; i < tc; i++) {
			int stones = s.nextInt();
			int a = s.nextInt();
			int b = s.nextInt();

			Map<Integer, List<Integer>> tree = new HashMap<Integer, List<Integer>>();

			for (int j = 0; j < stones; j++) {
				if (j == 0) {
					tree.put(0, Arrays.asList(0));
				} else {
					List<Integer> l = new ArrayList<>();
					for (Integer number : tree.get(j - 1)) {
						l.add(number + a);
						l.add(number + b);
					}

					tree.put(j, l);
				}

			}

			String result = new String("");
			for (Integer number : tree.get(stones - 1)) {
				if (result.contains(number.toString())) {
					continue;
				}
				result = result + number + " ";
			}
			System.out.println(result);

			// System.out.println(tree.get(stones -
			// 1).stream().distinct().map(Object::toString).collect(Collectors.joining(" ")));

		}
		s.close();
	}

	/**
	 * manasa and stones large (optimal)
	 * 
	 * set implementation
	 * 
	 * @param args
	 */
	public static void manasaAndTheStonesOptimization(String[] args) {

		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		List<Long> combinationsList = new ArrayList<>();

		for (int i = 0; i < tc; i++) {
			int stones = s.nextInt();
			int a = s.nextInt();
			int b = s.nextInt();
			long as = 0;
			long bs = stones - 1;
			long lastStone = 0;

			for (int j = 0; j < stones; j++) {
				lastStone = as * a + bs * b;
				if (!combinationsList.contains(lastStone)) {
					combinationsList.add(lastStone);
				}
				as++;
				bs--;

			}
			Collections.sort(combinationsList);
			String result = new String("");
			for (Long number : combinationsList) {

				result = result + number + " ";
			}
			System.out.println(result);
			combinationsList.clear();
		}
		s.close();
	}

	public static void libraryFineChrono(String[] args) {

		Scanner s = new Scanner(System.in);

		int actualDay = s.nextInt();
		int actualMonth = s.nextInt();
		int actualYear = s.nextInt();

		int expectedDay = s.nextInt();
		int expectedMonth = s.nextInt();
		int expectedYear = s.nextInt();

		long totalFine = 0;
		LocalDate actualDate = LocalDate.of(actualYear, actualMonth, actualDay);
		LocalDate expectedDate = LocalDate.of(expectedYear, expectedMonth,
				expectedDay);

		if (actualYear == expectedYear) {
			if (!((actualMonth == expectedMonth && actualDay == expectedDay) || actualDate
					.isBefore(expectedDate))) {
				long days = ChronoUnit.DAYS.between(actualDate, expectedDate);
				long months = ChronoUnit.MONTHS.between(actualDate,
						expectedDate);
				totalFine = Math.abs(days) * 15 + Math.abs(months) * 500;

			}
		} else {
			totalFine = 10000;
		}
		System.out.println(totalFine);
		s.close();
	}

	public static void libraryFine(String[] args) {

		Scanner s = new Scanner(System.in);

		int actualDay = s.nextInt();
		int actualMonth = s.nextInt();
		int actualYear = s.nextInt();

		int expectedDay = s.nextInt();
		int expectedMonth = s.nextInt();
		int expectedYear = s.nextInt();

		long totalFine = 0;

		if (actualYear == expectedYear) {
			if (actualMonth > expectedMonth) {
				totalFine = (actualMonth - expectedMonth) * 500;
			} else if (actualMonth == expectedMonth && actualDay > expectedDay) {
				totalFine = (actualDay - expectedDay) * 15;
			}

		} else if (actualYear > expectedYear) {
			totalFine = 10000;
		}
		System.out.println(totalFine);
		s.close();

	}

	public static void acmIcpcTeam(String[] args) {

		Scanner s = new Scanner(System.in);

		int people = s.nextInt();
		int topics = s.nextInt();
		s.nextLine();

		List<BitSet> bitList = new ArrayList<>();
		List<Integer> cardinalityList = new ArrayList<>();

		for (int i = 0; i < people; i++) {

			String knowledge = s.nextLine();
			char[] r = knowledge.toCharArray();
			BitSet bitSet = new BitSet(topics);

			for (int j = 0; j < r.length; j++) {
				if (r[j] == '1') {
					bitSet.set(j);
				}
			}
			bitList.add(bitSet);
		}

		int max = -1;
		for (int i = 0; i < people; i++) {
			BitSet tmpBase = (BitSet) bitList.get(i).clone();
			for (int j = i + 1; j < people; j++) {
				BitSet tmpCompare = (BitSet) bitList.get(j).clone();
				tmpCompare.or(tmpBase);
				cardinalityList.add(tmpCompare.cardinality());
				if (tmpCompare.cardinality() > max) {
					max = tmpCompare.cardinality();
				}
			}
		}

		int teams = 0;
		for (Integer c : cardinalityList) {
			if (c == max) {
				teams++;
			}
		}

		System.out.println(max);
		System.out.println(teams);

		s.close();
	}

	/**
	 * More emphasis should be put upon ore efficient algorithms
	 * 
	 * @param args
	 */
	public static void extraLongFactorials(String[] args) {

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		System.out.println(recursiveFactorial(BigInteger.valueOf(n)));

		s.close();
	}

	private static BigInteger recursiveFactorial(BigInteger n) {
		return n.compareTo(BigInteger.ONE) == -1
				|| n.compareTo(BigInteger.ONE) == 0 ? BigInteger.ONE : n
				.multiply(recursiveFactorial(n.subtract(BigInteger.ONE)));
	}

	public static void pangrams(String[] args) {

		// constants
		final int ASCII_UPPERCASE_START = 65;
		final int ASCII_UPPERCASE_END = 90;
		final int ASCII_LOWERCASE_START = 97;
		final int ASCII_LOWERCASE_END = 122;

		Scanner s = new Scanner(System.in);
		char[] ca = s.nextLine().replace("\\s", "").toCharArray();
		List<Character> sentenceList = new ArrayList<>();
		for (char character : ca) {
			sentenceList.add(character);
		}

		List<Character> alphabet = new ArrayList<>();
		// initialize alphabet
		for (int i = ASCII_UPPERCASE_START, j = ASCII_LOWERCASE_START, k = 0; i <= ASCII_UPPERCASE_END
				&& j <= ASCII_LOWERCASE_END && k < 52; i++, j++, k = k + 2) {
			alphabet.add((char) i);
			alphabet.add((char) j);
		}

		int total = 0;
		Collections.sort(alphabet);
		for (Character c : sentenceList) {
			if (alphabet.contains(c)) {
				alphabet.remove(c);
				if (Character.isUpperCase(c)) {
					alphabet.remove(Character.valueOf(Character.toLowerCase(c)));
				} else {
					alphabet.remove(Character.valueOf(Character.toUpperCase(c)));
				}
				total++;
			}
		}

		System.out.println(total == 26 ? "pangram" : "not pangram");

		s.close();

	}

	/**
	 * This is a brute force approach. Calculate all possible sums of subarrays
	 * and find the answer. Time complexity O(n^3)
	 * 
	 * @param args
	 */
	public static void maxSubarraysBruteForce(String[] args) {

		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();

		for (int i = 0; i < tc; i++) {

			int N = s.nextInt();
			int[] A = new int[N];

			for (int j = 0; j < A.length; j++) {
				A[j] = s.nextInt();
			}

			if (A.length == 1) {
				System.out.println(A[0] + " " + A[0]);
				continue;
			}
			int max = Integer.MIN_VALUE;
			for (int subArraySize = 1; subArraySize <= N; subArraySize++) {
				System.out.println(subArraySize);
				for (int startIndex = 0; startIndex + subArraySize <= N; startIndex++) {
					int sum = 0;
					for (int k = startIndex; k < startIndex + subArraySize; k++) {
						sum += A[k];
					}
					if (max < sum) {
						max = sum;
					}
				}
			}

			// non-contiguous
			Arrays.sort(A);
			int sumNonContiguous = 0;
			for (int j = 0; j < A.length; j++) {
				if (A[j] > 0) {
					sumNonContiguous += A[j];
				}
			}
			System.out.print(max);
			System.out.println(" "
					+ String.valueOf(sumNonContiguous == 0 ? A[A.length - 1]
							: sumNonContiguous));
		}
		s.close();

	}

	/**
	 * O(n^2)
	 * 
	 * @param args
	 */
	public static void maxSubarraysFirstOptimization(String[] args) {

		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();

		for (int i = 0; i < tc; i++) {

			int N = s.nextInt();
			int[] A = new int[N];

			for (int j = 0; j < A.length; j++) {
				A[j] = s.nextInt();
			}

			if (A.length == 1) {
				System.out.println(A[0] + " " + A[0]);
				continue;
			}
			int max = Integer.MIN_VALUE;

			for (int startIndex = 0; startIndex < N; startIndex++) {
				int sum = 0;
				for (int subArraySize = 1; startIndex + subArraySize <= N; subArraySize++) {
					sum += A[startIndex + subArraySize - 1];
					if (max < sum) {
						max = sum;
					}
				}
			}

			// non-contiguous
			Arrays.sort(A);
			int sumNonContiguous = 0;
			for (int j = 0; j < A.length; j++) {
				if (A[j] > 0) {
					sumNonContiguous += A[j];
				}
			}
			System.out.print(max);
			System.out.println(" "
					+ String.valueOf(sumNonContiguous == 0 ? A[A.length - 1]
							: sumNonContiguous));
		}
		s.close();
	}

	/**
	 * Maximum subarrays : Kadane's algorithm
	 * 
	 * @param args
	 */
	public static void maxSubarraysKadane(String[] args) {

		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();

		for (int i = 0; i < tc; i++) {

			int N = s.nextInt();
			int[] A = new int[N];

			for (int j = 0; j < A.length; j++) {
				A[j] = s.nextInt();
			}

			if (A.length == 1) {
				System.out.println(A[0] + " " + A[0]);
				continue;
			}

			int ans = 0, sum = 0, non = 0;

			for (int j = 0; j < N; j++) {
				if (sum + A[j] > 0) {
					sum += A[j];
				} else {
					sum = 0;
					non++;
				}
				ans = Math.max(ans, sum);
			}

			// non-contiguous
			Arrays.sort(A);
			int sumNonContiguous = 0;
			for (int j = 0; j < A.length; j++) {
				if (A[j] > 0) {
					sumNonContiguous += A[j];
				}
			}
			System.out.print(non == N ? A[A.length - 1] : ans);
			System.out.println(" "
					+ String.valueOf(sumNonContiguous == 0 ? A[A.length - 1]
							: sumNonContiguous));
		}
		s.close();
	}

	/**
	 * Snakes and Ladders: The Quickest Way Up
	 * 
	 * @param args
	 */
	public static void snakesAndLaddersShortestPath(String[] args) {

		final int TERAIN_SIZE = 100;
		final int DICE_ROLL = 6;
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();

		for (int i = 0; i < tc; i++) {

			// Map of adjacency lists
			Map<Integer, List<Integer>> adj = new HashMap<>();
			List<Integer> coordinates = new ArrayList<>();
			// fill adjacency list with neighbor values as if there were no
			// snakes or ladders
			for (int m = 1; m <= TERAIN_SIZE; m++) {
				List<Integer> newAdj = new ArrayList<>();
				for (int j = 1; j <= DICE_ROLL; j++) {
					if (m + j > TERAIN_SIZE) {
						continue;
					}
					newAdj.add(m + j);
				}
				adj.put(m, newAdj);
			}

			int ladders = s.nextInt();
			for (int j = 0; j < ladders; j++) {
				// ladder coordinates
				int x = s.nextInt();
				int y = s.nextInt();

				for (int k = (x - DICE_ROLL <= 0 ? 1 : x - DICE_ROLL); k < x; k++) {
					adj.get(k).remove(Integer.valueOf(x));
					adj.get(k).add(y);
				}
				coordinates.add(x);
			}
			int snakes = s.nextInt();
			for (int j = 0; j < snakes; j++) {
				// snake coordinates
				int x = s.nextInt();
				int y = s.nextInt();

				for (int k = x - DICE_ROLL; k < x; k++) {
					adj.get(k).remove(Integer.valueOf(x));
					adj.get(k).add(y);
				}
				coordinates.add(x);
			}
			// remove snakes and ladders from adjcency list
			for (Integer coordinate : coordinates) {
				adj.remove(coordinate);
			}

			int[] distanceTo = new int[101];
			boolean[] traversed = new boolean[101];
			Map<Integer, Integer> predecessors = new HashMap<>();
			Arrays.fill(traversed, false);
			// BFS algorithm
			Queue<Integer> queue = new LinkedList<>();
			distanceTo[0] = 0;
			traversed[1] = true;
			queue.add(1);
			while (!queue.isEmpty()) {
				Integer v = queue.poll();
				for (Integer u : adj.get(v)) {
					if (!traversed[u]) {
						traversed[u] = true;
						distanceTo[u] = distanceTo[v] + 1;
						predecessors.put(u, v);
						queue.add(u);
					}
				}
				traversed[v] = true;
			}

			System.out.println(distanceTo[100] != 0 ? distanceTo[100] : String
					.valueOf(-1));
		}

		s.close();
	}

	/**
	 * BFS : Shortest Reach . This is a generalization of single source shortest
	 * path algorithm which produces shortest path from any given node to any
	 * given node. Should be able to do that with the Floyd-Warshall algorithm
	 * 
	 * @param args
	 */
	public static void bfs(String[] args) {

		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();

		for (int i = 0; i < tc; i++) {
			int N = s.nextInt();
			int M = s.nextInt();

			Map<Integer, List<Integer>> adj = new HashMap<>();
			for (int j = 1; j <= N; j++) {
				List<Integer> adjList = new ArrayList<>();
				adj.put(j, adjList);
			}

			for (int j = 0; j < M; j++) {
				int nA = s.nextInt();
				int nB = s.nextInt();

				adj.get(nA).add(nB);
				adj.get(nB).add(nA);
			}

			int startingPoint = s.nextInt();

			// bfs algorithm
			boolean[] traversed = new boolean[N + 1];
			Arrays.fill(traversed, false);
			int[] distanceTo = new int[N + 1];
			Arrays.fill(distanceTo, -1);

			Queue<Integer> queue = new LinkedList<>();
			distanceTo[startingPoint] = 0;
			traversed[startingPoint] = true;
			queue.add(startingPoint);

			while (!queue.isEmpty()) {

				Integer v = queue.poll();

				for (Integer u : adj.get(v)) {

					if (!traversed[u]) {
						distanceTo[u] = distanceTo[v] + 6;
						traversed[u] = true;
						queue.add(u);
					}

				}
				traversed[v] = true;
			}
			for (int j = 1; j < distanceTo.length; j++) {
				if (j == startingPoint) {
					continue;
				}
				System.out.print(distanceTo[j] + " ");
			}
			System.out.println();
		}
		s.close();
	}

	private static void printMap(Map<Integer, List<Integer>> adj) {
		for (Map.Entry<Integer, List<Integer>> al : adj.entrySet()) {
			System.out.print(al.getKey() + " --> ");
			al.getValue().forEach(c -> System.out.print(c + " "));
			System.out.println();
		}
	}

	/**
	 * Alternating characters
	 * 
	 * @param args
	 */
	public static void alternatingCharacters(String[] args) {

		Scanner s = new Scanner(System.in);

		int tc = s.nextInt();
		s.nextLine();
		for (int i = 0; i < tc; i++) {
			int deletions = 0;
			char[] r = s.nextLine().toCharArray();

			char compareTo = r[0];
			for (int j = 0; j < r.length - 1; j++) {
				if (compareTo == r[j + 1]) {
					deletions++;
				}
				compareTo = r[j + 1];
			}
			System.out.println(deletions);
		}
		s.close();
	}

	public static void palindromes(String[] args) {

		Scanner s = new Scanner(System.in);

		int tc = s.nextInt();
		s.nextLine();
		for (int i = 0; i < tc; i++) {

			char[] r = s.nextLine().toCharArray();
			int operations = 0;
			for (int j = 0, k = r.length - 1; j < r.length / 2; j++, k--) {
				operations += Math.abs(r[k] - r[j]);
			}
			System.out.println(operations);
		}
		s.close();
	}

	/**
	 * Gemstones : Stream Implementation
	 * 
	 * @param args
	 */
	public static void gemstonesStream(String[] args) {
		Scanner s = new Scanner(System.in);

		int tc = s.nextInt();
		s.nextLine();

		List<Integer> collection = null;
		for (int i = 0; i < tc; i++) {

			List<Integer> d = s.nextLine().chars().distinct().boxed()
					.collect(Collectors.toList());

			for (int j = 0; j < tc - 1; j++) {
				collection = s.nextLine().chars().distinct().boxed()
						.filter((p) -> {
							if (d.contains(p)) {
								return true;
							} else {
								d.remove(p);
								return false;
							}
						}).collect(Collectors.toList());
			}
		}
		System.out.println(collection.size());
		s.close();

	}

	public static void gemstones(String[] args) {

		Scanner s = new Scanner(System.in);

		int tc = s.nextInt();
		s.nextLine();

		Set<Character> common = new HashSet<>();

		char[] first = s.nextLine().toCharArray();
		for (char c : first) {
			common.add(c);
		}

		for (int i = 0; i < tc - 1; i++) {
			char[] element = s.nextLine().toCharArray();
			Set<Character> elementSet = new HashSet<>();
			for (char c : element) {
				elementSet.add(c);
			}
			common.retainAll(elementSet);

		}

		System.out.println(common.size());
	}

	/**
	 * Two strings : Brute force. Will time out.
	 */
	public static void twoStrings(String[] args) {

		Scanner s = new Scanner(System.in);

		int tc = s.nextInt();
		String[] results = new String[tc];
		Arrays.fill(results, "NO");
		s.nextLine();

		for (int i = 0; i < tc; i++) {
			String first = s.nextLine();
			String second = s.nextLine();

			for (int substringSize = 1; substringSize < first.length(); substringSize++) {

				for (int startIndex = 0; startIndex + substringSize < first
						.length(); startIndex++) {
					if (second.contains(first.substring(startIndex, startIndex
							+ substringSize))) {
						results[i] = "YES";
						break;
					}
				}
				if (results[i].equals("YES")) {
					break;
				}

			}
		}

		for (String r : results) {
			System.out.println(r);
		}

		s.close();

	}

	public static void twoStringOptimal(String[] args) {

		Scanner s = new Scanner(System.in);

		int tc = s.nextInt();
		String[] results = new String[tc];
		Arrays.fill(results, "NO");
		s.nextLine();

		for (int i = 0; i < tc; i++) {
			String first = s.nextLine();
			String second = s.nextLine();

			for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
				if (first.indexOf(c) > -1 && second.indexOf(c) > -1) {
					results[i] = "YES";
					break;
				}
			}
		}
		for (String r : results) {
			System.out.println(r);
		}
		s.close();
	}

	/**
	 * Funny String
	 * 
	 * @param args
	 */
	public static void funnyString(String[] args) {

		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		s.nextLine();

		for (int i = 0; i < tc; i++) {
			String funny = s.nextLine();
			char[] reversedFunnyR = new StringBuilder(funny).reverse()
					.toString().toCharArray();
			char[] funnyR = funny.toCharArray();

			int max = 0;
			for (int j = 1; j < funnyR.length; j++) {
				if (Math.abs(funnyR[j] - funnyR[j - 1]) == Math
						.abs(reversedFunnyR[j] - reversedFunnyR[j - 1])) {
					max++;
				} else {
					break;
				}
			}

			if (max == reversedFunnyR.length - 1) {
				System.out.println("Funny");
			} else {
				System.out.println("Not Funny");
			}

		}
		s.close();

	}

	/**
	 * Lonely Integer
	 * 
	 * @param args
	 */
	public static void lonelyInteger(String[] args) {

		Scanner s = new Scanner(System.in);

		int N = s.nextInt();
		int[] numberCounts = new int[101];
		Arrays.fill(numberCounts, 0);

		for (int i = 0; i < N; i++) {
			int number = s.nextInt();
			if (numberCounts[number] == -1) {
				numberCounts[number] = 1;
			} else {
				numberCounts[number] = -1;
			}
		}

		for (int i = 0; i <= 100; i++) {
			if (numberCounts[i] == -1) {
				System.out.println(i);
				break;
			}

		}
		s.close();
	}

	public static void flippingBits(String[] args) {

		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		for (int i = 0; i < tc; i++) {
			System.out.println(Long.parseLong(Long
					.toBinaryString(~s.nextLong()).substring(32, 64), 2));
		}
		s.close();

	}

	/**
	 * Taum and B'day
	 * 
	 * @param args
	 */
	public static void taumBday(String[] args) {

		Scanner s = new Scanner(System.in);

		int tc = s.nextInt();
		for (int i = 0; i < tc; i++) {
			long b = s.nextLong();
			long w = s.nextLong();
			long x = s.nextLong();
			long y = s.nextLong();
			long z = s.nextLong();

			if (x + z < y) {
				System.out.println(b * x + w * (x + z));
			} else if (y + z < x) {
				System.out.println(w * y + b * (y + z));
			} else {
				System.out.println(b * x + w * y);
			}
		}

		s.close();

	}

	/**
	 * Even tree : Try counting the children. If the subtree has even number of
	 * nodes then the edge leading to this subtree can be removed. Otherwise,
	 * you have to keep on searching until you find a suitable edge or the
	 * entire tree exhausted. As it always can be decomposed into forests of
	 * even number of nodes, you will always end up with an answer greater than
	 * 1.
	 * 
	 * @param args
	 */
	public static void evenTree(String[] args) {

		Scanner s = new Scanner(System.in);

		int N = s.nextInt();
		int M = s.nextInt();

		Map<Integer, List<Integer>> adj = new HashMap<>();
		for (int j = 1; j <= N; j++) {
			List<Integer> adjList = new ArrayList<>();
			adj.put(j, adjList);
		}

		for (int j = 0; j < M; j++) {
			int nA = s.nextInt();
			int nB = s.nextInt();

			if (nA > nB) {
				adj.get(nB).add(nA);
			} else {
				adj.get(nA).add(nB);
			}

		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);

		boolean[] traversed = new boolean[N + 1];
		Arrays.fill(traversed, false);
		traversed[1] = true;

		int[] distanceTo = new int[N + 1];
		Arrays.fill(distanceTo, -1);
		distanceTo[1] = 0;

		int[] pi = new int[N + 1];
		Arrays.fill(pi, -1);

		while (!queue.isEmpty()) {
			Integer u = queue.poll();
			for (int v : adj.get(u)) {
				if (!traversed[v]) {
					traversed[v] = true;
					distanceTo[v] = distanceTo[u] + 1;
					pi[v] = u;
					queue.add(v);
				}
				traversed[u] = true;
			}
		}

		// find subgraphOrders
		int[] subgraphOrder = new int[N + 1];
		int removedEdges = 0;
		for (int i : adj.keySet()) {
			subgraphOrder[i] = subgraphOrder(i, distanceTo, pi, adj);
			if (subgraphOrder[i] % 2 == 0) {
				removedEdges++;
			}

		}

		System.out.println(removedEdges);

		s.close();

	}

	private static int subgraphOrder(int startingPoint, int[] dt, int[] pi,
			Map<Integer, List<Integer>> adj) {
		int order = 1;
		if (dt[startingPoint] == -1 || dt[startingPoint] == 0) {
			// ignore and return 1
		} else {
			for (int i : adj.get(startingPoint)) {
				order += subgraphOrder(i, dt, pi, adj);
			}
		}
		return order;
	}

	/**
	 * Clique : A subset of vertices of an undirected graph such that its
	 * included subgraph is complete; that is, every two distinct vertices in
	 * the clique are adjacent. {@link https
	 * ://en.wikipedia.org/wiki/Clique_(graph_theory)}
	 * 
	 * 
	 * Turan's Theorem : An n-vertex graph that does not contain a (r+1) clique
	 * may be formed by partitioning the set of vertices into r parts of equal
	 * or nearly equal size, and connecting two vertices with an edge whenever
	 * they belong to two different parts.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int tc = s.nextInt();

		for (int i = 0; i < tc; i++) {
			int N = s.nextInt();
			int M = s.nextInt();

			System.out.println();
		}
		s.close();

	}

	private static int maxClique(int n, int m, int r) {
		double lala = (Math.pow(n, 2) - (n % r) * Math.pow(Math.ceil(n / r), 2) - (r - (n % r))
				* Math.pow(Math.ceil(n / r), 2));

		return 0;
	}

}
