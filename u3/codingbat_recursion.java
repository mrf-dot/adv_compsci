public class codingbat_recursion {

public int factorial(int n) {
	if (n <= 1) {
		return 1;
	}
	return n * factorial(n - 1);
}

public int bunnyEars(int bunnies) {
	if (bunnies == 0)
		return 0;
	return 2 + bunnyEars(bunnies - 1);
}

public int fibonacci(int n) {
	if (n <= 1) {
		return n;
	}
	return fibonacci(n - 1) + fibonacci(n - 2);
}

public int bunnyEars2(int bunnies) {
	return bunnies == 0
			? 0
			: bunnies % 2 != 0
					? 2 + bunnyEars2(bunnies - 1)
					: 3 + bunnyEars2(bunnies - 1);
}

public int triangle(int rows) {
	return rows > 0
			? rows + triangle(rows - 1)
			: 0;
}

public int sumDigits(int n) {
	return n > 0 ? n % 10 + sumDigits(n / 10) : 0;
}

public int count7(int n) {
	return n > 0 ? (n % 10 == 7 ? 1 : 0) + count7(n / 10) : 0;
}

public int powerN(int base, int n) {
	if (n < 1)
		return 1;
	return base * powerN(base, n - 1);
}

public int countX(String str) {
	if (str.length() == 0)
		return 0;
	return (str.charAt(0) == 'x' ? 1 : 0) + countX(str.substring(1, str.length()));
}

public int countHi(String str) {
	if (str.indexOf("hi") == -1)
		return 0;
	return 1 + countHi(str.substring(str.indexOf("hi") + 1, str.length()));
}

public String changeXY(String str) {
	return str.replaceAll("x", "y");
}

public String changePi(String str) {
	return str.replaceAll("pi", "3.14");
}

public String noX(String str) {
	return str.replaceAll("x", "");
}

public boolean array6(int[] nums, int index) {
	if (index >= nums.length)
		return false;
	if (nums[index] == 6)
		return true;
	return array6(nums, ++index);
}

public int array11(int[] nums, int index) {
	if (nums.length <= index)
		return 0;
	if (nums[index] == 11)
		return 1 + array11(nums, ++index);
	return array11(nums, ++index);
}

public int countHi2(String str) {
	str = str.replaceAll("xhi", "");
	if (str.indexOf("hi") == -1)
		return 0;
	return 1 + countHi2(str.substring(str.indexOf("hi") + 1, str.length()));
}

}
