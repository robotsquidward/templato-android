# Templato

When you need a slightly more in-depth sample for a simple Android app.

## Why I made this

When you trace back the genelogy of an Android app you don't really find a specifc branching point where all apps depart from, except maybe the ones provided by Android Studio itself.   You can't really prescribe any template to cover all the many use cases that Android apps cover that would be much more helpful than the very basics.

The problem becomes that every time I want to spin up a new project, I still just go into Android Studio, start with a basic Activity, and start at work cranking out the boiler plate code I know I'll need for my project.  After building a couple of basic apps with basic navigation - just different enough (or coded differently enough) to warrant wanting a blank slate to start on next time - you start to wonder if there's anything else you can do to give yourself a head start on your next app.

Just to nail the point home, the Android Bottom Navigation Sample app contains an Activity and it's layout with a TextView and navigation.  It doesn't even have a Fragment or layout for any of the three tabs, or any additional common Android components.

![android sample apps](android-sample-screenshot.png)

This makes a lot of sense for the broadest use cases.  Google is not trying to tell you how to do Fragment navigation because there's more than one way to do it.  They're not going to build out layouts because they have no idea how you're going to be utilizing each screen, or even how you'll be implementing the bottom nav at all, maybe you'll be using them as controls for your game.

But for me (and I'm guessing a handful of others) I know I will want to do some basic stuff with my Bottom Nav based app.  I know I want my Fragments to hold layouts.  I know I want my Activity to handle navigation.  I know I want to use an Android ViewModel to manage data across the activity and it's fragments.  I'll probably use a RecyclerView.  This is the kind of thing I want to have handy or be able to easily reference when I'm cranking out boiler plate.

## Enter Templato 

Templato is a sample application I'm putting together to build a launch pad for my next simple Android App.  It's not going to work for everyone, or every app or idea, but I think it will work for me the next time I want to spin up an MVP.

### What Templato is

* A basic 'template' Android app
* An example of using Bottom Navigation in Android to swap Fragments and their layouts
* An example of implementing a `RecyclerView`
* An example of using the Android `ViewModel`
* An example of using `LiveData`
* Open source

### What Templato is not

* It's not going to work for every app, or even every Bottom Navigation based app.  
* I'm also not a Google developer - I'm not writing Android API samples and prescribing how you should code - so Templato is not an official reference.

## Using Templato

You can clone or download Templato from GitHub.

### Change the Title

Update the `app_name` in the `strings.xml` file.

```xml
<string name="app_name">Templato</string>
```

### Update Style

Templato uses a NoActionBar style.  To change that, or to update or override any other styles - do it in the `styles.xml`.
