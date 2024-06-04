package exam1;

/**
 * Clase MyString: Exercise Lab Practice 2 - First Mid Term Exam Lab
 * 
 * @author PRG 
 * @version Academic year 2021-22
 */
public class MyString {    
    /** Hidden constructor, there are no objects of this class */
    private MyString() { }
    
    /**
     * Returns true if char c is a vowel and if not, it returns false .
     */
    private static boolean isVowel(char c) {
        final String VOWELS = "aeiouAEIOU";
        return VOWELS.indexOf(c) != -1;
    }
    
    /**
     * Returns an String resulting of replace all the characters of 
     * the String that are vowels with the given char parameter c.
     */
    public static String replaceVowels(String s, char c) { 
        /* TO COMPLETE, REMINDER: You must Change the returned value */
        final String aux = s;
        if(s.length() == 0) return "";
        if(isVowel(s.charAt(0))){
            return c + replaceVowels(s.substring(1),c);
            
        }else{
            return s.charAt(0) + replaceVowels(s.substring(1),c);
        }
        
    } 
    
    /**
     *    You can use this main method to test some Strings as an Example, 
     *  but passing these examples does not guarantee the maximum mark.
     *   You can also check your code with different Strings.  
     */
    public static void main(String[] args) {               
        System.out.println("This method does Eight calls to replaceVowels(String, char).");
        System.out.println("The first one is done with the empty String.");
        System.out.println("You can see as a result for each case the original String, the expected solution and your solution.\n");
        
        String[] s = {"", "bcd", "abcd", "bcde", 
                "aaa 4 uuu", "ctrlandX", "aeiou", "Shine On Until Tomorrow"}; 
        String[] sol = {"", "bcd", "Zbcd", "bcdZ", "ZZZ 4 ZZZ", "ctrlZndX", "ZZZZZ", "ShZnZ Zn ZntZl TZmZrrZw"};
        
        System.out.printf("%-30s %-30s %-15s\n", "      s", "replaceVowels(s, 'Z')", "Tu solución");
        for (int i = 0; i < s.length; i++) {
            System.out.printf("%-30s %-30s ", s[i], sol[i]);
            System.out.printf("%-15s\n", replaceVowels(s[i], 'Z'));
        }
    }
}