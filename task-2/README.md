# Task 2
Your task is to construct a simple password guesser.

## Theory
Passwords can be constructed using various symbols, most commonly:
1. Letters (a-z)
2. Uppercase letters (A-Z)
3. Numbers (0-9)

For the sake of this excercise, we'll assume that our password is constructed solely from the twenty-six lowercase letters.

### A note on password complexity
Many organisations, including OSSM, have *password complexity requirements.* For OSSM, passwords must have one uppercase, one lowercase letter, one number, and must be at least eight characters. Assuming a minimum length of eight characters, we can say that there are 62^8 (218,340,105,584,896) possible passwords. Why is this?

There are at least 62 characters to chose from: 26 lowercase letters, 26 uppercase letters, and 10 numbers. We raise this number to the number of characters in the password. This is the number of combinations we have to work with.

(We can reduce this number by making assumptions, such as that the uppercase letter will be the first letter and the number at the end, but I digress.)

### How do we hack a password?
We can generate a list of possible passwords by looping through every possible combination of letters. Let's begin with three-digit passwords from our twenty six lowercase letters. That's 26^3, or 17,576 possible passwords. That's a lot, but much nicer looking than 218,340,105,584,896. A computer can generate 17,576 passwords in a matter of milliseconds - modern computers handle many, many more calculations than that every second. (My relatively low powered laptop CPU handles 1.6 *billion* calculations per second).

We need a for loop for every character, and a for loop for every letter. Let's demonstrate using some code.

```java
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
```
This will result in an output similar to
```java
{
    "aaa",
    "aab",
    "aac",
    "aad",
    // ... [17570 lines hidden] ...
    "zzy",
    "zzz"
}
```