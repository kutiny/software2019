#! /bin/bash

checkstyleErrors=`cat build/reports/checkstyle/main.xml | grep -e '<error' | wc -l`;
curl -X POST -H "Content-Type: application/json" -d "{\"percentage\": $checkstyleErrors}" http://gcsw.alexaguirre.com.ar/checkstyle > cs.txt;
cs=`cat cs.txt`;
rm cs.txt;
if [[ "$cs" != "OK" ]]; then
    echo "CHECKSTYLE FAILED!";
    wait 300000;
    exit 0;
fi


pmdErrors=`cat build/reports/pmd/main.xml | grep -e '<violation' | wc -l`;
curl -X POST -H "Content-Type: application/json" -d "{\"percentage\": $pmdErrors}" http://gcsw.alexaguirre.com.ar/pmd > pmd.txt;
pmd=`cat pmd.txt`;
rm pmd.txt;
if [[ "$pmd" != "OK" ]]; then
    echo "PMD FAILED!";
    wait 300000;
    exit 0;
fi

