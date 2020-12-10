# NYTimesMPA
New York Times Most Popular Articals

Build a simple app to hit the NY Times Most Popular Articles API and show a list of articles,
that shows details when items on the list are tapped (a typical master/detail app).

---------------------------------------------------------------------------------------
I used the following technologies to make that task
# MVVM, Hilt, RXjava3, Retrofit, ViewModel, LiveData, Binding, Room, ConstraintLayout, Glide, gson, custom ToolBar, and Solid principles.
#ANDROID DEVELOPER CHALLENGE
------------------------------------------------------------------------------

## Requirements
* Object oriented programming approach
* Good UI approach e.g. MVC, MVVM, MVP, etc. Please specify the pattern used
* Unit tests using Junit, XCTest, to achieve good code coverage
* Some UI tests using espresso, XCUITest, etc.
* Code to be generic and simple
* Leverage today's best coding practices e.g. Swift, Android coding standards
* Clear README.md that explains how the code and the test can be run and how thecoverage reports can be generated
## API Details
We'll be using the most viewed section of this API. Note: you need to signup for an API key 
at: - [Here](https://developer.nytimes.com/get-started), then replace the ‘sample-key’
below with the API key assigned to your account.
You need to fetch the data from [Most viewed Articles](http://api.nytimes.com/svc/mostpopular/v2/mostviewed/{section}/{period}.json?apikey=sample-key) endpoint. 
To test this API, you can use all-sections for the section path component in the URL above and 7 for period 
(available period values are 1, 7 and 30, which represents how far back, in days, the API returns results for).

http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all- sections/7.json?apikey=sample-key
## Git Repositories:

<img src="https://github.com/Mahmoud-zahran/NYTimesMPA/blob/main/home.png" width="20%"></img></br></br>  
<img src="https://github.com/Mahmoud-zahran/NYTimesMPA/blob/main/connection%20lost.png" width="20%"></img></br></br>                       
                     

## Libraries Used:
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [RxJava3](https://github.com/ReactiveX/RxJava)
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- [ViewBinding](https://developer.android.com/topic/libraries/view-binding)
- [Retrofit](https://square.github.io/retrofit/#:~:text=Retrofit%20Configuration,are%20turned%20into%20callable%20objects.)
- [Room](https://developer.android.com/training/data-storage/room)
