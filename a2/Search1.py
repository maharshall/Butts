import sys

def buildIndex(filename):
	#todo

def search(index, keyword):
	#todo


#######################################
if not len(sys:argv[1:]) < 2:
	print "Usage <file> <keyword>"
	sys.exit()

filename = sys.argv[1]
keyword = sys.argv[2]
time = 2.0

#build index
print "Took %f milliseconds to search for keyword %s" % (time, keyword)
