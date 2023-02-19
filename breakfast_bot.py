# name = input("What's your name?\n")
# Using ther newline escape sequence \n, at the end of the input prompt allows the user to answer on a new line
# print(f"Hello {name}")
# It's aimportant to remember that the input function always returns a string

import time

def print_pause(string, num = 2):
    print(string)
    time.sleep(num)

def valid_input(item1, item2):
    order = ''
    while item1 not in order.lower() and item2 not in order.lower():
        order = input(f"Please place your order.  Would you like {item1} or {item2}?\n")
        if item1 in order.lower():
            print_pause(f'{item1.capitalize()} it is!')
        elif item2 in order.lower():
            print_pause(f'{item2.capitalize()} it is!')
        else:
            print_pause('I\'m sorry, I don\'t understand')

print_pause('Hello! I am Bob, the Breakfast Bot')
print_pause('Today we have two breakfasts available')
print_pause('The first is waffles with strawberries and whipped cream')
print_pause('The second is sweet potato pancakes with butter and syrup')


def order_breakfast():
    # order = ''
    # while 'waffles' not in order.lower() and 'pancakes' not in order.lower():
    #     order = input("Please place your order.  Would you like waffles or pancakes?\n")
    #     if 'waffles' in order.lower():
    #         print_pause('Waffles it is!')
    #     elif 'pancakes' in order.lower():
    #         print_pause('Pancakes it is!')
    #     else:
    #         print_pause('I\'m sorry, I don\'t understand')
    valid_input('waffles', 'pancakes')

    print_pause('Your order will be ready shortly')


def order_breakfast2():
    order2 = ''
    while 'no' not in order2.lower():
        order2 = input('Would you like to place another order? Please say \'yes\' or \'no\'\n')
        if 'yes' in order2.lower():
            print_pause('Very good, I\'m happy to take another order')
            order_breakfast()
        elif 'no' in order2.lower():
            print_pause('OK, goodbye!')
        else:
            print_pause("I'm sorry, I don't understand")
    
order_breakfast()
order_breakfast2()