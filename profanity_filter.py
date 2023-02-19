import string

rude_words = ["crap", "darn", "heck", "jerk", "idiot", "butt", "devil"]

def check_line(line):
    rude_count = 0
    word_index = 0
    words= line.splt(" ")
    for word in words:
        stripped_word = word.strip(string.punctuation).lower()
        if stripped_word in rude_words:
            rude_count += 1
            print(f"Found rude word: {word}")
            words[word_index] = bleeper2(word)
        word_index += 1
    line = " ".join(words)
    return line, rude_count


def check_file(filename):
    with open("my_story.txt") as myfile:
        rude_count = 0
        lines = []
        for line in myfile:
            line, rude_subtotal = check_line(line)
            rude_count += rude_subtotal
            lines.append(line)


    if rude_count == 0:
        print("Congratulations, your file has no rude words.")
        print("At least, no rude words I know")
    else:
        with open("bleeped_copy.txt", "w") as bleeped_copy:
            bleeped_copy.write("\n".join(lines))
        print(f"Found {rude_count} rude words in your file.  See bleeped_copy.txt for a censored copy of your file.")


def bleeper2(word):
    pos = 0 # Track the position (index) of the character so we can replace it
    for character in word:
        if character not in string.punctuation:
            character = "*" # If it wasn't punctuation, replace it
        word = word.replace(word[pos], character) # Replace the character at the current position
        pos += 1 # Move to the next character position
    return word


if __name__ == "__main__":
    check_file("my_other_story.txt")


# How to Write to a File
# Open a file in Write Mode
# Write to the file
# Close the file
# writefile = open("newfile.txt", "w")
# writefile.write("I'm writing to this file")
# The only things you can write to a file are strings
# numbers or any other types of values must be converted to strings or formatted into strings


# closing the file
# writefile.close()
# or
# with open ("newfile.txt", "w") as writefile:
#     writefile.write("Yay!")

# when using write, if the file already exists and you call it, the original contents will be overwritten


# Example
# new_file = open("new_file.txt", "w") # Create and open a new file in write mode
# new_file.write("New content!") # Write to the file
# new_file.close() # Close the file

# new_file = open("new_file.txt", "r") # Open the file again, this time in read mode
# contents = new_file.read() # Read the contents of the file
# print(contents) # Print it out to check that it worked!


# with open("new_file.txt", "w") as new_file: # Create and open new file
#     new_file.write("New content!") # Write to the file

# with open("new_file.txt", "r") as new_file: # Open the file again, this time in read mode
#     contents = new_file.read()

# print(contents)


#copying contents of one file into another file
# with open("old_file.txt", "r") as old_file:
#     old_content = old_file.read()

# with open("new_file.txt", "w") as new_file:
#         new_file.write(old_content)

# with open("new_file.txt", "r") as new_file:
#     contents = new_file.read()

# print(contents)


# with open("new_file.txt", "w") as new_file:
#     for num in range(31):
#         if num % 2 ==0:
#             new_file.write(str(num)+ "\n")


