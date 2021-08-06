public class Main_2 {

    public static class Message {


        public static void main(String[] args) {
            StringBuilder stringBuilder = new StringBuilder("privet, proverka text");
            int n = 6;
            System.out.println(noMoreNLetters(stringBuilder, n));
        }

        public static StringBuilder noMoreNLetters(StringBuilder stringBuilder, int n) {    // выводит только те слова сообщения, которые содержат не более n букв.
            int firstLetter = 0, lastLetter, symvLetter = 0;
            StringBuilder temp = new StringBuilder("");
            while (firstLetter < stringBuilder.length()) {
                lastLetter = stringBuilder.indexOf(" ", firstLetter);
                if (lastLetter < 0) lastLetter = stringBuilder.length();
                if (stringBuilder.charAt(lastLetter - 1) == ',' || stringBuilder.charAt(lastLetter - 1) == '.' || stringBuilder.charAt(lastLetter - 1) == '!' || stringBuilder.charAt(lastLetter - 1) == '?')
                    symvLetter = 1;
                else symvLetter = 0;
                if (lastLetter - firstLetter - symvLetter <= n) {
                    temp = temp.append(stringBuilder.substring(firstLetter, lastLetter - symvLetter));
                    if (lastLetter != stringBuilder.length()) temp = temp.append(" ");
                }
                firstLetter = lastLetter + 1;
            }
            return temp;
        }

        public static StringBuilder deleteWordsWithX(StringBuilder stringBuilder, char x){ //TODO не проверено
            int firstLetter = 0, lastLetter, symvLetter = 0;
             while (firstLetter < stringBuilder.length()) {
                lastLetter = stringBuilder.indexOf(" ", firstLetter);
                if (lastLetter < 0) lastLetter = stringBuilder.length();
                if (stringBuilder.charAt(lastLetter - 1) == ',' || stringBuilder.charAt(lastLetter - 1) == '.' || stringBuilder.charAt(lastLetter - 1) == '!' || stringBuilder.charAt(lastLetter - 1) == '?')
                    symvLetter = 1;
                else symvLetter = 0;
                if (stringBuilder.charAt(lastLetter - symvLetter-1) == x) {
                    stringBuilder.delete(firstLetter,lastLetter-symvLetter);
                }
                firstLetter = lastLetter + 1;
            }
            return stringBuilder;
        }

    }
}

