import sys
import time

def buildIndex(filename):
	try:
		f = open(filename, "r")
	except:
		print "Cannot open file %s! Maybe you made a typo :(" % filename
		sys.exit()

	courses = {}

	for line in f.readlines():
		info = line.split("            ")
		code = info[0]
		title = info[1]
		keys = title.split(" ")
		for i in keys:
			if i in courses:
				courses[i].append(code)
			else:
				courses[i] = [code]	 
	
	return courses

def search(index, keyword):
	for target in index.keys():
		if keyword.lower() == target.lower():
			for i in range(len(index[target])):
				print index[target][i]

def resetTimer():
  global START
  START = time.time()

def readTimerMilliseconds():
  t = time.time() - START
  return (t * 1000)


#----------------------------------------------
if len(sys.argv[1:]) < 2:
	print "Usage <file> <keyword>"
	sys.exit()

filename = sys.argv[1]
keyword = sys.argv[2]

courses = buildIndex(filename)
resetTimer()
search(courses, keyword)
print "Took %f milliseconds to search for keyword %s" % (readTimerMilliseconds(), keyword)

