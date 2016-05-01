#!/usr/bin/env bash
set -euo pipefail
IFS=$'\t\n'

http localhost:8080
http localhost:8080/hello/Friboo
