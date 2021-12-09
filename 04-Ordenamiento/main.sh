#!/bin/bash

cat entrada | (time python ./quickSort.py) > cadena_result 2>&1

cat entrada | (time python ./shell_sort.py) > cadena_result_shell 2>&1

diff cadena_result cadena_result_shell
