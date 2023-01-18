/*
  1. Create three static methods:
      -void name(String n)
      -void ageInfo(int age, String grade)
      -void hobbies(String[] hobbyList)
  2. In the main method, declare variables with
     your values
  3. Call each of your methods, passing the appropriate
     variables
  4. Inside the name method, print a string like
    "My name is <name>"
  5. Inside the ageInfo method, print a string like
    "I am a <age>-year old <grade>"
  6. Use a loop in the hobbies method to print a list
    of your hobbies.  e.g.,
    "My hobbies are:
      <hobby1>
      <hobby2>
      ..."
*/
class AllAboutMe {
  public static void main(String[] args) {
	  String name = "Mitch";
	  int age = 17;
	  String grade = "Senior";
	  String[] hobbyList = {
		  "Hiking",
		  "Biking",
		  "Programming"
	  };
	  name(name);
	  ageInfo(age, grade);
	  hobbies(hobbyList);

  }

  public static void name(String n) {
	  System.out.printf("My name is %s%n", n);
  }

  public static void ageInfo(int age, String grade) {
	  System.out.printf("I am a %d-year old %s%n", age, grade);
  }

  public static void hobbies(String[] hobbyList) {
	  System.out.println("My hobbies are:");
	  for (int i = 0; i < hobbyList.length; i++) {
		  System.out.println(hobbyList[i]);
		}
	}
}
