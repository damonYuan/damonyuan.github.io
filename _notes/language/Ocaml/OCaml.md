Ocaml
==============

Chapter 1. installation
   1. use OPAM
     1. brew install opam
     2. $ opam switch 4.02.1
        $ eval `opam config env`
     3. insall packages
        $ opam install batteries core
     4. $ ocaml    -> start right away (^D (Control D) to exit interactive session, ^C to interrupt)
        $ ocamlc -o hello hello.ml -> compile and execute the program 
        $ ocaml hello.ml -> in batch mode, to run script in session 
     5. opam install utop
        opam install core 
        add some items to my ~/.ocamlinit file:
        #use "topfind"
        #camlp4o
        #thread
        #require "core.top"
        #require "core.syntax"

   2. The ML languages are mostly functional, meaning that the normal programming style is functional
      Note: ML -> Meta-Language
      1. ML is a functional language, meaning that functions are treated as first-class values.
      2. ML is strongly typed, meaning that the type of every variable and every expression in a program is determined at compile-time.
      3. ML uses type inference to infer types for the expressions in a program.
      4. ML type system is polymorphic, meaning that it is possible to write programs that work for values of any type.
      5. ML implements a pattern matching mechanism that unifies case analysis and data destructors.
      6. ML includes an expressive module system that allows data structures to be specified and defined abstractly.
      7. Ocaml is also the only widely-available ML implementation to include an object system. The module system and object system complement one another: the module system provides data abstraction, and the object system provides inheritance and re-use.
      8. Ocamel includes a compiler that supports separate compilation.
      9. All the languages in the ML family have a formal semantics.

      compare with a comperative language.

Chapter 2. THE BASICS
   1. There is no performance difference between functions defined using let and functions defined using let rec, so if you prefer you could always use the let rec form and get the same semantics as C-like languages.
   2. If a function returns nothing (void for C and Java programmers), then we write that it returns the unit type. 
   3. In OCaml we use a special placeholder to mean "any type you fancy". It's a single quote character followed by a letter. 
   4. Polymorphism in Objective-C is the fairly standard subtype polymorphism you find in most class based object oriented languages. It means that an instance of a class can also be treated as an instance of any of its superclasses.

3. The Structure of OCaml Programs
   1. In the OCaml version, sum is just a shorthand name for the expression a +. b. There is no way to assign to sum or change its value in any way. 
   2. let name = expression in &block;; and let name = ref express;;
   3. nested function: let name arguments = function-definition in
   4. OCaml always capitalizes the first letter of the file name to get the module name 
   5. open Graphics;; Graphics.open_graph
   6. interactive level: #load "graphics.cma";; 
   7. variable naming: Punctuation is excluded, except for _ and ', and variables must start with a lowercase letter or an underscore. 

4. fix error: This argument cannot be applied with label ~f 
   $ open Core.Std ;;

5. ocamlc compiles to byte-code, and ocamlopt compiles to native machine code.
   $ ocamlc -g -c file.ml: file.cmo (ocamlopt programs produces a file file.cmx)
     The -g option causes debugging information to be included in the output file.
   $ ocamlc -g -o program x.cmo y.cmo 
     link the .cmo files 
   $ ./program 

Chapter 3. Variables and Functions
   1. The keywords `begin ... end` are equivalent to parentheses
   2. 



   





