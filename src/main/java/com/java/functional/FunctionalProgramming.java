package com.java.functional;

public class FunctionalProgramming {

	Formula formula = new Formula() {

		@Override
		public double calculate(int a) {
			return sqrt(a * 100);
		}
	};

	Converter<String, Integer> converter = new Converter<String, Integer>() {

		@Override
		public Integer convert(String from) {
			return Integer.valueOf(from);
		}
	};

	Converter<String, Integer> converter1 = (from) -> {
		return Integer.valueOf(from);
	};

	Converter<String, Integer> converter2 = (from) -> Integer.valueOf(from);

	Converter<String, Integer> converter3 = Integer::valueOf;

	public void testConverter() {

		System.out.println(formula.calculate(100));
		System.out.println(formula.sqrt(16));

		Integer converted = converter.convert("123");
		System.out.println(converted); // 123

		Integer converted1 = converter1.convert("123");
		System.out.println(converted1); // 123

		Integer converted2 = converter2.convert("123");
		System.out.println(converted2); // 123

		Integer converted3 = converter3.convert("123");
		System.out.println(converted3); // 123

		Something something = new Something();
		Converter<String, String> converter4 = something::startsWith;
		String converted4 = converter4.convert("Java");
		System.out.println(converted4);
		
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Peter", "Parker");
		System.out.println(person);
	}

	public static void main(String[] args) {
		FunctionalProgramming functionalProgramming = new FunctionalProgramming();
		functionalProgramming.testConverter();
	}
}
