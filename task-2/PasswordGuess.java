public class PasswordGuess {
    public static String[] getPasswordGuesses() {
        // --- This part should match `README.md`
        // Let's get a string array of every letter. We can use the String.split() method, which breaks
        // a string into an array.
        String[] letters = "abcdefghijklmnopqrstuvwxyz".split("");
        // We're assuming it's a three digit password made of lowercase letters.
        // There's 17576 possible combinations. Let's make a string array to store our guesses.
        String[] guesses = new String[17576];
        // This is just an iterator
        int i = 0;

        for (int firstLetter = 0; firstLetter < 26; firstLetter++) {
            for (int secondLetter = 0; secondLetter < 26; secondLetter++) {
                for (int thirdLetter = 0; thirdLetter < 26; thirdLetter++) {
                    // Iterate through the letters and concatenate them
                    String guess = letters[firstLetter] + letters[secondLetter] + letters[thirdLetter];
                    guesses[i] = guess;
                    // Increment our iterator so we can keep track
                    i++;
                }
            }
        }
        // --- End of README
        return guesses;
    }

    public static void main(String[] args) {
        System.out.println("Here's a list of every possible 3-digit password!");
        try {
            Thread.sleep(1000);
        } catch (Exception e) { /* don't try this at home, kids */ }
        System.out.println();
        for (String guess : getPasswordGuesses()) {
            System.out.println(guess);
        }
    }
}