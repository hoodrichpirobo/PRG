package pract2;

/**
 * Clase TestPract2: program class for checking 
 * method isPrefix(String, String) and isSubstring(String, String)
 * 
 * @author PRG - ETSINF - DSIC - UPV
 * @version Academic Year 2023/2024
 */
public class TestPract2 {
    /** Hidden constructor */
    private TestPract2() { }
    
    public static void testIsPrefix() {
        String[] s = {"", "rec", "pecur", 
                      "recurso", "remursi", 
                      "123456789", "recursion"};
    
        System.out.printf("%8s %12s %20s %12s\n", 
            "a", "b", "isPrefix(a, b)", "b.startsWith(a)");
    
        // a and b empty
        compareIsPrefix(s[0], s[0]); // both "" 
    
        // a empty                          
        compareIsPrefix(s[0], s[3]); // a = "", b = "recurso" 
    
        // b empty                  
        compareIsPrefix(s[1], s[0]); // a = "rec", b = "" 
    
        // a longer than b                  
        compareIsPrefix(s[3], s[1]); // a = "recurso", b = "rec"
    
        // a and b equally long and a is prefix of b                  
        compareIsPrefix(s[1], s[1]); // a = "rec", b = "rec" 
    
        // a and b equally long and a is not a prefix of b                  
        compareIsPrefix(s[1], s[2]); // a = "rec", b = "pecur"
    
        // a shorter than b and a is prefix of b                  
        compareIsPrefix(s[1], s[6]); // a = "rec", b = "recursion"
    
        // a shorter than b and a is not a prefix of b                  
        // the first character fails
        compareIsPrefix(s[2], s[6]); // a = "pecur", b = "recursion"
    
        // a shorter than b and a is not a prefix of b                  
        // the last character fails
        compareIsPrefix(s[4], s[6]); // a = "remursi", b = "recursion"
    
        // a shorter than b and a is not a prefix of b                  
        // an intermediate character fails
        compareIsPrefix(s[5], s[6]); // a = "123456789", b = "recursion"             
    }
      
    public static void testIsSubstring() {
        String[] s = {"", "rec", "pecur", 
                      "recurso", "remursi", 
                      "123456789", "recursion",
                      "sion", "curs"};
               
        System.out.printf("%8s %12s %20s %10s\n", 
                          "a", "b", "isSubstring(a,b)", "b.contains(a)"); 
    
        // a and b empty
        compareIsSubstring(s[0], s[0]); // both ""
    
        // a empty                          
        compareIsSubstring(s[0], s[3]); // a = "", b = "recurso"
    
        // b empty                  
        compareIsSubstring(s[1], s[0]); // a = "rec", b = ""
    
        // a longer than b                  
        compareIsSubstring(s[6], s[1]); // a = "recursion", b = "rec"
    
        // a and b equally long and a is contained within b
        compareIsSubstring(s[6], s[6]); // a = "recursion", b = "recursion"
    
        // a and b equally long and a is not contained within b
        compareIsSubstring(s[3], s[4]); // a = "recurso", b = "remursi"
    
        // a shorter than b and a is contained within b because a is prefix of b
        compareIsSubstring(s[1], s[6]); // a = "rec", b = "recursion"
    
        // a shorter than b and a is contained within b because a is suffix of b
        compareIsSubstring(s[7], s[6]); // a = "sion", b = "recursion"
    
        // a shorter than b and a is contained within b because a is within b from an intermediate position
        compareIsSubstring(s[8], s[6]); // a = "curs", b = "recursion"
    }
     
    private static void compareIsPrefix(String a, String b) {
        System.out.printf("%12s %12s %12b %12b\n", a, b, 
                          PRGString.isPrefix(a, b),
                          b.startsWith(a));
                          
        
    }
    
    private static void compareIsSubstring(String a, String b) {
        System.out.printf("%12s %12s %12b %12b\n", a, b, 
                          PRGString.isSubstring(a, b),
                          b.contains(a));
    }
   
}