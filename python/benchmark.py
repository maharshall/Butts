#Un-comment print lines to verify sorting function works
import a1
import sys
import helper

if(sys.argv[1] == None):
	print "File usage: <stringlen> <arraylen>"

stringlen = int(sys.argv[1])
arraylen = int(sys.argv[2])

helper.resetTimer()
arr = helper.makeArray(stringlen, arraylen)
time = helper.readTimerMilliseconds()
#print "\n".join(arr)
print "------------>Took: %d ms to construct" %time

helper.resetTimer()
a1.quicksort(arr)
time = helper.readTimerMilliseconds()
#print "\n".join(arr)
print "------------>Took: %d ms to sort" %time
