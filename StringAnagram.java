import java.util.*;

public class StringAnagram {
   public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
       Map<String, Integer> anagramCount = new HashMap<>();
       List<Integer> result = new ArrayList<>();

       // Count anagrams in the dictionary
       for (String word : dictionary) {
           String sortedWord = sortString(word);
           anagramCount.put(sortedWord, anagramCount.getOrDefault(sortedWord, 0) + 1);
       }

       // Check each query against the anagram counts
       for (String q : query) {
           String sortedQuery = sortString(q);
           result.add(anagramCount.getOrDefault(sortedQuery, 0));
       }

       return result;
   }

   // Helper method to sort the characters of a string
   private static String sortString(String str) {
       char[] charArray = str.toCharArray();
       Arrays.sort(charArray);
       return new String(charArray);
   }

   // Main method to run test cases
   public static void main(String[] args) {
       List<String> dictionary = Arrays.asList("listen", "silent", "enlist", "inlets", "google", "gooogle");
       List<String> queries = Arrays.asList("inlets", "google", "abc", "silent", "gogole");

       List<Integer> results = stringAnagram(dictionary, queries);

       // Print results
       for (int i = 0; i < queries.size(); i++) {
           System.out.println("Query: " + queries.get(i) + " - Anagram Count: " + results.get(i));
       }
   }
}
