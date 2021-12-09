#!/bin/bash

g++ Main.cpp -o cadena
(time ./cadena) > cadena_result 2>&1
