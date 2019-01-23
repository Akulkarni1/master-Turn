import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;

public class MergeIterator {
    public static <T> List<T>
    getListFromIterator(Iterator<T> iterator) {
        List<T> list = new ArrayList<>();

        iterator.forEachRemaining(list::add);

        return list;
    }

    public Iterator<String> combine(Iterator iter1, Iterator iter2) {

        List<String> listOne = getListFromIterator(iter1);

        List<String> listTwo = getListFromIterator(iter2);
        Collections.sort(listOne);
        Collections.sort(listTwo);

        List<String> combinedList = Stream.of(listOne, listTwo)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());

        return combinedList.iterator();
    }


}
