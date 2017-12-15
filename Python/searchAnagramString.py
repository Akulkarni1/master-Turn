#-------------------------------------------------------------------------------
# Name:        searchAnagram
# Purpose:
#
# Author:      Amit
#
# Created:     15-12-2017
# Copyright:   (c) Amit 2017
#-------------------------------------------------------------------------------
def searchAnagramString(text,pattern):
    count = 0;
    n = len(text)
    m = len(pattern)
    if n<m or m==0 or n==0:
        return 0;
    testhist=[]
    pathist=[]
    i =0;
    while i<m:
        pathist[pattern[i]]
        testhist[test[i]]

    while(++i<n):
        if equalHistogram(textHist, patHist):
            print("anagram found : "+text.substring(i-m, i))
			count = count+1

        textHist[text[i]]++
        textHist[text[i-m]]--


def equalHistogram(testhist, pathhist):
    for i in rangelen(testhist):
        if testhist[i]!= pathhist[i]:
            return False
    return True

equalHistogram ("amit","am"):
