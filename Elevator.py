import time
items = []

def print_pause(string):
    print(string)
    time.sleep(2)


def selection():
    choice = input("1. Lobby\n"
               "2. Human Resources\n"
               "3. Engineering Department\n")
    return choice


def other():
    print_pause("Please enter the number of the floor you would like to visit:")
    ride_elevator()


def ride_elevator():
    floor = int(selection())
    if floor == 1:
        first_floor()
    elif floor == 2:
        second_floor()
    elif floor == 3:
        third_floor()
    else:
        other()


def first_floor():
    print_pause("You push the button for the first floor")
    print_pause("After a few moments you find yourself in the lobby")
    if 'ID Card' in items:
        print_pause("The clerk greets you, but she has already given you your ID Card, so there is nothing else to do here now")
    else:
        items.append('ID Card')
        print_pause('The clerk greets you and gives you your ID Card')
    print_pause("Where would you like to go next?")
    ride_elevator()


def second_floor():
    print_pause("You push the button for the second floor")
    print_pause("After a few moments you find yourself in the human resources department")
    if 'ID Card' in items and 'handbook' not in items:
        print_pause('The head of HR greets you')
        print_pause('He looks at your ID card and then gives you a copy'
                    ' of the employee handbook')
        items.append('handbook')
    elif 'ID Card' not in items and 'handbook' not in items:
        print_pause('The head of HR greets you')
        print_pause('He has something for you, but he says he can\'t'
                    ' give it to you until you go get your ID Card')
    elif 'handbook' in items:
        print_pause('The HR folks are busy at their desks. '
                    'There doesn\'t seem to be much to do here')
    print_pause("Where would you like to go next?")
    ride_elevator()


def third_floor():
    print_pause("You push the button for the third floor")
    print_pause("After a few moments you find yourself in the engineering department")
    if 'ID Card' in items and 'handbook' not in items:
        print_pause('You use your ID card to open the door')
        print_pause('Your program manager greets you and tells you '
                    'that you need to have a copy of the employee '
                    'handbook in order to start work')
        print_pause('They scowl when they see that you don\'t have it, '
                    'and send you back to the elevator' )
        ride_elevator()
    elif 'ID Card' not in items:
        print_pause("Unfortunately, the door is locked and you can't get in")
        print_pause("It looks like you need some kind of key card to open the door")
        print_pause("You head back to the elevator")
        ride_elevator()
    elif 'ID Card' in items and 'handbook' in items:
        print_pause('You use your ID card to open the door')
        print_pause('Your program manager greets you and tells you '
                    'that you need to have a copy of the employee '
                    'handbook in order to start work')
        print_pause('Fortunately, you got that from HR!')
        print_pause('Congratulations! You are ready to start your new '
                    'job as vice president of engineering!')


def intro():
    print_pause("You have just arrived at your new job!")
    print_pause("You are in the elevator")
    print_pause("Please enter the number of the floor you would like to visit:")


def play_game():
    items = []
    intro()
    ride_elevator()
    return items


play_game()



