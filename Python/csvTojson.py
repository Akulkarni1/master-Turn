import csv
import json
from datetime import datetime
rows = []
csv_rows=[]
def csv_reader(file_obj):
    reader = csv.reader(file_obj)
    for r in reader:
        csv_rows.append(r)



def diff(t1,t2):
    FMT = '%H:%M:%S'
    tdelta = datetime.strptime(t2, FMT) - datetime.strptime(t1, FMT)
    return str(tdelta)




csv_path = "C:\\Users\\Amit\\Downloads\\train_data.csv"
with open(csv_path, "rb") as f_obj:
    csv_reader(f_obj)
itercsv = iter(csv_rows)

(next(itercsv)) #skip header row
for row in itercsv:
        dist1={}
        dist1["origin"]={"name":row[csv_rows[0].index("origin_name")],"code":row[csv_rows[0].index("origin_code")],
                "departure":{"scheduled":row[csv_rows[0].index("origin_departure_scheduled")],
                             "diff":diff(row[csv_rows[0].index("origin_departure_scheduled")],row[csv_rows[0].index("origin_departure_actual")]),
                             "actual":row[csv_rows[0].index("origin_departure_actual")]}}
        dist1["train"]={"date":row[csv_rows[0].index("train_date")],"code":row[csv_rows[0].index("train_code")]}
        dist1["destination"] = {"departure": {"scheduled": row[csv_rows[0].index("destination_arrival_scheduled")],
                                         "diff": diff(row[csv_rows[0].index("destination_arrival_scheduled")],
                                                      row[csv_rows[0].index("destination_arrival_actual")]),
                                         "actual": row[csv_rows[0].index("destination_arrival_actual")]},"name": row[csv_rows[0].index("destination_name")], "code": row[csv_rows[0].index("destination_code")]}
        rows.append(dist1.copy())
json = json.dumps(rows,indent=4, sort_keys=True)
#final output
print json
result = open("C:\\Users\\Amit\\result.json","w")
result.write(json)