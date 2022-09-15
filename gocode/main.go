package main

import "C"

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	println("Add(1, 2) =", Add(1, 2))
	Echo()
}

//export Add
func Add(a, b int) int {
	return a + b
}

//export Sanitize
func Sanitize(text string) string {
	// TODO: actually sanitize
	return "<" + text + ">"
}

func Echo() {
	scanner := bufio.NewScanner(os.Stdin)
	for scanner.Scan() {
		fmt.Println(scanner.Text()) // Println will add back the final '\n'
	}
	if err := scanner.Err(); err != nil {
		fmt.Fprintln(os.Stderr, "reading standard input:", err)
	}
}
