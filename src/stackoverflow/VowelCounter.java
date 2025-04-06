package stackoverflow;

import java.util.Scanner;

public class VowelCounter
{

    public static void main(String... args)
    {
        int answer = 0;
        Scanner input = null;
        do
        {
            input = new Scanner(System.in);
            System.out
                    .print("Type a sentence and this program will tell you\nhow many vowels there are (excluding 'y'):");
            String sentence = input.nextLine();

            int vowels = 0;
            int consonants = 0;
            int digits = 0;
            int whitespaces = 0;

            String temp = sentence.toUpperCase();
            for (int i = 0; i < sentence.length(); i++)
            {
                char character = (char) temp.charAt(i);
                if(Character.isDigit(character))
                {
                    digits++;
                }
                else if(Character.isWhitespace(character))
                {
                    whitespaces++;
                }
                else if(Character.isAlphabetic(character))
                {
                    switch (character)
                    {
                        case 'A':
                        case 'E':
                        case 'I':
                        case 'O':
                        case 'U':
                            vowels++;
                            break;
                        default:
                            consonants++;
                            break;
                    }
                }
                else
                {
                    System.out
                            .println("ERROR: Not an alphanumeric character or a whitespace: '"
                                    + character + "'");
                }
            }
            System.out.println("The sentence: \"" + sentence + "\" has "
                    + vowels + ((vowels != 1) ? " vowels, " : " vowel, ")
                    + digits + ((digits != 1) ? " digits, " : " digit, ")
                    + whitespaces
                    + ((whitespaces != 1) ? " whitespaces, " : " whitespace, ")
                    + consonants
                    + ((consonants != 1) ? " consonants. " : " consonant."));
            System.out
                    .print("Would you like to check another phrase in the Vowel Counter? if so Press 1 if not press any other key... ");
            String tempNum = input.next();
            try
            {
                answer = Integer.parseInt(tempNum);
            }
            catch (NumberFormatException e)
            {
                answer = 0;
            }
            System.out.println();
        } while (answer == 1);
        input.close();
        System.out.println("Have a nice day");
    }
}
