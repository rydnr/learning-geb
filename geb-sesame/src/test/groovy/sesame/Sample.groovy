import geb.Browser
Browser.drive {
    go "http://google.com/"

    //verify if we are on the correct page
    assert title=="Google"

    //enter softwaretestinghelp.com into the search field
    $("input",name:"q").value("softwaretestinghelp.com")

    //wait for the change to results page to happen
    //(google updates the page dynamically without a new request)
    waitFor{ title.endsWith("Google Serach")}

    //is the first link to softwaretestinghelp.com?
    def firstLink = $("li.g",0).find("a.l")
        //    assert firstLink.text() == "Software Testing Help - A Must Visit Software Testing Portal"

    //click the link
    firstLink.click()

    //wait for Google's javascript
    waitFor { title == "Software Testing Help - A Must Visit Software Testing Portal" }
}
