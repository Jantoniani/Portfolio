import unicodedata
import emoji
from tkinter import *
from tkinter import ttk





# search = input("Enter an emoji to search for: ")
search2 = input("Enter an emoji to search for: ")

# def emoji_search():
#     print(unicodedata.lookup(search))

#     print(emoji.emojize(search2))



def emoji_search2():
    t = ':'+search2+':'
    u = emoji.emojize(t, language='alias')
    return u


print(emoji_search2())

