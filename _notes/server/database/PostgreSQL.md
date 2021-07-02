PostgreSQL
==============

1. Locally default port is 5432
2. create a database:
   \list to show all the databases
   \connect to connect to a database
3.
## Install PSQL
  
  ###1. $ brew install postgresql
  ###2. add a line like the following to .bash_profile (reload everytime when start a terminal)
    export PATH=$PATH:/Applications/Postgres.app/Contents/Versions/9.3/bin
    -> add the in directory to your path.
  ###3. restart the terminal
  ###4. $ psql -h localhost -> start

  ###5. configure Gemfile -> gem 'pg', '0.12.2'
  ###6. configure database.yml
      (Note: you do not need db/xx in the database part cause postgres is not like sqlite3 provided a file under db folder.)

  eg: 
  adapter: postgresql
  encoding: utf8
  database: sample_app_development
  host: localhost
  pool: 5
  timeout: 5000
  username: Damon
  password:

###7. configure .gitignore # Ignore bundler config
eg.:

/.bundle

# Ignore the default SQLite database.
/db/*.sqlite3

# Ignore all logfiles and tempfiles.
/log/*.log
/tmp

# Ignore other unneeded files.
database.yml  # For security
doc/          # Rails documentation files
*.swp         # Vim and Emacs swap files
*~
.project
.DS_Store     # weird created by the Mac Finder application
.idea

###8. Create DB based on database.yml
/Applications/Postgres.app/Contents/Versions/9.3/bin/createdb [db name]

###9. update
   
   $ bundle update
   $ bundle install
   $ bundle exec rake db:migrate

NOTE: if you are running your rails server in different mode locally like production mode, you need to use the following line to perform you db migration.

   $ RAILS_ENV=production rake db:migrate

4. wiht rails :
   $ rake db:create:all
   $ rake db:migrate



###10
Note: One database shared for two application
1. all the migration should be done in iSignin
2. schema.rb here is copied form iSignin
3. copied the model needed from iSignin
4. server configuration for each project


-----

# Seven db in Seven weeks

1. http://postgis.net/install/ install contributed packages
   
   $ brew install postgis
   $ psql -c "CREATE EXTENSION postgis";

2. $ brew info postgres

3. PostgreSQL transactions follow ACID compliance, which stands for Atomic
(all ops succeed or none do), Consistent (the data will always be in a good
state—no inconsistent states), Isolated (transactions don’t interfere), and
Durable (a committed transaction is safe, even after a server crash).

4. CAP proves that you can create a distributed database that is consistent (writes
are atomic and all subsequent requests retrieve the new value), available (the
database will always return a value as long as a single server is running), or
partition tolerant (the system will still function even if server communication
is temporarily lost—that is, a network partition), but you can have only two
at once.

The database you choose
will lose availability or consistency. Partition tolerance is strictly an architectural
decision (will the database be distributed or not).

5. use 

```
EXPLAIN VERBOSE
SELECT *
FROM holidays;
```

to check the details of a command

6. Full-Text and Multidimensions

   * Bride of Levenshtein

   * Trigram

   * A tsvector is a datatype that splits a string into an array (or a vector) of tokens, which are searched against the given query, while the tsquery represents a query in some language, like English or French.

   In your console, you can view the output of the stop words under the English tsearch_data directory.

7. All of the installed configurations can be viewed with this command:
   
   ```book=# \dF   ```

   ```book=# \dFd```

8. We’ll use Generalized Inverted iNdex (GIN)—like GIST, it’s an index API—to create an index of lexeme values we can query against.   

9.  * LIKE and regular expressions require crafting patterns that can match strings precisely according to their format. 
    * Levenshtein distance allows finding matches that contain minor misspellings but must ultimately be very close to the same string. 
    * Trigrams are a good choice for finding reasonable misspelled matches. 
    * Finally, full-text searching allows natural-language flexibility, in that it can ignore minor words like a and the and can deal with pluralization.

10. Enter the metaphones, which are algorithms for creating a string representation of word sounds.

11. Genres as a Multidimensional Hypercube

12. Useful postgres command

    https://gist.github.com/rgreenjr/3637525





