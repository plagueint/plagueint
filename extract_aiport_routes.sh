#!/bin/bash

#Ce script utilise les fichiers airports.dat et routes.dat et ressort les liens entres les pays qui existent

#trop lent:
#cat routes.dat | cut -d"," -f2,4 >> air.txt
#for i in $(cat airports.dat | cut -d"," -f1); do
#	echo $i
#	country=$(cat airports.dat | grep ^$i, | cut -d"," -f4 )
#	echo $country
#	sed -i -e "s#$i#$country#g" air.txt
#done

nb=$(cat routes.dat | wc -l)
for i in $(cat routes.dat | cut -d"," -f4); do
	line=$(sed -n "$i p" routes.dat)
	echo $i
	sourceid=$(echo $line | cut -d"," -f2)
	echo $sourceid
	destinationid=$(echo $line | cut -d"," -f6)
	sourceairport=$(cat airports.dat | grep ^$sourceid, | cut -d"," -f2)
	destinationairport=$(cat airports.dat | grep ^$destinationid, | cut -d"," -f2)
	echo -n $sourceairport.$destinationaiport >> air.txt
done
