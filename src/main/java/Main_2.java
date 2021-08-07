public class Main_2 {

    public static class Message {


        public static void main(String[] args) {
            StringBuilder stringBuilder = new StringBuilder("Well, Prince, so Genoa and Well Lucca are now Well just family estates of the Buonapartes. ");
            int n = 6;
            char x = 't';
            System.out.println("ИСХОДНИК \t->\t" + stringBuilder);
            System.out.println("а) Вывести только те слова сообщения, которые содержат не более n букв. \t->\t" + noMoreNLetters(stringBuilder, n));
            System.out.println("б) Удалить из сообщения все слова, которые заканчиваются на заданный символ. \t->\t" + deleteWordsWithX(stringBuilder, x));
            System.out.println("в) Найти самое длинное слово сообщения. \t->\t" + longestWord(stringBuilder));
            System.out.println("г) Сформировать строку с помощью StringBuilder из самых длинных слов сообщения. \t->\t" + longestWords(stringBuilder, 5));
            System.out.println("д) ***Создать метод, который производит частотный анализ текста. \t->\t" + wordsCount(stringBuilder, "Well"));
        }

        public static StringBuilder noMoreNLetters(StringBuilder stringBuilder, int n) {    // выводит только те слова сообщения, которые содержат не более n букв.
            int firstLetter = 0, lastLetter, symvLetter;
            StringBuilder temp = new StringBuilder();
            while (firstLetter < stringBuilder.length()) {
                lastLetter = stringBuilder.indexOf(" ", firstLetter);
                if (lastLetter < 0) lastLetter = stringBuilder.length();
                if (stringBuilder.charAt(lastLetter - 1) == ',' || stringBuilder.charAt(lastLetter - 1) == '.' || stringBuilder.charAt(lastLetter - 1) == '!' || stringBuilder.charAt(lastLetter - 1) == '?')
                    symvLetter = 1;
                else symvLetter = 0;
                if (lastLetter - firstLetter - symvLetter <= n) {
                    temp.append(stringBuilder.substring(firstLetter, lastLetter - symvLetter));
                    if (lastLetter != stringBuilder.length()) {
                        temp.append(" ");
                    }
                }
                firstLetter = lastLetter + 1;
            }
            return temp;
        }

        public static StringBuilder deleteWordsWithX(StringBuilder stringBuilder, char x) { // Удалить из сообщения все слова, которые заканчиваются на заданный символ.
            int firstLetter = 0, lastLetter, symvLetter;
            while (firstLetter < stringBuilder.length()) {
                lastLetter = stringBuilder.indexOf(" ", firstLetter);
                if (lastLetter < 0) lastLetter = stringBuilder.length();
                if (stringBuilder.charAt(lastLetter - 1) == ',' || stringBuilder.charAt(lastLetter - 1) == '.' || stringBuilder.charAt(lastLetter - 1) == '!' || stringBuilder.charAt(lastLetter - 1) == '?')
                    symvLetter = 1;
                else symvLetter = 0;
                if (stringBuilder.charAt(lastLetter - symvLetter - 1) == x) {
                    stringBuilder.delete(firstLetter, lastLetter + 1);
                }
                firstLetter = lastLetter + 1;
            }
            return stringBuilder;
        }

        public static StringBuilder longestWord(StringBuilder stringBuilder) { // Найти самое длинное слово сообщения
            int firstLetter = 0, lastLetter, symvLetter, numberLetters = 0;
            StringBuilder longestWord = new StringBuilder();
            while (firstLetter < stringBuilder.length()) {
                lastLetter = stringBuilder.indexOf(" ", firstLetter);
                if (lastLetter < 0) lastLetter = stringBuilder.length();
                if (stringBuilder.charAt(lastLetter - 1) == ',' || stringBuilder.charAt(lastLetter - 1) == '.' || stringBuilder.charAt(lastLetter - 1) == '!' || stringBuilder.charAt(lastLetter - 1) == '?')
                    symvLetter = 1;
                else symvLetter = 0;
                if (lastLetter - firstLetter - symvLetter - 1 > numberLetters) {
                    numberLetters = lastLetter - firstLetter - symvLetter - 1;
                    longestWord = new StringBuilder(stringBuilder.substring(firstLetter, lastLetter - symvLetter));
                }
                firstLetter = lastLetter + 1;
            }
            return longestWord;
        }

        public static StringBuilder longestWords(StringBuilder stringBuilder, int numberLetters) { // Сформировать строку с помощью StringBuilder из самых длинных слов сообщения.
            int firstLetter = 0, lastLetter, symvLetter;
            StringBuilder longestWords = new StringBuilder();
            while (firstLetter < stringBuilder.length()) {
                lastLetter = stringBuilder.indexOf(" ", firstLetter);
                if (lastLetter < 0) lastLetter = stringBuilder.length();
                if (stringBuilder.charAt(lastLetter - 1) == ',' || stringBuilder.charAt(lastLetter - 1) == '.' || stringBuilder.charAt(lastLetter - 1) == '!' || stringBuilder.charAt(lastLetter - 1) == '?')
                    symvLetter = 1;
                else symvLetter = 0;
                if (lastLetter - firstLetter - symvLetter >= numberLetters) {
                    longestWords.append(stringBuilder.substring(firstLetter, lastLetter - symvLetter));
                    if (lastLetter != stringBuilder.length()) {
                        longestWords.append(" ");
                    }
                }
                firstLetter = lastLetter + 1;
            }
            return longestWords;
        }

        public static int wordsCount(StringBuilder stringBuilder, String textFinding) { // частотный анализ текста
            int firstLetter = 0, lastLetter, symvLetter, wordsCount = 0;
            while (firstLetter < stringBuilder.length()) {
                lastLetter = stringBuilder.indexOf(" ", firstLetter);
                if (lastLetter < 0) lastLetter = stringBuilder.length();
                if (stringBuilder.charAt(lastLetter - 1) == ',' || stringBuilder.charAt(lastLetter - 1) == '.' || stringBuilder.charAt(lastLetter - 1) == '!' || stringBuilder.charAt(lastLetter - 1) == '?')
                    symvLetter = 1;
                else symvLetter = 0;
                if (stringBuilder.substring(firstLetter, lastLetter - symvLetter).equals(textFinding)) {
                    wordsCount++;
                }
                firstLetter = lastLetter + 1;
            }
            return wordsCount;
        }

    }
}

