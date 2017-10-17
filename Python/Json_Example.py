import json
from pprint import pprint

config = json.loads(open('c:\\Python\sample.json').read())
print(config["zones"][0]["displayName"])

"""
r = requests.get('http://api.zippopotam.us/us/ma/belmont')
 j = r.json()

 print j['state']
 for each in j['places']:
    print each['latitude']
"""

import demjson
