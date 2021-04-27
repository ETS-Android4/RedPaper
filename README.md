Original App Design Project - README
===

# RedPaper

![me](https://github.com/CodePathRedditTeam/RedPaper/blob/main/Milestone%201.gif)

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
This app is a 3rd Party Android Client for Reddit, which will allow users a clean and straightforward way to browse Reddit without Ads. 

### App Evaluation
[Evaluation of your app across the following attributes]
- **Category: Social/Interaction**
- **Mobile:** This app is primarily designed for mobile but will be just as viable as a computer. Limited functionality for now. Update will soon be available.
- **Story:** Users can join large group and create forums in which registered users can talk about almost anything you can imagine, from news, to pop culture, to technology, to comics, to film, to literature, etc.
- **Market:** Any individual could choose to use this app. There will be age restriction and content filter options.
- **Habit:** THis app could be used as often or unoften as the user wanted depending on how deep thier social life is, and what exactly they're looking for.
- **Scope:** Useres can either start my creating a forum wiht a topic of their choosing or join one very simply and easily in hopes ton make this app users 1st option as a 3rd party app for reddit. 

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

- [x] User can Post a Thread
- [x] User logs in to access main page with posts
- [x] User can Register for new Account
- [ ] User picks what their favorite forum/ subreddit. 
- [ ] User have the ability to post and comment under subreddit. 
- [ ] Profile pages for each user
- [ ] Settings (Accesibility, Notification, General, etc.)

**Optional Nice-to-have Stories**

- [ ] news page with current events 
- [ ] page with what is the most popular forums on reddit
- [ ] User can chat using Reddits Chat Feature
- [ ] User can view RPan, Reddits Live Service


### 2. Screen Archetypes

* [Front Page of Reddit]
* Login
* Register - User signs up or logs into their account
    * Upon Download/Reopening of the application, the user is prompted to log in to gain access to their profile information so they can leave comments and replies.
* Comment Thread - Users Can Respond to Comments in an Endless Thread
    * Upon selecting another within the subreddit to communicate directly to.
* Profile Screen
    * Allows user to upload a photo and fill in information that is interesting to them and othersSong 
* Home Screen.
    * Allows user to be able to choose their desired forum to post or chat in.
* Settings Screen
    * Lets people change language, and app notification settings.

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Home
* Profile
* Settings
* Main Page
* SubReddit Page
* Comments Page

**Flow Navigation** (Screen to Screen)

* [Main Screen]
   * [Shows Homepage of Reddit Content]
   * [Login Button Available on the Top of Screen]
* [Login Screen]
   * [User can enter Username and Passord]
* [Login User Screen]
   * [Populates Homepage with Followed Subreddits]
* [Subreddit Selected]
   * [Populates Page with Posts from Selected Subreddit]
   * [Posts can be Upvoted or Downvoted]
* [Thread Selected]
   * [Populates Page with Thread and a Scrollable List of Comments]
   * [Comments Have a Reply Button and can be Upvoted or Downvoted]

## Wireframes
[Here is the handrawn wireframe]
<img src="https://i.imgur.com/Kh1zSbs.jpg"
width=600>
<img src="https://i.imgur.com/CloVQOk.jpg"
width=600>
<img src="https://i.imgur.com/eq38p03.jpg
"
width=600>
<img src="https://i.imgur.com/ePW5Qky.jpg
"
width=600>
[Here the digital wireframe]
<img src="https://i.imgur.com/ymNHMOa.jpg
"
width=600>
<img src="https://i.imgur.com/HuNrqgt.jpg
"
width=600>
<img src="https://i.imgur.com/9R7mxce.jpg"
width=600>
<img src="https://i.imgur.com/B9SsuLk.jpg
"
width=600>

## Schema

**Models**
**Post**

| Property  | Type | Description |
| ------------- | ------------- | ------------ |
| objectId  | String  | unique ID for the users Post 
| cObjectId  | String  | unique ID for the users comment
| image | File | image that user posts 
| title | String | title for users post
| upvoteCount | Number | number of upvotes on a post
| downvoteCount | Number | number of downvotes on a post
| createdAt | DateTime | date when post was created
| updatedAt | DateTime | date when post is last updated

**Networking**
[Network Request]
   * Internet Premission in the manifest file.
  
[Home Feed]
   * (Read/GET) Query all posts where user is author
    * (Create/POST) Create a new like on a post
    * (Delete) Delete existing like
    * (Create/POST) Create a new comment on a post
    * (Delete) Delete existing comment
    
[Create Post Screen]
* (Create/POST) Create a new post object
    

