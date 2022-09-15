
# https://medium.com/learning-the-go-programming-language/calling-go-functions-from-other-languages-4c7d8bcc69bf

# linux
# go build -buildmode=c-shared -o bin/lib-sanitize.so ./main.go
# file bin/lib-sanitize.so
# nm bin/lib-sanitize.so | grep -e "T _Add"

# mac
go build -buildmode=c-shared -o bin/lib-sanitize.dylib ./main.go
file bin/lib-sanitize.dylib
nm bin/lib-sanitize.dylib | grep -e "T _Add"

