import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Nhập chuỗi chữ cái Latin: ");
	        String inputStr = scanner.nextLine();

	        List<String> result = findVietnameseCharacters(inputStr);
	        System.out.println("Chữ cái Tiếng Việt có thể tạo thành: "+ result.size()+" " + result);
	    }

	    public static List<String> findVietnameseCharacters(String inputStr) {
	        Map<String, Character> vietnameseCharacters = new HashMap<>();
	        vietnameseCharacters.put("aw", 'ă');
	        vietnameseCharacters.put("aa", 'â');
	        vietnameseCharacters.put("dd", 'đ');
	        vietnameseCharacters.put("ee", 'ê');
	        vietnameseCharacters.put("oo", 'ô');
	        vietnameseCharacters.put("ow", 'ơ');
	        vietnameseCharacters.put("w", 'ư');

	        List<String> vietnameseList = new ArrayList<>();
	        int i = 0;

	        while (i < inputStr.length()) {
	            boolean found = false;

	            for (int charLength = 2; charLength >= 1; charLength--) {
	                int endIndex = i + charLength;
	                if (endIndex <= inputStr.length()) {
	                    String substr = inputStr.substring(i, endIndex);
	                    // kiem tra xem ky tu co trong vietnameseCharacters ko
	                    if (vietnameseCharacters.containsKey(substr)) {
	                        vietnameseList.add(substr); // co thi them vao list
	                        i += charLength;
	                        found = true;
	                        break;
	                    }
	                }
	            }

	            if (!found) {
	                i++;
	            }
	        }

	        return vietnameseList;
	    }
}
