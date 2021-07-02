HTML_CSS
==============

HTML_CSS

# In general, CSS rules refer either to a class, an id an HTML Tag, or some combination thereof, followed by a list of styling commands.

# the dot . in .center indicates that the rule styles a class.
  the pound # identifies a rule to style a CSS id.

# CSS id and CSS class
  CSS id -> appear on the page only once.
            Each element can have only one ID
            Each page can have only one element with that ID
  CSS class -> appear on the page repeatedly.
               You can use the same class on multiple elements
               You can use multiple classes on the same element

# Note the difference between float and test-align

# height: auto !important;
  !important just disables the normal cascade rules -> meaning that this rule must apply even if a more specific height declaration would normally override this one. Generally, it's better not to user !important, as it indicates that things could be better coded from scratch.

# 100% width
  Or, you could use a little trick call box-sizing. This CSS property allows you to change the box model used by an element. (You can read a more detailed description of the property on css-tricks). By changing the box model of our inputs to use the border-box model, we can use width:100%; and everything just works. - See more at: http://blog.jbrumond.me/posts/25#sthash.eMO4Zjxj.dpuf

# turbolinks to speed up

# the <header> element was introduced in HTML5 to provide additional semantic information about content that appears at the top of the page, such as logos, title text or navigation.

# change the autocomplete background color 
input:-webkit-autofill {
  -webkit-box-shadow: 0 0 0 1000px grey inset !important;
}

# iframe 
<iframe src="mypage.html" style="border: 0; width: 100%; height: 100%">
    Your browser doesn't support iFrames.
</iframe>
