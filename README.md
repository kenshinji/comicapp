# Comic Application
An application for fetching comics from XKCD and Poorly Draw Lines

## How to run application

Make sure that Docker is properly installed, then build and run the application with following command.

```shell script
docker-compose up
```

## How to run tests
Make sure that maven and jdk >= 8 properly installed, then run following command.

```
mvn test
```


## Endpoint

To retrieve the comics from the repository, please hit the url
```
http://localhost:8080/comics
```

## API Response
An example of the application response is as below.

```
[
    {
        "pictureURL": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/G9tknt5FqZk/",
        "title": "Everything Changes",
        "browserURL": "http://www.poorlydrawnlines.com/?p=7818",
        "publishingDate": "2020-11-13"
    },
    {
        "pictureURL": "https://imgs.xkcd.com/comics/final_exam.png",
        "title": "Final Exam",
        "browserURL": "null2385",
        "publishingDate": "2020-11-13"
    },
    {
        "pictureURL": "https://imgs.xkcd.com/comics/set_in_the_present.png",
        "title": "Set in the Present",
        "browserURL": "null2384",
        "publishingDate": "2020-11-11"
    },
    {
        "pictureURL": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/UFFv5ZtO7ng/",
        "title": "No Free Time",
        "browserURL": "http://www.poorlydrawnlines.com/?p=7814",
        "publishingDate": "2020-11-09"
    },
    {
        "pictureURL": "https://imgs.xkcd.com/comics/electoral_precedent_2020.png",
        "title": "Electoral Precedent 2020",
        "browserURL": "null2383",
        "publishingDate": "2020-11-09"
    },
    {
        "pictureURL": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/aYMUW3Lhy-U/",
        "title": "Busy Day",
        "browserURL": "http://www.poorlydrawnlines.com/?p=7811",
        "publishingDate": "2020-11-06"
    },
    {
        "pictureURL": "https://imgs.xkcd.com/comics/ballot_tracker_tracker.png",
        "title": "Ballot Tracker Tracker",
        "browserURL": "null2382",
        "publishingDate": "2020-11-06"
    },
    {
        "pictureURL": "https://imgs.xkcd.com/comics/the_true_name_of_the_bear.png",
        "title": "The True Name of the Bear",
        "browserURL": "null2381",
        "publishingDate": "2020-11-04"
    },
    {
        "pictureURL": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/tSC6q8oVlpw/",
        "title": "Time is Moving",
        "browserURL": "http://www.poorlydrawnlines.com/?p=7807",
        "publishingDate": "2020-11-02"
    },
    {
        "pictureURL": "https://imgs.xkcd.com/comics/election_impact_score_sheet.png",
        "title": "Election Impact Score Sheet",
        "browserURL": "null2380",
        "publishingDate": "2020-11-02"
    },
    {
        "pictureURL": "https://imgs.xkcd.com/comics/probability_comparisons.png",
        "title": "Probability Comparisons",
        "browserURL": "null2379",
        "publishingDate": "2020-10-30"
    },
    {
        "pictureURL": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/-rEcCIWq6bk/",
        "title": "Hard Truths",
        "browserURL": "http://www.poorlydrawnlines.com/?p=7804",
        "publishingDate": "2020-10-28"
    },
    {
        "pictureURL": "https://imgs.xkcd.com/comics/fall_back.png",
        "title": "Fall Back",
        "browserURL": "null2378",
        "publishingDate": "2020-10-28"
    },
    {
        "pictureURL": "https://imgs.xkcd.com/comics/xkcd_phone_12.png",
        "title": "xkcd Phone 12",
        "browserURL": "null2377",
        "publishingDate": "2020-10-26"
    },
    {
        "pictureURL": "https://imgs.xkcd.com/comics/curbside.png",
        "title": "Curbside",
        "browserURL": "null2376",
        "publishingDate": "2020-10-23"
    },
    {
        "pictureURL": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/-fCbz77uo-M/",
        "title": "About Me",
        "browserURL": "http://www.poorlydrawnlines.com/?p=7800",
        "publishingDate": "2020-10-21"
    },
    {
        "pictureURL": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/wOvb1cOd-jk/",
        "title": "What’s Happening",
        "browserURL": "http://www.poorlydrawnlines.com/?p=7797",
        "publishingDate": "2020-10-19"
    },
    {
        "pictureURL": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/EKcE_QiSL8U/",
        "title": "Listen to Me",
        "browserURL": "http://www.poorlydrawnlines.com/?p=7793",
        "publishingDate": "2020-10-07"
    },
    {
        "pictureURL": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/F0HLswsMriU/",
        "title": "Look At Myself",
        "browserURL": "http://www.poorlydrawnlines.com/?p=7790",
        "publishingDate": "2020-10-05"
    },
    {
        "pictureURL": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/zDEkyPcngHE/",
        "title": "Cool Ghost",
        "browserURL": "http://www.poorlydrawnlines.com/?p=7786",
        "publishingDate": "2020-10-02"
    }
]
```