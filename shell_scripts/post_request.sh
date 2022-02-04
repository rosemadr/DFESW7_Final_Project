#!/bin/sh

set -eu

DOC=$1

curl -i -X POST -H 'Content-Type: application/json'  -d @$DOC http://localhost:8080/books/
