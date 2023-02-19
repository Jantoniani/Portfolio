import requests


def get_weather(d, location):
    for key, value in d.items():
        if key == 'weather':
            for item in value:
                for key2, value2 in item.items():
                    if key2 == 'main':
                        current = value2
                    if key2 == 'description':
                        details = value2
                        print(f"The weather in {location} is {current} with {details}")  


def get_temperature(d, location):
    for key, value in d.items():
        if key == 'main':
            for key2, value2 in value.items():
                if key2 == 'temp':
                    temperature = (value2 - 273.15) * (9/5) + 32
                    temperature = round(temperature, 2)
                if key2 == 'humidity':
                    humidity = value2
                    print(f"The temperature in {location} is {temperature} degrees Fahrenheit with a humidity of {humidity}% ")


def weather_call():
    location = input("Please enter a location you'd like to see the weather for\n")
    r = requests.get(f"https://api.openweathermap.org/data/2.5/weather?q={location}&appid=cca89eaf598e93af1f808a71af562faf")
    d = r.json()
    get_weather(d, location)
    get_temperature(d, location)
    

weather_call()










# location = input("Please enter a location you'd like to see the weather for\n")

# r = requests.get(f"https://api.openweathermap.org/data/2.5/weather?q={location}&appid=cca89eaf598e93af1f808a71af562faf")

# d = r.json()

# #print(d)

# for key, value in d.items():
#     if key == 'weather':
#         for item in value:
#             for key2, value2 in item.items():
#                 if key2 == 'main':
#                     current = value2
#                 if key2 == 'description':
#                     details = value2
#                     print(f"The weather in {location} is {current} with {details}")            
#     if key == 'main':
#         for key2, value2 in value.items():
#             if key2 == 'temp':
#                  temperature = (value2 - 273.15) * (9/5) + 32
#                  temperature = round(temperature, 2)
#             if key2 == 'humidity':
#                 humidity = value2
#                 print(f"The temperature in {location} is {temperature} degrees Fahrenheit with a humidity of {humidity}% ")

