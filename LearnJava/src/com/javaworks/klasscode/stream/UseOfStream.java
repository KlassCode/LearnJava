package com.javaworks.klasscode.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * @author Klasscode
 */

public class UseOfStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> studentsName = Arrays.asList("Armand", "Balmont", "Florient", "Eve", "Eleonor");
		// List<String> filteredName=
		// studentsName.stream().filter(name->name.startsWith("A")).collect(Collectors.toList());

		// filteredName.forEach((name)-> System.out.println(name));
		long nb = studentsName.stream().filter(name -> name.startsWith("A")).count();
		System.out.println(nb);
		Stream.of(studentsName).findFirst().ifPresent((str) -> System.out.println(str.get(0).length()));
		Stream<Integer> numbers1 = Stream.iterate(1, n -> n + 5).limit(10);
		for (int i : numbers1.collect(Collectors.toList())) {
			System.out.println(i);
		}
		// Generate numbers

		Stream<Double> numbers = Stream.generate(() -> Math.random()).limit(10);
		numbers.forEach((name) -> System.out.println(name));

		String phrase = "Bonjour les amis j'apprend a programmer en java";
		String[] tab_phrase = phrase.split(" ");
		System.out.println(tab_phrase.length);
		Stream<String> st = Arrays.stream(tab_phrase);
		Optional<String> op = st.reduce((word1, word2) -> word1 + "-" + word2);
		System.out.println(op.get());

		List<String> list = Arrays.asList("Abnel", "Agenor", "Fleurant", "Ednah", "Quentin");
		list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);

		// Use of flatmap to combine 2 list
		List<String> femaleNames = Arrays.asList("Eve", "Lia", "carla");
		List<String> maleNames = Arrays.asList("Adam", "marc", "carl");

		List<List<String>> list1 = Arrays.asList(femaleNames, maleNames);

		list1.stream().flatMap(l -> l.stream()).collect(Collectors.toList()).forEach(System.out::println);
		;

		// Using Stream with Map

		Map<String, Integer> map = new HashMap<>();
		map.put("Klassen", 22);
		map.put("Emma", 23);
		map.put("Roman", 21);
		map.put("Eliott", 20);
		map.put("Carla", 19);
		map.put("Frederic", 18);

		Map<String, Integer> resultMap = map.entrySet().stream().filter(m -> m.getValue() >= 20)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println(resultMap);
		Set<Entry<String, Integer>> setEntry = resultMap.entrySet();
		Iterator<Map.Entry<String, Integer>> it = setEntry.iterator();

		while (it.hasNext()) {
			String key = it.next().getKey();
			int value = it.next().getValue();
			System.out.println(key + " - " + value);
		}

		// Parallel Stream vs sequential Stream

		long start = System.currentTimeMillis();

		long c = IntStream.rangeClosed(0, 100000).parallel().filter(n -> n % 2 == 0).count();

		long duration = System.currentTimeMillis() - start;
		System.out.println("counted " + c + " in " + duration);

	}

}
