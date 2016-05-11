#!/usr/bin/env bash
set -euo pipefail
IFS=$'\t\n'
set -x

echo "hello" | grep hello

URL=localhost:8080

http $URL
http $URL/hello/Friboo
# german: "Hallo, %w"
http PUT $URL/greetings/german template="Hallo, %s!"
http $URL/greetings/german/Friboo # Hallo, Friboo
http PUT $URL/greetings/chinese template="Ni hao!"
http $URL/greetings/chinese/Friboo # Ni hao!
http DELETE $URL/greetings/chinese
http $URL/greetings/chinese/Friboo
