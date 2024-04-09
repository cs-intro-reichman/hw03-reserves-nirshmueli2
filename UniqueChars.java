/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string,
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        String Newstr = "";
        for (int i = 0; i < s.length(); i++) {
            char first = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == first && s.charAt(j) != ' ') {
                    char Notneeded = 1;
                    s = s.substring(0, j) + Notneeded + s.substring(j + 1);
                }
            }
        }
        for (int u = 0; u < s.length(); u++) {
            if (s.charAt(u) != 1) {
                char good = s.charAt(u);
                Newstr += good;
            }
        }
        return Newstr;
    }

}