package quicksort

func Sort(strings []string, start int, end int){
	if(start < end){
		var pivot string = strings[end]
		var i = start
		var j = end

		for(i != j){
			if(strings[i] < pivot){
				i = i+1
			}else{
				strings[j] = strings[i]
				strings[i] = strings[j-1]
				j = j-1
			}
		}

		strings[j] = pivot
		sort(strings, start, j-1)
		sort(strings, j+1, end)
	}
}