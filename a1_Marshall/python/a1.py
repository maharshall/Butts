def quicksort(strings):
	size = len(strings)
	sort(strings, 0, size-1)

def sort(strings, start, end):
	if(start < end):
		pivot = strings[end]
		i = start
		j = end

		while(i != j):
			if(strings[i] < pivot):
				i = i+1
			else:
				strings[j] = strings[i]
				strings[i] = strings[j-1]
				j = j-1

		strings[j] = pivot
		sort(strings, start, j-1)
		sort(strings, j+1, end)