#!/usr/bin/python

import psycopg2;


conn = psycopg2.connect(database="temp", user = "postgres", password = "sa", host = "127.0.0.1", port = "5432")

print ("Opened database successfully");
cur = conn.cursor()

cur.execute("SELECT gid, geom FROM public.\"be-water-area_multipolygon\" ");
rows = cur.fetchall()

