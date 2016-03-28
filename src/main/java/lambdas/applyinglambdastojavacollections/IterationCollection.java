package lambdas.applyinglambdastojavacollections;

import java.util.Arrays;
import java.util.List;

public class IterationCollection {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("Joe", "Grind", 78, Person.Sex.MALE),
				new Person("Jemala", "Bob", 22, Person.Sex.MALE), new Person("Janet", "Peach", 10, Person.Sex.FEMALE),
				new Person("Peter", "smith", 9, Person.Sex.MALE));

		persons.stream().forEach(e -> e.setLastName("Doe"));

		for (Person person : persons) {
			System.out.println(person);
		}

		/**
		 * http://docs.oracle.com/javase/tutorial/collections/streams/
		 * 
		 * The mapToInt operation returns a new stream of type IntStream (which
		 * is a stream that contains only integer values). The operation applies
		 * the function specified in its parameter to each element in a
		 * particular stream. In this example, the function is Person::getAge,
		 * which is a method reference that returns the age of the member.
		 * (Alternatively, you could use the lambda expression e -> e.getAge().)
		 * Consequently, the mapToInt operation in this example returns a stream
		 * that contains the ages of all male members in the collection roster.
		 */
		String startsWithCreteria = "J";
		double average = persons.stream().filter(p -> p.name.startsWith(startsWithCreteria)).mapToInt(Person::getAge)
				.average().getAsDouble();

		System.out.println("average age " + average);
	}
}
