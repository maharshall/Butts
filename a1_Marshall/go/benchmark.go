package main

import(
	"fmt"
	"os"
	"helper"
	"strconv"
	"quicksort"
)

func main() {
	if(os.Args[1] == ""){
		fmt.Println("File usage: <stringlen> <arraylen>")
		return
	}

	t1 := os.Args[1]
	t2 := os.Args[2]

	stringlen, _ := strconv.Atoi(t1)
	arraylen, _ := strconv.Atoi(t2)

	helper.ResetTimer()
	var arr []string = helper.MakeArray(stringlen, arraylen)
	var time  = helper.ReadTimerMilliseconds()
	fmt.Printf("Generated %d strings of length %d in %.4f ms\n", arraylen, stringlen, time)
/*    	for _, x := range(arr) {
       	fmt.Println(x)
    	} */

    	helper.ResetTimer()
    	quicksort.Sort(arr, 0, arraylen-1)
    	time  = helper.ReadTimerMilliseconds()
			fmt.Printf("Sorted %d strings of length %d in %.4f ms\n", arraylen, stringlen, time)
/*    	for _, x := range(arr) {
       	fmt.Println(x)
    	} */

}
