Bootstrap
==============
1. full screen carousel
   http://test.arturssmirnovs.com/demo/bootstrap_carusel_100_procent/
   css3: calc(100% - 50px);

   or:
   body {
     padding-top: 50px;
   }
   100% height for carousel;
   // Commnet this way will lead to carousal location on the top rather than below the nav

2. Modal show on top:
   put the modal at the very bottom of body and not include in any section or div.

3. SASS Syntax

4. Why put bootstrap into app/assets rather than vendor/assets?
   http://stackoverflow.com/questions/18371318/installing-bootstrap-3-on-rails-app

   $ rails console
   > Rails.application.config.assets.paths

   //= require_tree .
   Higher up, which is loading everything, apparently in alphabetical order. Remove that (obviously making sure that everything is required elsewhere) and you should be fine. You might be able to make that the last line of your application.js but I don't remember the specified behaviour when two statements end up requiring the same file

   http://www.dinduks.com/rails-load-assets-in-a-specific-order/

   In config/application.rb, add the following after class Application < Rails::Application. It should look like this:
   class Application < Rails::Application
    config.assets.paths << "#{Rails}/vendor/assets/fonts"

    http://rvg.me/2013/11/using-bootstrap-3-with-rails-4/

5. $ bundle open jquery-rails

6. Don't put a <div class="modal"> inside the navbar. Or the modal view will dim.

7. //= require bootstrap should be above //= require jquery.js or the dropdown will not show.