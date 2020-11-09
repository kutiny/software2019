#! /bin/bash

checkstyleErrors=`cat build/reports/checkstyle/main.xml | grep -e '<error' | wc -l`;
curl -X POST -H "Content-Type: application/json" -d "{\"percentage\": $checkstyleErrors}" http://gcsw.alexaguirre.com.ar/checkstyle > cs.txt;
cs=`cat cs.txt`;
rm cs.txt;
if [[ "$cs" != "OK" ]]; then
    echo "CHECKSTYLE FAILED!";
    exit 1;
else
    echo "CHECKSTYLE OK!";
fi


pmdErrors=`cat build/reports/pmd/main.xml | grep -e '<violation' | wc -l`;
curl -X POST -H "Content-Type: application/json" -d "{\"percentage\": $pmdErrors}" http://gcsw.alexaguirre.com.ar/pmd > pmd.txt;
pmd=`cat pmd.txt`;
rm pmd.txt;
if [[ "$pmd" != "OK" ]]; then
    echo "PMD FAILED!";
    exit 1;
else
    echo "PMD OK!";
fi

cpdErrors=`cat build/reports/cpd/cpdCheck.xml | grep -e '<duplication' | wc -l`;
curl -X POST -H "Content-Type: application/json" -d "{\"percentage\": $cpdErrors}" http://gcsw.alexaguirre.com.ar/cpd > cpd.txt;
cpd=`cat cpd.txt`;
rm cpd.txt;
if [[ "$cpd" != "OK" ]]; then
    echo "CPD FAILED!";
    exit 1;
else
    echo "CPD OK!";
    exit 0;
fi
