package JavaPractice;

public class findlengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abceefghijklmnpo";
        System.out.println(lengthOfLongestSubstring(s));  // Expected output: 3
    }

    public static int lengthOfLongestSubstring(String s) {
        int strlen= s.length();
        int subtracker= 0;
        String substr;
        String longestSubStr="";
        while (subtracker<strlen) {
            String newSub= s.substring(subtracker,strlen);
            substr=findlongestSubStr(newSub);
            subtracker=subtracker+ substr.length();
            if(substr.length()>longestSubStr.length()){
                longestSubStr=substr;
            }
        }
        return longestSubStr.length();
    }

    public static String findlongestSubStr(String s) {
        char [] arr= s.toCharArray();
        StringBuilder strBld= new StringBuilder();
        for(char c: arr) {
            if(!strBld.toString().contains(String.valueOf(c))) {
                strBld.append(c);
            } else {
                break;
            }
        }
        System.out.println("The longest SubSTr: " + strBld);
        return strBld.toString();
    }
}
