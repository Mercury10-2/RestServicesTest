package restservices.restservices.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import restservices.restservices.domain.Months;

@Service
public class MainService {

    //  Since Stream API can generate multiple threads we should prefer StringBuffer over StringBuilder
    private static final StringBuffer sb = new StringBuffer();
    private static final Comparator<String> comparator = Comparator
                            .comparingInt(String::length)
                            .thenComparing(String::compareToIgnoreCase);

    public String getMonthName(int value) {
        if (value < 1 || value > 12)
            return "INCORRECT INPUT DATA";
        return modifyMonthName(Months.values()[value - 1].toString());
    }

    //  Although StringBuilder is faster and local variables provide better performance
    //  I didn't create local StringBuilder since we have global StringBuffer
    private String modifyMonthName(String month) {
        sb.setLength(0);
        for (char c : month.toCharArray())
            sb.append(c).append("-");
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
    
    public List<String> sortLines(List<String> input) {
        List<String> data = input.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return modifyList(data);
    }

    private List<String> modifyList(List<String> input) {
        return input.stream()
                .map(line -> modifyString(line))
                .collect(Collectors.toList());
    }

    private String modifyString(String line) {
        sb.setLength(0);
        return sb   .append("(")
                    .append(line.length())
                    .append("): ")
                    .append(line).toString();
    }
}