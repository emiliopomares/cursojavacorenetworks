import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

public class Streams {
	public static void main(String[] args) {
		Stream<Integer> myStream = Stream.of(6, 2, 5, 4, 9, 1, 4, 2, 8, 4);
		List<Integer> newList = 
			myStream.filter((i) -> (i%2==0)).collect(Collectors.toList()); //reducing((a,b)->a+b));
		
		// The sum of all odd numbers:
		Stream<Integer> myOtherStream = Stream.of(6, 2, 5, 4, 9, 1, 4, 2, 8, 4);
		int SumOfAllOddNumbers =
			myOtherStream.filter((i) -> (i%2==1)).collect(Collectors.reducing((x,y)->x+y)).orElse(0);
		System.out.println("Sum of all odd numbers = " + SumOfAllOddNumbers);
	}
}
