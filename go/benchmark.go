package main

import(
	"fmt"
	"os"
	"helper"
//	"strconv"
	"quicksort"
)

func main() {
//	if(os.Args[0] == nil){
//		fmt.Println("File usage: <stringlen> <arraylen>")
//	}

	t1 := os.Args[0]
	t2 := os.Args[1]

	stringlen := 10 //strconv.ParseInt(t1, 0, 64)
	arraylen := 10 //strconv.ParseInt(t2, 0, 64)

	helper.ResetTimer()
	var arr []string = helper.MakeArray(stringlen, arraylen)
	var time  = helper.ReadTimerMilliseconds()
	fmt.Printf("Generated %d strings of length %d in %.4f ms\n", arraylen, stringlen, time)
    	for _, x := range(arr) {
       	fmt.Println(x)
    	}

    	helper.ResetTimer()
    	quicksort.sort(arr, 0, arraylen-1)
    	time  = helper.ReadTimerMilliseconds()
	fmt.Printf("Sorted %d strings of length %d in %.4f ms\n", arraylen, stringlen, time)
    	for _, x := range(arr) {
       	fmt.Println(x)
    	}

}