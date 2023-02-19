import os

def extract_place1():
    for photo_name in originals:
        i=0
        places = []
        length = len(photo_name)
        while i < length:
            if photo_name[i] == "_":
                places.append(i)
                i+=1
            else:
                i+=1
        start = places[0] + 1
        stop = places[1]
        print(photo_name[start:stop])


def extract_place2(file):
    first = file.find("_") + 1
    partial = file[first:]
    second = partial.find("_")
    name = partial[:second]
    return name


def extract_place(filename):
    list = filename.split("_")
    name = list[1]
    return name


def make_place_directories(places):
    for place in places:
        os.mkdir(place)


def organize_photos(directory):
    os.chdir(directory)
    originals = os.listdir()
    places = []
    for photo in originals:
        name = extract_place(photo)
        if name not in places:
            places.append(name)

    make_place_directories(places)

    for photo in originals:
        name = extract_place(photo)
        os.rename(photo, os.path.join(name, photo))


if __name__ == "__main__":
    organize_photos("Photos")




    



#print(os.listdir('/Users/jeremyantoniani/Documents/Cognizant_Full_Stack/Photos'))


# os.mkdir("Example")
# Thiswill create a new directory called Example

# os.rename(src, dst)
# os.rename('python/counting.py, 'Programs/lettercount.py')
# This moves the file from the python directory to Programs and rename is from counting to lettercount

# os.getcwd() - let's you get the current working directory
# os.chdir() - let's you change the current working directory

# A relative path means that the path is relative to the current working directory
# an absolute path specifies all the directories going back to the home directory

# os.getcwd --> pwd --> What's the current directory?
# os.listdir --> ls --> What files are here?
# os.mkdir --> mkdir --> Make a new directory
# os.rename --> mv --> Move or rename file or directory
# os.path.join() --> os.path.join("Documents", "Photos", "Oahu") --> 'Documents/Photos/Oahu'
# os.path.join(place, filename)

# portable code - code that will work correctly on different operating systems
# os.rename(filename, os.path.join(place, filename))

# when you import a module, the code in that module gets run.  Which means that any statements not part of a function call will be run
# adding a script footer can prevent this from happening
# __name__ contains the name of the file.  This can basically let Python differentiate whether the program is being run from the command line or whether it is being imported
# variables with double underscores are known as dunder variables and means that Python is doing some extra magic in the background that it wouldn't normally do with a regular variable

#although you don't always see it in the code, every script has its own copy of the __name__ variable
# before running the code in a program, python assigns a value to this variable
# the value it assigns depends on whether the script is being imported or getting directly executed

# example
# when you run something like python3 my_script.py, python assigns the value
# '__main__' to the __name__ variable
# when a script is imported, Python sets the script's __name__ variable to the name of the script
