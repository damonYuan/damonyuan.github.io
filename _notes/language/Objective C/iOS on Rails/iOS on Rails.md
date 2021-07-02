iOS on Rails
==============

1. Use local_env.yml to set local environment
     # opens the config/local_env.yml file, reads each key/value pair, and sets environment variables.
    config.before_configuration do
      env_file = File.join(Rails.root, 'config', 'local_env.yml')
      YAML.load(File.open(env_file)).each do |key, value|
        ENV[key.to_s] = value
      end if File.exists?(env_file)
    end

   
2. API
   1. gem for API: versionist, rocket_pants, 
   2. manually: http://railscasts.com/episodes/350-rest-api-versioning

3. namespace and scope
   namespace :blog do
     resources :contexts
   end

    blog_contexts GET    /blog/contexts(.:format)          {:action=>"index", :controller=>"blog/contexts"}
                  POST   /blog/contexts(.:format)          {:action=>"create", :controller=>"blog/contexts"}
 new_blog_context GET    /blog/contexts/new(.:format)      {:action=>"new", :controller=>"blog/contexts"}
edit_blog_context GET    /blog/contexts/:id/edit(.:format) {:action=>"edit", :controller=>"blog/contexts"}
     blog_context GET    /blog/contexts/:id(.:format)      {:action=>"show", :controller=>"blog/contexts"}
                  PUT    /blog/contexts/:id(.:format)      {:action=>"update", :controller=>"blog/contexts"}
                  DELETE /blog/contexts/:id(.:format)      {:action=>"destroy", :controller=>"blog/contexts"}

    scope :module => 'blog' do
      resources :contexts
    end

     contexts GET    /contexts(.:format)           {:action=>"index", :controller=>"blog/contexts"}
              POST   /contexts(.:format)           {:action=>"create", :controller=>"blog/contexts"}
  new_context GET    /contexts/new(.:format)       {:action=>"new", :controller=>"blog/contexts"}
 edit_context GET    /contexts/:id/edit(.:format)  {:action=>"edit", :controller=>"blog/contexts"}
      context GET    /contexts/:id(.:format)       {:action=>"show", :controller=>"blog/contexts"}
              PUT    /contexts/:id(.:format)       {:action=>"update", :controller=>"blog/contexts"}
              DELETE /contexts/:id(.:format)       {:action=>"destroy", :controller=>"blog/contexts"}

      Scope
The scope method gives you fine-grained control:

scope 'url_path_prefix', module: 'module_prefix', as: 'named_route_prefix' do
  resources :posts
end
For example:

scope 'foo', module: 'bar', as: 'baz' do
  resources :posts
end
produces these routes:

$ rake routes
       Prefix Verb   URI Pattern                   Controller#Action
    baz_posts GET    /foo/posts(.:format)          bar/posts#index
              POST   /foo/posts(.:format)          bar/posts#create
 new_baz_post GET    /foo/posts/new(.:format)      bar/posts#new
edit_baz_post GET    /foo/posts/:id/edit(.:format) bar/posts#edit
     baz_post GET    /foo/posts/:id(.:format)      bar/posts#show
              PATCH  /foo/posts/:id(.:format)      bar/posts#update
              PUT    /foo/posts/:id(.:format)      bar/posts#update
              DELETE /foo/posts/:id(.:format)      bar/posts#destroy
Namespace
The namespace method is the simple case — it prefixes everything.

namespace :foo do
  resources :posts
end
produces:

$ rake routes
       Prefix Verb   URI Pattern                   Controller#Action
    foo_posts GET    /foo/posts(.:format)          foo/posts#index
              POST   /foo/posts(.:format)          foo/posts#create
 new_foo_post GET    /foo/posts/new(.:format)      foo/posts#new
edit_foo_post GET    /foo/posts/:id/edit(.:format) foo/posts#edit
     foo_post GET    /foo/posts/:id(.:format)      foo/posts#show
              PATCH  /foo/posts/:id(.:format)      foo/posts#update
              PUT    /foo/posts/:id(.:format)      foo/posts#update
              DELETE /foo/posts/:id(.:format)      foo/posts#destroy



              

4. Setting up Heroku Environment Variables for S3 secret key.
   
   NOTE: we can use CloudFront instead. Better service.


5. Gem for OAuth2: doorkeeper

6. Gem for JSON: 

7. show json in browser
   1. respond_to respond_with
   2. jbuilder