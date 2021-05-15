#!/bin/bash
#thank you Ronak Badhe for this shell script
git log --no-merges --format="%cd" --date=short | sort -u -r | while read DATE ; do
    echo 'Karthik B'
    echo [$DATE]
    GIT_PAGER=cat git log --no-merges --format="    * %s" --since="$DATE 00:00:00" --until="$DATE 24:00:00"
done
