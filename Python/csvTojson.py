import csv,itertools,json,re
import datetime as dt
from datetime import datetime
import shutil

csvfile =open("C:\\Users\\Amit\\Downloads\\train_data.csv","r")


fieldnames = ["destination_name","destination_code","destination_arrival_scheduled","destination_arrival_actual","origin_name","origin_code","origin_departure_scheduled","origin_departure_actual","train_date","train_code"]
reader = csv.DictReader(csvfile)

title = reader.fieldnames
csv_rows=[]
origin_temp={}
origin= {}
def write_json(data, json_file):
    with open(json_file, "wb+") as f:
        #if format == "pretty":
            f.write(json.dumps(data, sort_keys=False, indent=4, separators=(',', ':'),encoding="utf-8",ensure_ascii=False))
        #else:
        #    f.write(json.dumps(data))

original_data={}
origidata=[]
FMT = "%H:%M:%S"

origin={}
temp_origin={}
temp_deparature={}
departure_flag =False
origin_flag = False
departure_act=""
departure_sched=""
departure_time_diff=""

destination={}
temp_destination={}
temp_arrival={}
arrival_flag=False
destination_flag = False
arrival_act=""
arrival_sched=""
arrival_time_diff=""

temp_train={}
train= {}
train_flag = False
count=0;

oneMoreOrigin=[]
onemorecount =0
for row in reader:
    for i in range(len(title)):
        if "origin" in title[i] and "name" in title[i]:
            name={"name":row[title[i]]}
            temp_origin.update(name)
            origin_flag= True
        if "origin" in title[i]and "code" in title[i]:
            code={"code":row[title[i]]}
            temp_origin.update(code)
            origin_flag=True
        if "origin" in title[i] and "departure" in title[i] and "scheduled" in title[i]:
            departure_scheduled={"scheduled":row[title[i]]}
            departure_sched=row[title[i]]
            temp_deparature.update(departure_scheduled)
            depature_flag=True
            origin_flag= True
        if "origin" in title[i] and "actual" in title[i] and "actual" in title[i]:
            departure_actual={"actual":row[title[i]]}
            temp_deparature.update(departure_actual)
            departure_act = row[title[i]]
            departure_flag = True
            origin_flag=True
            if departure_flag==True:
                departure_time_diff = datetime.strptime(departure_act, FMT) - datetime.strptime(departure_sched, FMT)
                total_sec = int(departure_time_diff.total_seconds())
                hours,remainder= divmod(total_sec,60*60)
                minutes,sec = divmod(remainder,60)
                temp = '{}:{:}:{:}'.format(hours,minutes,sec)
                departure_diff={"diff":temp}


                temp_deparature.update(departure_diff)
                departure={"departure":temp_deparature}
                temp_origin.update(departure)
            if origin_flag==True:
                origin={"origin":temp_origin}
                original_data.update(origin)
                origin_flag=False
                departure_flag=False
                #print(original_data)
        if "destination" in title[i] and "code" in title[i]:
            code={"code":row[title[i]]}
            destination_flag= True
            temp_destination.update(code)
        if "destination" in title[i] and "name" in title[i]:
            name={"name":row[title[i]]}
            destination_flag = True
            temp_destination.update(name)
        if "destination" in title[i] and "arrival" in title[i] and "scheduled" in title[i]:
            scheduled ={"scheduled":row[title[i]]}
            arrival_sched = row[title[i]]
            temp_arrival.update(scheduled)
            arrival_flag = True
            destination_flag= True
        if "destination" in title[i] and "arrival" in title[i] and "actual" in title[i]:
            actual = {"actual": row[title[i]]}
            arrival_act = row[title[i]]
            temp_arrival.update(actual)
            arrival_flag = True
            destination_flag = True
            if arrival_flag == True:
                arrival_time_diff = datetime.strptime(arrival_act, FMT) - datetime.strptime(arrival_sched, FMT)
                total_sec = int(arrival_time_diff.total_seconds())
                hours, remainder = divmod(total_sec, 60 * 60)
                minutes, sec = divmod(remainder, 60)
                temp = '{}:{:}:{:}'.format(hours, minutes, sec)
                arrival_diff = {"diff": temp}
                temp_arrival.update(arrival_diff)

                arrival={"arrival":temp_arrival}
                temp_destination.update(arrival)
            if destination_flag ==True:
                destination={"destination":temp_destination}
                original_data.update(destination)
                #print(original_data)
        if "train" in title[i] and "date" in title[i]:
            date ={"date":row[title[i]]}
            temp_train.update(date)
            train_flag= True
        if "train" in title[i] and "code" in title[i]:
            code ={"code":row[title[i]]}
            temp_train.update(code)
            train_flag=True
            if train_flag==True:
                train ={"train":temp_train}
                original_data.update(train)

                origidata.append(original_data.copy())
                #write_json(origidata, "C:\\Users\\Amit\\csvToJson\\fil%d.json" % count)
                count += 1
print origidata
#below is the dirty code ,It can be done as counting the number of line in the first file and then accordingly update the same, But it will still create the number of files equals to number of records.
'''
import glob
import os
filelist=[]
for counter ,files in enumerate(glob.glob("C:\\Users\\Amit\\csvToJson\\*.json")):
    filelist.append(files)
count=0
with open("C:\\Users\\Amit\\result.json","w") as outfile:
    for line in itertools.chain.from_iterable(itertools.imap(open, filelist)):
        if count<25:
            outfile.write(line)
            count+=1
        elif count==25:
            outfile.write(",")
            count+=1
        elif count>26 and count <51 :
            outfile.write(line)
            count+=1
        elif count>76 and count<101:
            outfile.write(line)
            count+=1
        elif count>150 and count<175:
            outfile.write(line)
            count+=1
        elif count>248 and count<272:
            outfile.write(line)
            count+=1
        elif count==273:
            outfile.write("\t}")
            count+=1
        elif count==274:
            outfile.write("\n]")
            count+=1
        else:
            count+=1
            pass


'''

