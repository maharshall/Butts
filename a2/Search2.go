package main

import (
	"fmt"
	"os"
	"bufio"
	"strings"
	"time"
)

type Index map[string][]string

func buildIndex(filename string) Index {
	f, err := os.Open(filename)
	if err != nil {
		fmt.Printf("Cannot open file %s \n", filename)
		os.Exit(0)
	}

	courses := make(Index)

	reader := bufio.NewReader(f)
	for line, err := reader.ReadString('\n');
       	err == nil;
       	line, err = reader.ReadString('\n') {
       	info := strings.Split(line, "            ")
       	title := strings.Split(info[1], " ")
       	for _, val := range title {
       		courses[val] = append(courses[val], info[0])
       	}
    	}

	return courses
}

func search(index Index, keyword string) {
	for key, val := range index {
		if(strings.ToLower(key) == strings.ToLower(keyword)) {
			for _, str := range val {
				fmt.Println(str)
			}
		}
	}
}

func main() {
	if len(os.Args) < 3 {
		fmt.Println("Usage <filename> <keyword>")
		os.Exit(0)
	}

	filename, keyword := os.Args[1], os.Args[2]
	courses := buildIndex(filename)
	start := time.Now()
	search(courses, keyword)
	duration := time.Now().Sub(start)*1000
	fmt.Println("Took ", duration, " milliseconds to search for keyword ", keyword)
}