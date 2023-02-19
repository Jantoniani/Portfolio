import time
import random


def print_pause(string):
    print(string)
    time.sleep(2)


def intro():
    print_pause('\nThe world has been cold for awhile now, '
                'the villains like it better that way')
    print_pause('You walk along an empty street and think back to before '
                'the uprising, when the world knew peace')
    print_pause('You question why noone saw the takeover coming, '
                'and you curse yourself for being powerless to stop it')
    print_pause('In the distance you hear an explosion')
    print_pause('Instinctively, you run towards it, but you hesitate')
    print_pause('As one of the last remaining heroes, '
                'you have to be careful...what do you do?')


def explosion(choices, villain_leader, crash_object):
    print_pause('Enter 1 to investigate the explosion')
    print_pause('Enter 2 to head back to your hideout')
    choice = input('What is your choice?\nPlease enter 1 or 2\n')
    if int(choice) == 1:
        print_pause('Upon arriving at the explosion you find '
                    f'that a {crash_object} has crashed to Earth')
        print_pause('You move closer as it calls it to you, '
                    'but you stop as you sense danger')
        meteorite(choices, villain_leader, crash_object)
    elif int(choice) == 2:
        print_pause('As you make your way back towards your hideout, '
                    f'you are stopped by the villain leader, {villain_leader}')
        print_pause('The most powerful villain in the world now '
                    'stands before you')
        print_pause(f'Defeating {villain_leader} could set humanity back '
                    'on the proper course')
        villain(choices, villain_leader, crash_object)
    else:
        print_pause('Please enter a valid choice')
        explosion(choices, villain_leader, crash_object)


def meteorite(choices, villain_leader, crash_object):
    print_pause(f'Enter 1 to touch the {crash_object}')
    print_pause('Enter 2 to head back to the empty street')
    choice = input('What is your choice?\nPlease enter 1 or 2\n')
    if int(choice) == 1 and 'power' not in choices:
        print_pause(f'You touch the {crash_object} and feel power '
                    'surging through your body')
        print_pause('This is the power you need to take back '
                    'the world.  The power to turn the tide '
                    ' in your favor')
        choices.append('power')
        meteorite(choices, villain_leader, crash_object)
    elif int(choice) == 1 and 'power' in choices:
        print_pause(f'The {crash_object} has been drained of power. '
                    'There\'s nothing left to do here')
        meteorite(choices, villain_leader, crash_object)
    elif int(choice) == 2:
        print_pause('You head back to the empty street')
        explosion(choices, villain_leader, crash_object)
    else:
        print_pause('Please enter a valid choice')
        meteorite(choices, villain_leader, crash_object)


def villain(choices, villain_leader, crash_object):
    print_pause('Enter 1 to stand your ground and fight')
    print_pause('Enter 2 to run back to the empty street and regroup')
    choice = input('What is your choice?\nPlease enter 1 or 2\n')
    if int(choice) == 1 and 'power' in choices:
        print_pause(f'The {crash_object} has made you more powerful than ever')
        print_pause('Your confidence overflows with your newfound power')
        print_pause(f"You wage war with the villain leader {villain_leader} "
                    "and come out victorious!")
        print_pause('You fly off into the sunset to take back the world')
        play_again()
    elif int(choice) == 1 and 'power' not in choices:
        print_pause(f'The villain leader {villain_leader} is stronger '
                    'than you ever imagined')
        print_pause('You fight until the bitter end, but are defeated')
        print_pause('Humanity\'s last hope is gone')
        play_again()
    elif int(choice) == 2:
        print_pause('You make haste and escape '
                    f'the villain leader {villain_leader} without a fight')
        explosion(choices, villain_leader, crash_object)
    else:
        print_pause('Please enter a valid choice')
        villain(choices, villain_leader, crash_object)


def play_again():
    print_pause('Would you like to play again?')
    print_pause('Enter yes to play again')
    print_pause('Enter no to exit')
    choice = input('What is your choice?\nPlease enter yes or no\n')
    if 'yes' in choice.lower():
        play_game()
    if 'no' in choice.lower():
        print_pause('Thanks for playing!')


def play_game():
    choices = []
    crash_objects = ['meteorite', 'space ship', 'space whale',
                     'giant glowing crystal', 'statue of rocky balboa']
    villains = ['Ivan Drago', 'Rita Repulsa', 'Thanos', 'Dr. Doom',
                'The Sanderson Sisters', 'Elon Musk']
    crash_object = random.choice(crash_objects)
    villain_leader = random.choice(villains)
    intro()
    explosion(choices, villain_leader, crash_object)


play_game()
