# Group6Backend
## Description

Recipelify is a Recipe creator which has the ability for the user to create their own recipes with a photo(s) of the recipe ingredients and their amounts, custom ingredients if it is not listed. A way for them to manage their own recipe.


## Tech Stack

* Spring Tools(Boot, Web, ORM) 
* Maven 
* Postgres AWS-RDS
* Food Data Central
* IDE’s: VS Code, Spring Suite

## VR diagram

[VR Diagram](https://github.com/JavaFS210601/Group6Backend/blob/kenng/VRdiagram.png)

#### Goals )
* User login
* Create new user   ( high )
* Change username and password  ( high  )

* Guest Usage & All
    1. Has access to the app but can't save selections until
    they make their own account   ( high  )
    2. Users should be able to create new recipes without login.  ( high  )
    3. Users should be able to view all the recipe  ( high  )
    4. Users should be able to search recipes by keyword ( of name ), rating ( high)

* Account Usage
    1. Mebmer user can save their recipes (high)
    2. If User wants to remember their favorite receipts , they need an account ( optional  )
    3. Leave comments  (optional)
    4. Give rating (optional)
 
Link to a video of them making the recipe ( optional) 

### Recipe Details
* Name (name of dish)
* Description (info about what the is like a summary, 
* Category 
    * Homestyle, Ethnic , desserts , drinks(smoothies,liquor,Soups and stews, etc.)
 
* Inspiration (Origin story if any)
* Ingredients amounts (each ingredient, and how much) 
* Steps


### Challenge:

1. Implementing many to many tables with Hibernate 
2. The json sending to the frontend is too complicated; therefore, DTO is used to simplify the json string
3. Implement update method which is not porvided by JPA framework