package eu.senla.task11.main;

import eu.senla.task11.entity.Processor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Path path = Path.of("C:\\Users\\Khaustau\\IdeaProjects\\Senla\\src\\Processors");
        List<Processor> processors = new ArrayList<>();

        try (Stream<String> stream = Files.lines(path)) {
            processors = stream
                    .map(x -> x.split(";"))
                    .map(Main::createProcessor)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("File not found");
        }

        processors.forEach(System.out::println);

        String amdProcessor = "Amd";

        System.out.printf("%s processors:%n", amdProcessor);
        processors.stream().filter(x -> x.getProducer().equals(amdProcessor))
                .forEach(System.out::println);

        System.out.println("Processors sorted by frequency:");
        processors.stream().sorted((o1, o2) -> {
            if (o1.getFrequency() > o2.getFrequency()) {
                return 1;
            } else if (o1.getFrequency() == o2.getFrequency()) {
                return 0;
            }
            return -1;
        }).forEach(System.out::println);

        System.out.println("Grouping and sorting processors by cores:");

        Map<Integer, List<Processor>> groupingProcessorsByCores = processors.stream()
                .collect(Collectors.groupingBy(Processor::getCores));

        groupingProcessorsByCores.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(x -> System.out.println(x.getKey() + " : " + x.getValue()));

    }

    private static Processor createProcessor(String[] param) {
        String producer = param[0].trim();
        String model = param[1].trim();
        double frequency = Double.parseDouble(param[2].trim());
        int cores = Integer.parseInt(param[3].trim());

        return new Processor(producer, model, frequency, cores);
    }
}
